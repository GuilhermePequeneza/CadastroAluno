package src.InsercaoAluno;

import javax.swing.*;
import src.Saida.*;
import src.Cadastro;
import src.Aluno;

/**
 * Escreva uma descrição da classe InsercaoController aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class InsercaoController
{
    // Atributos
    private TelaInsercao tela;
    ISaida saida = new SaidaGrafica();     
    private Cadastro cadastro; 

    /**
     * ConversorController construtor do Controller
     *
     * @param tela - tela grafica com os componentes (View)
     * @param conversor - conversor de temp C-F (model)
     */
    public InsercaoController(TelaInsercao tela,Cadastro cadastro){
        // Atualiza atributos
        this.tela = tela;       
        this.cadastro = cadastro;
        // Configura componentes que realizam os eventos
        configurarEventos();
    }

    /**
     * configurarEventos - configura componentes para receber os eventos
     *
     */
    private void configurarEventos() {
        // Configura evento click (mouse) para o botao
        tela.getBtnConfirm().addActionListener(e -> inserir());
        tela.getTxtNome().addActionListener(e -> inserir());
        tela.getTxtIdade().addActionListener(e -> inserir());
        tela.getTxtRA().addActionListener(e -> inserir());
        tela.getTxtDisciplina().addActionListener(e -> inserir());
        tela.getTxtSemestre().addActionListener(e -> inserir());
        // Configura evento click (mouse) para o botao
        tela.getBtnCancel().addActionListener(e -> tela.dispose());
    }

    /**
     * converter - converte a temperatura Celsius para Fahrenheit
     *
     */
    private void inserir() {
        try {
            String nomeAluno = tela.getTxtNome().getText();
            int idade = Integer.parseInt(tela.getTxtIdade().getText());
            String RA = tela.getTxtRA().getText();
            String disciplina = tela.getTxtDisciplina().getText();
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