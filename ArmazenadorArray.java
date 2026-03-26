import Saida.*;
import Entrada.*;
import javax.swing.JOptionPane;

/**
 * Escreva uma descrição da classe Armazenador aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class ArmazenadorArray implements IArmazenador
{
    
    IEntrada entrada = new EntradaGrafica();
    ISaida saida = new SaidaGrafica();   
    
    /*   
    IEntrada entrada = new EntradaTexto();             
    ISaida saida = new SaidaTexto();            
    */
    
    
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
            saida.mostrarMsg("Quantidade Maxima de alunos atingida\n");  
            return;
        }
        for(int i = 0;i<qtdAlunos;i++){
            if(alunos[i].getRA().equals(a.getRA())){                
                saida.mostrarMsg("Aluno já existe\n");  
                return;
            }
        }    
        
        alunos[qtdAlunos] = a;
        qtdAlunos++;
        saida.mostrarMsg("Aluno criado\n");
        
    }
    public void removerAluno(String ra){
        if(qtdAlunos == 0){
            saida.mostrarMsg("Nao existem alunos\n");
            return;
        }
        for(int i = 0;i<qtdAlunos;i++){
            if(alunos[i].getRA().equals(ra)){
                for(int j = i;j<qtdAlunos;j++){
                    alunos[j] = alunos[j+1];
                }
                alunos[qtdAlunos-1] = null;
                qtdAlunos--;
                saida.mostrarMsg("Aluno removido\n");   
                return;
            }
        }
        saida.mostrarMsg("Aluno não existe\n");                 
    }
    public void listarAlunos(){
        if(qtdAlunos == 0)      
            saida.mostrarMsg("Nao existem Alunos\n");
                        
        for(int i = 0;i<qtdAlunos;i++){
            saida.mostrarMsg(alunos[i].toString());                        
        }        
    }
}