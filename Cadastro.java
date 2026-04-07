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
     * @param Nenhum
     */
    public void listar(){
        armazenador.listarAlunos();
    }
    
    /**
     * Intermediario para acessar a posição do Aluno no array
     * 
     * @param RA do aluno
     * 
     * @return posição do Aluno
     */
    public int acessarPAluno(String raAluno){
        int pos;
        pos = armazenador.acessarPosAluno(raAluno);
        return pos;
    }
    
    /**
     * Intermediario para alterar os atributos do Aluno
     * 
     * @param Posição da Janela
     */
    public void editar(int pos){
        armazenador.editarAluno(pos);
    }
    
    /**
     * Intermediario para verificar se o RA existe
     * 
     * @para String RA
     * 
     * @return True ou false
     */
    public boolean verificarRa(String ra){
        boolean r;
        r = armazenador.verificarRa(ra);
        return r;
    }
}