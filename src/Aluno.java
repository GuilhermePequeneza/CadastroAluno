package src;

 
import java.io.Serializable;
/**
 * Classe que Coloca o Aluno sendo uma Pessoa, adicionando RA, Disciplina e Semestre
 * 
 * @author Felipe Estima
 * @author Guilherme Pequeneza
 * @author Igor Dias
 * @author Thierry Nadjarian 
 * 
 * @version 10/05/26
 */
public class Aluno extends Pessoa implements Serializable{
    private String ra;
    private String disciplina;
    private int semestre;
    
    /**
     * Construtor: Armazena Nome, idade, RA, Displina, Semestre
     * 
     * @param Int Nome, Int Idade, String RA, String Disciplina, Int Semestre
     */
    public Aluno(String nome, int idade, String ra, String disciplina, int semestre){
        super(nome,idade);
        this.ra = ra; 
        this.disciplina = disciplina;
        this.semestre = semestre;
    }  
   
    /**
     * Pega o RA do aluno
     * 
     * @return RA do aluno
     */
    public String getRA(){
        return this.ra;
    }    
    
    /**
     * Pega a Disciplina do aluno
     * 
     * @return Disciplina do aluno
     */
    public String getDisciplina(){
        return this.disciplina;
    }
    
    /**
     * Pega o semestre do aluno
     * 
     * @return Semestre do aluno
     */
    public int getSemestre(){
        return this.semestre;
    }
    
    /**
     * Define Disciplina
     * 
     * @param String Disciplina
     */
    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }
    
    /**
     * Define o Semestre
     * 
     * @param Int Semestre
     */
    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }
    
    /**
     * Retorna as informações (Nome, Idade, RA, Disciplina e Semestre) com quebras de linha, facilitando a exibição 
     * no console ou em interfaces gráficas.
     * 
     * @return Uma String contendo as informações detalhadas do aluno.
     */
    public String toString(){
        return ("Nome: " + nome.toString() + "\nIdade: " + this.idade + "\nRA: " + ra + "\nDisciplina: " + disciplina + "\nSemestre: " + semestre);
    }
    
}
