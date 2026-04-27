package src.Entrada;

import src.Aluno;
import javax.swing.*;
import java.awt.*;

/**
 * Classe responsável por gerar a interface gráfica de edição de alunos.
 * 
 * @author Felipe Estima
 * @author Guilherme Pequeneza
 * @author Igor Dias
 * @author Thierry Nadjarian 
 * 
 * @version 06/04/26
 */

public class TelaEdicao extends JDialog {
    // Mesmos atributos da TelaInsercao
    private JTextField txtNome, txtIdade, txtRA, txtDisciplina, txtSemestre;
    private JButton btnConfirm, btnCancel;
    
    /**
     * Construtor da TelaEdicao.
     * Configura o comportamento da janela de diálogo (modal, título, tamanho,
     * operação de fechamento e posicionamento) e inicializa os componentes visuais.
     */
    public TelaEdicao() {
        this.setModal(true); // Bloqueia o app até fechar
        setTitle("Editar Aluno");
        setSize(780,480);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
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
    
    /**
     * Preenche os campos de texto da tela com os dados atuais do aluno selecionado.
     * Este método também bloqueia o campo de RA (Read-Only) para garantir que 
     * a chave primária do aluno não seja alterada durante a edição.
     * * @param aluno Objeto contendo os dados que serão exibidos na interface.
     */
    public void carregarDadosAluno(Aluno aluno) {
        txtNome.setText(aluno.nome.toString()); 
        txtIdade.setText(String.valueOf(aluno.idade));
        
        txtRA.setText(aluno.getRA());
        txtRA.setEditable(false); // BLOQUEIA O RA PARA EDIÇÃO!
        txtRA.setBackground(Color.LIGHT_GRAY); 
        
        txtDisciplina.setText(aluno.getDisciplina()); 
        txtSemestre.setText(String.valueOf(aluno.getSemestre()));
    }

    // Getters (utilizado no Controller)
    
    /**
     * Retorna a caixa de texto referente ao Nome.
     *
     * @return objeto JTextField do Nome.
     */
    public JTextField getTxtNome() {
        return txtNome;
    }
    
    /**
     * Retorna a caixa de texto referente à Idade.
     *
     * @return objeto JTextField da Idade.
     */
    public JTextField getTxtIdade() {
        return txtIdade;
    }     
    
    /**
     * Retorna a caixa de texto referente à Disciplina.
     *
     * @return objeto JTextField da Disciplina.
     */
    public JTextField getTxtDisciplina() {
        return txtDisciplina;
    }
    
    /**
     * Retorna a caixa de texto referente ao Semestre.
     *
     * @return objeto JTextField do Semestre.
     */
    public JTextField getTxtSemestre() {
        return txtSemestre;
    }

    /**
     * Retorna o botão de confirmação da edição.
     *
     * @return objeto JButton Confirmar.
     */
    public JButton getBtnConfirm() {
        return btnConfirm;
    }

    /**
     * Retorna o botão de cancelamento da edição.
     *
     * @return objeto JButton Cancelar.
     */
    public JButton getBtnCancel() {
        return btnCancel;
    }
}
