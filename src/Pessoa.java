package src;

/**
 * Escreva uma descrição da classe Pessoa aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class Pessoa
{
    public NomePessoa nome;
    public int idade;
    
    public Pessoa(String nome, int idade){
        this.idade = idade;
        this.nome = new NomePessoa(nome);
    }
    public String toString(){
        return ("");
    }
}