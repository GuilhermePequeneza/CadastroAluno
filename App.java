/**
 * Escreva uma descrição da classe App aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class App
{
    public static void main(String[] args){   
        
        IEntrada entrada = new EntradaGrafica();
        ISaida saida = new SaidaGrafica();
        IMenu menu = new MenuGrafico(); 
        
        /*
        IEntrada entrada = new EntradaTexto();             
        ISaida saida = new SaidaTexto();                
        IMenu menu = new MenuTexto();
        */
        
        int qtdMaxima = Integer.parseInt(entrada.lerString("Qual a quantidade de alunos?"));
        Cadastro cadastro = new Cadastro(qtdMaxima);
        String nomeAluno,ra,disciplina;
        int idade,semestre;
        int opcao;     
         
        
        String[] itensMenu = {"1 - inserir", "2 - remover", "3 - listar", "0 - sair"};
        
        do{                 
            opcao = Integer.parseInt(entrada.lerString("1 - inserir\n2 - remover\n3 - listar\n0 - sair"));
            
            switch(opcao){
                case 3:
                    cadastro.listar();
                    break;
                case 2:
                    ra = entrada.lerString("Qual o RA do aluno(RA1234567)?");
                    
                    cadastro.remover(ra);
                    break;
                case 1:
                    nomeAluno = entrada.lerString("Qual o nome do aluno?");
                    idade = Integer.parseInt(entrada.lerString("Qual a idade do Aluno?"));
                    ra = entrada.lerString("Qual o RA do aluno(RA1234567)?");
                    disciplina = entrada.lerString("Qual a disciplina que o aluno cursa?");
                    semestre = Integer.parseInt(entrada.lerString("Qual o semestre do aluno?"));   
                    
                    Aluno aluno = new Aluno(nomeAluno,idade,ra,disciplina,semestre);
                    
                    cadastro.inserir(aluno);
                    break;
                case 0:
                    break;
                default:
                    saida.mostrarMsg("Opção Invalida, tente novamente \n");
                    break;
            }
                
        }while(opcao != 0);
    }
}