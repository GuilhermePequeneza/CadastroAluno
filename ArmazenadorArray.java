import Saida.*;
import Entrada.*;
import javax.swing.JOptionPane;

/**
 * ArmazenadorArray implementa a Interface do Armazenador.
 * 
 * @author Felipe Estima
 * @author Guilherme Pequenezza
 * @author Igor Dias
 * @author Thierry Nadjarian 
 * 
 * @version 06/04/26
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
    
    /**
     * Construtor: Armazena os alunos cadastrados em um Array
     * 
     * @param Quantidade Maxima de Alunos
     * 
     */
    ArmazenadorArray(int qtd){
        qtdMaxima = qtd;
        alunos = new Aluno[qtdMaxima];
        qtdAlunos = 0;
    }
    
    /**
     * Caso a Qauntidade maxima de alunos for atingida retorna a Mensagem
     * Caso a Quantidade maxima de alunos não for atingida Cria Aluno
     */
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
    
    /**
     * Verifica se o RA existe dentro da Estrutura de Dados
     * 
     * @return True ou False
     */
    public boolean verificarRa(String ra){   //metodo usado para verificar se um RA ja existe na ED
        for(int i = 0;i<qtdAlunos;i++){
            if(alunos[i].getRA().equals(ra)){                
                //saida.mostrarMsg("Já existe um aluno com esse RA, tente outro\n");
                //A mensagem de que ja existe um aluno com esse RA não sai por aqui, ela sai pelo App
                return false;
            }
        }
        return true;
    }
    
    /**
     * Remove o Aluno escolhido com base no RA disponibilizado
     */
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
                }
            }
            //saida.mostrarMsg("Aluno não existe\n");
        }
    }
    
    /**
     * 
     * Mostra todos os alunos já criados.
     * Caso vazio mostra uma mensagem
     */
    public void listarAlunos(){
        if(qtdAlunos == 0)      
            saida.mostrarMsg("Nao existem Alunos\n");
                        
        for(int i = 0;i<qtdAlunos;i++){
            saida.mostrarMsg(alunos[i].toString());                        
        }        
    }
    
    /**
     * Procura o Ra do aluno percorrendo a lista
     * 
     * @return Posição do Aluno dentro do array
     */
    public int acessarPosAluno(String raEdit){
        int pos = -1;
        for(int i = 0; i < qtdAlunos; i++){
            if(alunos[i].getRA().equals(raEdit)){
                pos = i; 
            }
            
        }
        return pos;
    }
    
    /**
     * Dada a posição do aluno dentro do array
     * É possível alterar os atributos do respectivo aluno.
     */
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