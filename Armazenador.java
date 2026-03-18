import javax.swing.JOptionPane;

/**
 * Escreva uma descrição da classe Armazenador aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class Armazenador
{
    private int qtdMaxima = 50;
    Aluno[] alunos = new Aluno[qtdMaxima];
    int qtdAlunos = 0;
    public void criarAluno(String nomeAluno,int idade, String ra,String disciplina, int semestre){
        if(qtdAlunos == qtdMaxima){
            JOptionPane.showMessageDialog(null, "Quantidade Maxima de alunos atingida\n");  
            return;
        }
        for(int i = 0;i<qtdAlunos;i++){
            if(alunos[i].getRA().equals(ra)){                
                JOptionPane.showMessageDialog(null, "Aluno já existe\n");  
                return;
            }
        }
        
        alunos[qtdAlunos] = new Aluno(nomeAluno,idade,ra,disciplina,semestre);
        qtdAlunos++;
        JOptionPane.showMessageDialog(null, "Aluno criado\n");
        
    }
    public void removerAluno(String ra){
        if(qtdAlunos == 0){
            JOptionPane.showMessageDialog(null, "Nao existem alunos\n");
            return;
        }
        for(int i = 0;i<qtdAlunos;i++){
            if(alunos[i].getRA().equals(ra)){
                for(int j = i;j<qtdAlunos;j++){
                    alunos[j] = alunos[j+1];
                }
                alunos[qtdAlunos-1] = null;
                qtdAlunos--;
                JOptionPane.showMessageDialog(null, "Aluno removido\n");   
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Aluno não existe\n");                 
    }
}