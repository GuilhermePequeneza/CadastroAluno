package src;

 
import java.io.Serializable;
/**
 * Classe Pessoa possui a idade e o nome como atributos
 * 
 * @author Felipe Estima
 * @author Guilherme Pequeneza
 * @author Igor Dias
 * @author Thierry Nadjarian 
 * 
 * @version 10/05/26
 */
public class Pessoa implements Serializable
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
