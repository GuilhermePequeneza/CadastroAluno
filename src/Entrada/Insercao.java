package src.Entrada;

import javax.swing.*;
import src.Saida.*;
import src.Cadastro;
import src.Aluno;

/**
 * Gerencia a interação entre a interface
 * gráfica (TelaInsercao) e a estrutura de armazenamento (Cadastro).
 * 
 * @author Felipe Estima
 * @author Guilherme Pequeneza
 * @author Igor Dias
 * @author Thierry Nadjarian 
 * 
 * @version 06/04/26
 */
public class Insercao
{
    // Atributos
    private TelaInsercao tela;
    ISaida saida = new SaidaGrafica();     
    private Cadastro cadastro; 

    /**
     * Construtor do Controlador de Inserção.
     * Inicializa os atributos da classe e chama o método para configurar os eventos da tela.
     *
     * @param tela A interface gráfica contendo os campos de entrada de dados (View).
     * @param cadastro O objeto responsável por armazenar os dados dos alunos no sistema (Model/DAO).
     */
    public Insercao(TelaInsercao tela,Cadastro cadastro){
        // Atualiza atributos
        this.tela = tela;       
        this.cadastro = cadastro;
        // Configura componentes que realizam os eventos
        configurarEventos();
    }

    /**
     * Configura os ouvintes de eventos (ActionListeners) para os componentes visuais.
     * Mapeia o clique do botão de confirmação
     * para disparar o método de inserção. Também mapeia o botão de cancelar para fechar a tela.
     */
    private void configurarEventos() {
        // Configura evento click (mouse) para o botao
        tela.getBtnConfirm().addActionListener(e -> inserir());        
        // Configura evento click (mouse) para o botao
        tela.getBtnCancel().addActionListener(e -> tela.dispose());
    }

    /**
     * Coleta os dados preenchidos na interface gráfica, realiza as validações de regra 
     * de negócio (campos vazios, limites de idade, RA duplicado) e insere o novo aluno
     * no cadastro. Em caso de sucesso, fecha a janela de inserção. Trata exceções caso 
     * o usuário digite texto em campos exclusivamente numéricos.
     */
    private void inserir() {
        try {
            String nomeAluno = tela.getTxtNome().getText().trim();
            int idade = Integer.parseInt(tela.getTxtIdade().getText());
            String RA = tela.getTxtRA().getText().toUpperCase().trim();
            String disciplina = tela.getTxtDisciplina().getText().toUpperCase().trim();
            int semestre = Integer.parseInt(tela.getTxtSemestre().getText()); 
            
            if (nomeAluno.isEmpty() || RA.isEmpty() || disciplina.isEmpty()) {
                saida.mostrarMsg("Todos os campos devem ser preenchidos!");
                return;
            }

            if (idade < 1 || idade > 116) {
                saida.mostrarMsg("Idade deve ser entre 1 e 116!");
                return;
            }

            if (!cadastro.verificarRa(RA)) {
                saida.mostrarMsg("RA já cadastrado!");
                return;
            }
            
            Aluno Aluno = new Aluno(nomeAluno, idade, RA, disciplina, semestre);
            cadastro.inserir(Aluno);    
            tela.dispose(); // Fecha a janelinha de cadastro
            
        } catch (NumberFormatException ex) { // Captura valor invalido fornecido
            JOptionPane.showMessageDialog(
                    tela,
                    "Forneça Informaçoes Validas!!!",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
}
