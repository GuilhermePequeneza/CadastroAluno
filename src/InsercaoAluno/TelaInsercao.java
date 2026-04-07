package src.InsercaoAluno;

import javax.swing.*;
import java.awt.*;

/**
 * Escreva uma descrição da classe TelaInsercao aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class TelaInsercao extends JDialog
{
    // Atributos (componentes de tela)
    private JTextField txtNome; // Caixa de texto (editavel)
    private JTextField txtIdade; // Caixa de texto (editavel)
    private JTextField txtRA; // Caixa de texto (editavel)
    private JTextField txtDisciplina; // Caixa de texto (editavel)
    private JTextField txtSemestre; // Caixa de texto (editavel)
    private JButton btnConfirm;   // Botao de confirmar
    private JButton btnCancel;  // Botão de cancelar

    public TelaInsercao() {
        
        // Define atributos da janela
        this.setModal(true);
        
        setTitle("Inserçao de Aluno");
        setSize(780,480);        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); // Posiciona no centro
        
        // Criação dos componentes visuais (de interação)
        criarComponentes();
    }

    /**
     * criarComponentes - configura e cria os componentes visuais
     *
     */
    private void criarComponentes() {
        
        // Define o container (Painel) para os componentes
        // Utiliza um layout de matriz [2][2]
        JPanel painel = new JPanel(new GridLayout(6,2));
        
        // Cria e adiciona um label
        painel.add(new JLabel("Forneça o Nome do Aluno", SwingConstants.CENTER));

        // Cria e adiciona uma caixa de texto
        txtNome = new JTextField();
        txtNome.setToolTipText("Nome Aluno");
        txtNome.setHorizontalAlignment(JTextField.CENTER);
        painel.add(txtNome);
        
        // Cria e adiciona um label
        painel.add(new JLabel("Forneça a idade do Aluno", SwingConstants.CENTER));

        // Cria e adiciona uma caixa de texto
        txtIdade = new JTextField();
        txtIdade.setToolTipText("Idade do Aluno");
        txtIdade.setHorizontalAlignment(JTextField.CENTER);
        painel.add(txtIdade);
        
        // Cria e adiciona um label
        painel.add(new JLabel("Forneça o RA do Aluno", SwingConstants.CENTER));

        // Cria e adiciona uma caixa de texto
        txtRA = new JTextField();
        txtRA.setToolTipText("RA do Aluno");
        txtRA.setHorizontalAlignment(JTextField.CENTER);
        painel.add(txtRA);
        
        // Cria e adiciona um label
        painel.add(new JLabel("Forneça a disciplina Aluno", SwingConstants.CENTER));

        // Cria e adiciona uma caixa de texto
        txtDisciplina = new JTextField();
        txtDisciplina.setToolTipText("Disciplina do Aluno");
        txtDisciplina.setHorizontalAlignment(JTextField.CENTER);
        painel.add(txtDisciplina);
        
        // Cria e adiciona um label
        painel.add(new JLabel("Forneça o semestre do Aluno", SwingConstants.CENTER));

        // Cria e adiciona uma caixa de texto
        txtSemestre = new JTextField();
        txtSemestre.setToolTipText("Semestre do Aluno");
        txtSemestre.setHorizontalAlignment(JTextField.CENTER);
        painel.add(txtSemestre);

        // Cria e adiciona um botao
        btnConfirm = new JButton("Confirmar");
        btnConfirm.setToolTipText("Confirmar Informaçoes do aluno");
        painel.add(btnConfirm);

        // Cria e adiciona um botao
        btnCancel = new JButton("Cancelar");
        btnCancel.setToolTipText("Cancela Inserção de Informaçoes do aluno");
        painel.add(btnCancel);

        // Adiciona o painel na janela principal (JFrame)
        add(painel);
    }

    // Getters (utilizado no Controller)
    
    /**
     * getTxtNome
     *
     * @return objeto JTextField
     */
    public JTextField getTxtNome() {
        return txtNome;
    }
    
    /**
     * getTxtIdade
     *
     * @return objeto JTextField
     */
    public JTextField getTxtIdade() {
        return txtIdade;
    }
    
    /**
     * getTxtRA
     *
     * @return objeto JTextField
     */
    public JTextField getTxtRA() {
        return txtRA;
    }
    
    /**
     * getTxtDisciplina
     *
     * @return objeto JTextField
     */
    public JTextField getTxtDisciplina() {
        return txtDisciplina;
    }
    
    /**
     * getTxtSemestre
     *
     * @return objeto JTextField
     */
    public JTextField getTxtSemestre() {
        return txtSemestre;
    }

    /**
     * getLblResultado
     *
     * @return objeto JLabel
     */
    public JButton getBtnConfirm() {
        return btnConfirm;
    }

    /**
     * getBtnConverter
     *
     * @return objeto JButton
     */
    public JButton getBtnCancel() {
        return btnCancel;
    }
}