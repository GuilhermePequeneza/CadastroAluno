
/**
 * Classe Pessoa possui a idade e o nome como atributos
 * 
 * @author Felipe Estima
 * @author Guilherme Pequeneza
 * @author Igor Dias
 * @author Thierry Nadjarian 
 * 
 * @version 06/04/26
 */
public class Pessoa
{
    public NomePessoa nome;
    public int idade;
    
    /**
     * Construtor: Armazena o nome e a Idade
     * 
     * @param Nome e Idade
     */
    public Pessoa(String nome, int idade){
        this.idade = idade;
        this.nome = new NomePessoa(nome);
    }
    
    /**
     * Metodo usado para verificar o ENTER
     */
    public String toString(){
        return ("");
    }
}