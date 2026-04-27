package src;

 

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
    IPersistencia arquivo;
    
    /**
     * Construtor com escolha de ED
     * 
     * @param qtd  Quantidade maxima de alunos
     * @param usarLista     true = Lista ligada, false = Array
     */
    Cadastro(int qtd, boolean usarLista){
        if(usarLista){
            armazenador = new ArmazenadorLista(qtd);
        }
        else{
            armazenador = new ArmazenadorArray(qtd);
        }
    }
    
    /**
     * Construtor padrao
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
    public boolean inserir(Aluno a){
        return armazenador.inserirAluno(a);
    }
    
    /**
     * Remove o aluno com base em seu RA
     * 
     * @param RA do aluno
     */
    public boolean remover(String ra){
        return armazenador.removerAluno(ra);
    }
    
    /**
     * Lista todos os alunos
     * 
     */
    public void listar(){
        armazenador.listarAlunos();
    }    
    
    /**
     * Intermediario para alterar os atributos do Aluno
     * 
     * @param RA do Aluno
     */
    public boolean editar(String ra){
        return armazenador.editarAluno(ra);
    }
    
    public void salvar(String arqNome) {
        arquivo = new ArquivoBinario(arqNome);
        Aluno[] alunos = armazenador.getAlunos();
        arquivo.gravarObj(alunos);
    }
    
    public boolean ler(String arqNome){   
        arquivo = new ArquivoBinario(arqNome);
        Aluno alunos[];
        try{
             alunos = (Aluno[])arquivo.lerObj();
        }
        catch(ClassCastException e){
            return false;
        }
        if(alunos == null){
            return false;
        }
        
        armazenador = new ArmazenadorArray(alunos.length);
        for(int i = 0;i<alunos.length;i++){
            if(alunos[i] != null)
                armazenador.inserirAluno(alunos[i]);
        }
        return true;
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
    
    public int getQuantidadeAtual(){
        return armazenador.getQtdAlunos();
    }
}
