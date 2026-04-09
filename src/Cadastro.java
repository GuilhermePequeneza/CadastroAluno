package src;  

/**
 * Escreva uma descrição da classe Cadastro aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class Cadastro{
    IArmazenador armazenador;
    IPersistencia persistencia;
    
    public Cadastro(int qtd){
        armazenador = new ArmazenadorArray(qtd);
    }
    
    public void inserir(Aluno a){
        armazenador.inserirAluno(a);
    }
    public void remover(String ra){
        armazenador.removerAluno(ra);
    }
    public void listar(){
        armazenador.listarAlunos();
    }  
    public int acessarPAluno(String raAluno){
        int pos;
        pos = armazenador.acessarPosAluno(raAluno);
        return pos;
    }
    public void editar(int pos){
        armazenador.editarAluno(pos);
    }
    
    public void salvar(String arqNome){
        persistencia = new ArquivoBinario(arqNome);
        Aluno[] alunos = armazenador.devolverAlunos();
        persistencia.gravarObj(alunos);
    }
    
    public void ler(String arqNome){
        persistencia = new ArquivoBinario(arqNome);
        Aluno[] alunos = (Aluno[])persistencia.lerObj();
        for(int i = 0; i<alunos.length;i++){
            armazenador.inserirAluno(alunos[i]);
        }
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
}
