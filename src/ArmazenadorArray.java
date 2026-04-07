package src;

import src.Saida.*;
import src.Entrada.*;
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
        }
        else{
            alunos[qtdAlunos] = a;
            qtdAlunos++;
            saida.mostrarMsg("Aluno criado\n");
        }
    }
    public boolean verificarRa(String ra){   //metodo usado para verificar se um RA ja existe na ED
        for(int i = 0;i<qtdAlunos;i++){
            if(alunos[i].getRA().equals(ra)){                 
                return false;
            }
        }
        return true;
    }
    public void removerAluno(String ra){
        if(qtdAlunos == 0){
            saida.mostrarMsg("Nao existem alunos\n");
        }
        else{
            for(int i = 0;i<qtdAlunos;i++){
                if(alunos[i].getRA().equals(ra)){
                    for(int j = i;j<qtdAlunos - 1;j++){
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
    }
    public void listarAlunos(){
        if(qtdAlunos == 0)      
            saida.mostrarMsg("Nao existem Alunos\n");
                        
        for(int i = 0;i<qtdAlunos;i++){
            saida.mostrarMsg(alunos[i].toString());                        
        }        
    }
    
    public int acessarPosAluno(String raEdit){
        int pos = -1;
        for(int i = 0; i < qtdAlunos; i++){
            if(alunos[i].getRA().equals(raEdit)){
                pos = i; 
            }
            
        }
        return pos;
    }
    
    public void editarAluno(int pos) {
        String inputNome = entrada.lerString("Novo nome do Aluno?");
          
        if (inputNome != null && !inputNome.trim().equals("")) {
                alunos[pos].nome = new NomePessoa(inputNome);
        }
        
        String inputIdade = entrada.lerString("Nova Idade do Aluno?");
          
        if (inputIdade != null && !inputIdade.trim().equals("")) {
            try {
                alunos[pos].idade = Integer.parseInt(inputIdade);
            } catch (NumberFormatException e) {
                saida.mostrarMsg("Idade inválida, edição cancelada.");
            }
        }
    
        String inputDisciplina = entrada.lerString("Nova disciplina?");
        if (inputDisciplina != null && !inputDisciplina.trim().equals("")) {
            alunos[pos].setDisciplina(inputDisciplina);
        }
    
        String inputSemestre = entrada.lerString("Novo semestre?");
        if (inputSemestre != null && !inputSemestre.trim().equals("")) {
            try {
                alunos[pos].setSemestre(Integer.parseInt(inputSemestre));
            } catch (NumberFormatException e) {
                saida.mostrarMsg("Semestre inválido, edição cancelada.");
            }
        }
    }
}