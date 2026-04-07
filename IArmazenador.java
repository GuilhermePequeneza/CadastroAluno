
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
    public void inserirAluno(Aluno a);
    public void removerAluno(String ra);
    public void listarAlunos();
    public int acessarPosAluno(String raAluno);
    public void editarAluno(int pos);
    public boolean verificarRa(String ra); //serve pra verificar se um RA ja esta sendo usado
}