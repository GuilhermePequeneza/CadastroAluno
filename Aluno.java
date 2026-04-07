
/**
 * Classe que Coloca o Aluno sendo uma Pessoa, adicionando RA, Disciplina e Semestre
 * 
 * @author Felipe Estima
 * @author Guilherme Pequeneza
 * @author Igor Dias
 * @author Thierry Nadjarian 
 * 
 * @version 06/04/26
 */
public class Aluno extends Pessoa{
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
     * Pega o RA
     */
    public String getRA(){
        return this.ra;
    }
    
    /**
     * Define Disciplina
     */
    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }
    
    /**
     * Define o Semestre
     */
    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }
    
    public String toString(){
        return ("Nome: " + nome.toString() + "\nIdade: " + this.idade + "\nRA: " + ra + "\nDisciplina: " + disciplina + "\nSemestre: " + semestre);
    }
    
}