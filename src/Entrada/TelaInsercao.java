package src.Entrada;

import javax.swing.*;
import java.awt.*;

/**
 * Classe responsável por gerar a interface gráfica de inserção de novos alunos.
 * 
 * @author Felipe Estima
 * @author Guilherme Pequeneza
 * @author Igor Dias
 * @author Thierry Nadjarian 
 * 
 * @version 10/05/26
 */

public class TelaInsercao extends JDialog
{
    // Atributos (componentes de tela)
    private JTextField txtNome; // Caixa de texto para o nome
    private JTextField txtIdade; // Caixa de texto para a idade
    private JTextField txtRA; // Caixa de texto para o RA
    private JTextField txtDisciplina; // Caixa de texto para a disciplina
    private JTextField txtSemestre; // Caixa de texto para o semestre
    private JButton btnConfirm;   // Botão para confirmar a inserção
    private JButton btnCancel;  // Botão para cancelar e fechar a tela
    
    /**
     * Construtor da TelaInsercao.
     * Configura o comportamento da janela de diálogo (modal, título, tamanho,
     * operação de fechamento e posicionamento) e inicializa os componentes visuais.
     */
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
     * Configura e instancia os componentes visuais da janela.
     * Utiliza um gerenciador de layout em matriz (GridLayout) para organizar 
     * os rótulos (labels), campos de texto e botões em 6 linhas e 2 colunas.
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
     * Retorna a caixa de texto referente ao Nome.
     *
     * @return objeto JTextField contendo o nome digitado.
     */
    public JTextField getTxtNome() {
        return txtNome;
    }
    
    /**
     * Retorna a caixa de texto referente à Idade.
     *
     * @return objeto JTextField contendo a idade digitada.
     */
    public JTextField getTxtIdade() {
        return txtIdade;
    }
    
    /**
     * Retorna a caixa de texto referente ao RA.
     *
     * @return objeto JTextField contendo o RA digitado.
     */
    public JTextField getTxtRA() {
        return txtRA;
    }
    
    /**
     * Retorna a caixa de texto referente à Disciplina.
     *
     * @return objeto JTextField contendo a disciplina digitada.
     */
    public JTextField getTxtDisciplina() {
        return txtDisciplina;
    }
    
    /**
     * Retorna a caixa de texto referente ao Semestre.
     *
     * @return objeto JTextField contendo o semestre digitado.
     */
    public JTextField getTxtSemestre() {
        return txtSemestre;
    }

    /**
     * Retorna o botão de confirmação da inserção.
     *
     * @return objeto JButton Confirmar.
     */
    public JButton getBtnConfirm() {
        return btnConfirm;
    }

    /**
     * Retorna o botão de cancelamento da inserção.
     *
     * @return objeto JButton Cancelar.
     */
    public JButton getBtnCancel() {
        return btnCancel;
    }
}
