package src;

/**
 * Classe usada para fazer o Cadastro dos Alunos
 * 
 *@author Felipe Estima
 * @author Guilherme Pequeneza
 * @author Igor Dias
 * @author Thierry Nadjarian 
 * 
 * @version 06/04/26
 */
public class Cadastro{
    IArmazenador armazenador;
    
    /**
     * Construtor Armazena o armazenador que sua Arrays
     * 
     * @param Quantidade maxima de alunos
     */
    Cadastro(int qtd){
        armazenador = new ArmazenadorArray(qtd);
    }
    
    /**
     * Insere o Aluno desejado
     * 
     * @param Objeto aluno
     */
    public void inserir(Aluno a){
        armazenador.inserirAluno(a);
    }
    
    /**
     * Remove o aluno com base em seu RA
     * 
     * @param RA do aluno
     */
    public void remover(String ra){
        armazenador.removerAluno(ra);
    }
    
    /**
     * Lista todos os alunos
     * 
     * 
     */
    public void listar(){
        armazenador.listarAlunos();
    }    
    
    
    /**
     * Intermediario para alterar os atributos do Aluno
     * 
     * @param RA do Aluno
     */
    public void editar(String ra){
        armazenador.editarAluno(ra);
    }
    
    /**
     * Intermediario para verificar se o RA existe
     * 
     * @param String RA
     * 
     * @return True ou false
     */
    public boolean verificarRa(String ra){
        boolean r;
        r = armazenador.verificarRa(ra);
        return r;
    }
    
    public int getQuantidadeAtual(){
        return armazenador.getQtdAlunos();
    }
}