import javax.swing.JOptionPane;
/**
 * Escreva uma descrição da classe App aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class App
{
    public static void main(String[] args){   
        int qtdMaxima = Integer.parseInt(JOptionPane.showInputDialog("Quantos alunos é o maximo: "));
        Cadastro cadastro = new Cadastro(qtdMaxima);
        String nomeAluno,ra,disciplina;
        int idade,semestre;
        int opcao = 99;
        while(opcao != 0){                 
            opcao = Integer.parseInt(JOptionPane.showInputDialog("Escolha uma opção: \n3 - Exibir Alunos\n2 - Remover aluno (pelo RA)\n1 - Criar aluno\n0 - Sair"));
            
            switch(opcao){
                case 3:
                    cadastro.listar();
                    break;
                case 2:
                    ra = JOptionPane.showInputDialog("RA do Aluno(RA1234567): ");
                    
                    cadastro.remover(ra);
                    break;
                case 1:
                    nomeAluno = JOptionPane.showInputDialog("Nome do Aluno: ");
                    idade = Integer.parseInt(JOptionPane.showInputDialog("Idade do Aluno: "));
                    ra = JOptionPane.showInputDialog("RA do Aluno(RA1234567): ");
                    disciplina = JOptionPane.showInputDialog("Disciplina do Aluno: ");
                    semestre = Integer.parseInt(JOptionPane.showInputDialog("Semestre do Aluno: "));      
                    
                    Aluno aluno = new Aluno(nomeAluno,idade,ra,disciplina,semestre);
                    
                    cadastro.inserir(aluno);
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