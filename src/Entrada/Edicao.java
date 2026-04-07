package src.Entrada;

import src.Aluno;
import src.NomePessoa; // Se precisar instanciar um novo nome
import javax.swing.JOptionPane;

/**
 * Faz a ponte entre a interface grafica e o modelo de dados
 * 
 * @author Felipe Estima
 * @author Guilherme Pequeneza
 * @author Igor Dias
 * @author Thierry Nadjarian 
 * 
 * @version 06/04/26
 */

public class Edicao{
    private TelaEdicao tela;
    private Aluno alunoEditado;
    
    /**
     * Construtor da classe Edicao.
     * Inicializa o controlador, carrega os dados atuais do aluno para exibição nos campos
     * da interface e configura as ações dos botões.
     * 
     * @param tela A interface gráfica de edição que será exibida ao usuário.
     * @param aluno O objeto do tipo Aluno que terá seus dados modificados.
     */
    public Edicao(TelaEdicao tela, Aluno aluno) {
        this.tela = tela;
        this.alunoEditado = aluno;
        
        // Manda a tela mostrar os dados atuais do aluno
        this.tela.carregarDadosAluno(aluno);
        
        configurarEventos();
    }

    /**
     * Configura os ouvintes de eventos (ActionListeners) para os botões interativos da tela.
     * Mapeia o botão de confirmar para o método de salvamento e o botão de cancelar para fechar a janela.
     */
    private void configurarEventos() {
        tela.getBtnConfirm().addActionListener(e -> salvarEdicao());
        tela.getBtnCancel().addActionListener(e -> tela.dispose());
    }

    /**
     * Coleta as informações digitadas na tela, valida os dados e atualiza o objeto Aluno.
     * Impede que o usuário deixe campos de texto vazios e trata exceções caso letras
     * sejam digitadas em campos numéricos (Idade e Semestre). Em caso de sucesso, atualiza
     * a referência na memória e fecha a tela de edição.
     */
    private void salvarEdicao() {
        try {
            // Pega os novos valores que o usuário digitou
            String novoNome = tela.getTxtNome().getText().trim();
            int novaIdade = Integer.parseInt(tela.getTxtIdade().getText());
            String novaDisciplina = tela.getTxtDisciplina().getText().trim();
            int novoSemestre = Integer.parseInt(tela.getTxtSemestre().getText());

            if (novoNome.isEmpty() || novaDisciplina.isEmpty()) {
                JOptionPane.showMessageDialog(tela, "Nenhum campo pode ficar vazio!");
                return;
            }

            // Atualiza os dados direto no objeto Aluno
            // Como o objeto é uma referência na memória, alterar aqui já altera lá no vetor do Cadastro!
            alunoEditado.nome = new NomePessoa(novoNome);
            alunoEditado.idade = novaIdade;
            alunoEditado.setDisciplina(novaDisciplina);
            alunoEditado.setSemestre(novoSemestre);

            JOptionPane.showMessageDialog(tela, "Aluno atualizado com sucesso!");
            tela.dispose(); // Fecha a tela

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(tela, "Idade e Semestre devem ser números inteiros!");
        }
    }
}