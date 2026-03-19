import javax.swing.JOptionPane;

/**
 * Escreva uma descrição da classe Armazenador aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class ArmazenadorArray implements IArmazenador
{
    private int qtdMaxima;
    Aluno[] alunos;
    int qtdAlunos;
    
    ArmazenadorArray(int qtd){
        qtdMaxima = qtd;
        alunos = new Aluno[qtdMaxima];
        qtdAlunos = 0;
    }
    
    public void inserirAluno(Aluno a){
        if(qtdAlunos == qtdMaxima){
            JOptionPane.showMessageDialog(null, "Quantidade Maxima de alunos atingida\n");  
            return;
        }
        for(int i = 0;i<qtdAlunos;i++){
            if(alunos[i].getRA().equals(a.getRA())){                
                JOptionPane.showMessageDialog(null, "Aluno já existe\n");  
                return;
            }
        }    
        
        alunos[qtdAlunos] = a;
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
    public void listarAlunos(){
        if(qtdAlunos == 0)      
            JOptionPane.showMessageDialog(null, "Nao existem Alunos\n");
                        
        for(int i = 0;i<qtdAlunos;i++){
            JOptionPane.showMessageDialog(null, alunos[i].toString());                        
        }        
    }
}