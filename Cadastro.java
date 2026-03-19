

/**
 * Escreva uma descrição da classe Cadastro aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class Cadastro{
    IArmazenador armazenador;
    
    Cadastro(int qtd){
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
    /*public static void main(String[] args){
        IArmazenador armazenador = new ArmazenadorArray();
        String nomeAluno,ra,disciplina;
        int idade,semestre;
        int opcao = 99;
        while(opcao != 0){                 
            opcao = Integer.parseInt(JOptionPane.showInputDialog("Escolha uma opção: \n3 - Exibir Alunos\n2 - Remover aluno (pelo RA)\n1 - Criar aluno\n0 - Sair"));
            
            switch(opcao){
                case 3:
                    armazenador.listarAlunos();
                    break;
                case 2:
                    ra = JOptionPane.showInputDialog("RA do Aluno(RA1234567): ");
                    
                    armazenador.removerAluno(ra);
                    break;
                case 1:
                    nomeAluno = JOptionPane.showInputDialog("Nome do Aluno: ");
                    idade = Integer.parseInt(JOptionPane.showInputDialog("Idade do Aluno: "));
                    ra = JOptionPane.showInputDialog("RA do Aluno(RA1234567): ");
                    disciplina = JOptionPane.showInputDialog("Disciplina do Aluno: ");
                    semestre = Integer.parseInt(JOptionPane.showInputDialog("Semestre do Aluno: "));      
                    
                    Aluno aluno = new Aluno(nomeAluno,idade,ra,disciplina,semestre);
                    
                    armazenador.inserirAluno(aluno);
                    break;
                case 0:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção Invalida, tente novamente \n");
                    break;
            }
                
        }
    }*/
}