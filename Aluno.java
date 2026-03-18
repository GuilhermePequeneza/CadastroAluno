
/**
 * Escreva uma descrição da classe Aluno aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class Aluno extends Pessoa{
    private String ra;
    private String disciplina;
    private int semestre;
    
    
    public Aluno(String nome, int idade, String ra, String disciplina, int semestre){
        super(nome,idade);
        this.ra = ra; 
        this.disciplina = disciplina;
        this.semestre = semestre;
    }
    
    public void removerAluno(){
        this.nome = null;
        this.idade = 0;
        this.ra = null;
        this.semestre = 0;
    }
    
    public String getRA(){
        return this.ra;
    }
    
    public String toString(){
        return ("Nome: " + nome.toString() + "\nIdade: " + this.idade + "\nRA: " + ra + "\nDisciplina: " + disciplina + "\nSemestre: " + semestre);
    }
}