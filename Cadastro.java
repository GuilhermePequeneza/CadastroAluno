import javax.swing.JOptionPane;

/**
 * Escreva uma descrição da classe Cadastro aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class Cadastro{
    public static void main(String[] args){
        /*Aluno[] alunos = new Aluno[3];
        
        alunos[0] = new Aluno("Chiko Chikoso",19,"RA00360273",1);
        alunos[1] = new Aluno("Guilherme Pequeneza",20,"RA00320253",2);
        alunos[2] = new Aluno("Pequeneza Guilherme",21,"RA00310469",3);
        
        for(int i = 0;i<alunos.length;i++){
            System.out.println(alunos[i].toString());
            System.out.println();
        }*/
        
        String nomeAluno = JOptionPane.showInputDialog("Nome do Aluno: ");
        int idade = Integer.parseInt(JOptionPane.showInputDialog("Idade do Aluno: "));
        String ra = JOptionPane.showInputDialog("RA do Aluno(RA1234567): ");
        int semestre = Integer.parseInt(JOptionPane.showInputDialog("Semestre do Aluno: "));
        
        Aluno[] alunos = new Aluno[3];
        
        alunos[0] = new Aluno(nomeAluno,idade,ra,semestre);
        System.out.println(alunos[0].toString());
    }
}