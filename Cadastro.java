import javax.swing.JOptionPane;

/**
 * Escreva uma descrição da classe Cadastro aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class Cadastro{
    public static void main(String[] args){
        Armazenador armazenador = new Armazenador();
        String nomeAluno,ra,disciplina;
        int idade,semestre;
        int opcao = 99;
        while(opcao != 0){
            JOptionPane.showMessageDialog(null, "Escolha uma opção: \n3 - Exibir Alunos\n2 - Remover aluno (pelo RA)\n1 - Criar aluno\n0 - Sair");         
            
            opcao = Integer.parseInt(JOptionPane.showInputDialog("Escolha a opçao: "));
            
            switch(opcao){
                case 3:
                    if(armazenador.qtdAlunos == 0)      
                        JOptionPane.showMessageDialog(null, "Nao existem Alunos\n");
                        
                    for(int i = 0;i<armazenador.qtdAlunos;i++){
                        JOptionPane.showMessageDialog(null, armazenador.alunos[i].toString() +"\n");                        
                    }
                    break;
                case 2:
                    ra = JOptionPane.showInputDialog("RA do Aluno(RA1234567): ");
                    
                    armazenador.removerAluno(ra);
                    break;
                case 1:
                    nomeAluno = JOptionPane.showInputDialog("Nome do Aluno: ");
                    idade = Integer.parseInt(JOptionPane.showInputDialog("Idade do Aluno: "));
                    ra = JOptionPane.showInputDialog("RA do Aluno(RA1234567): ");
                    disciplina = JOptionPane.showInputDialog("disciplina do Aluno: ");
                    semestre = Integer.parseInt(JOptionPane.showInputDialog("Semestre do Aluno: "));      
                    
                    armazenador.criarAluno(nomeAluno, idade, ra, disciplina, semestre);
                    break;
                case 0:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção Invalida, tente novamente \n");
                    break;
            }
                
        }
    }
}