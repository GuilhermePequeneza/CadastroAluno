package src;
/**
 * Inicia os métodos que serão usados nos Armazenadores implementados pela Interface
 * 
 * @author Felipe Estima
 * @author Guilherme Pequeneza
 * @author Igor Dias
 * @author Thierry Nadjarian 
 * 
 * @version 06/04/26
 */
public interface IArmazenador
{   
    
    public boolean inserirAluno(Aluno a);
    public boolean removerAluno(String ra);
    public void listarAlunos();    
    public boolean editarAluno(String ra);
    public int getQtdAlunos();
    public boolean verificarRa(String ra); //serve pra verificar se um RA ja esta sendo usado
    public Aluno[] getAlunos();
    public int getQtdMaxima();
}