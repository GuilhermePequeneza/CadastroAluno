import Saida.*;
import Entrada.*;
/**
 * Escreva uma descrição da classe App aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class App
{
    public static void main(String[] args){   
        Menu menu = new Menu();
        
        IEntrada entrada = new EntradaGrafica();
        ISaida saida = new SaidaGrafica();               
        
        /*
        IEntrada entrada = new EntradaTexto();             
        ISaida saida = new SaidaTexto();                    
        */
       
        int erro = 0;
        int qtdMaxima = 0;              
        String nomeAluno = "";
        String ra = "";
        String disciplina = "";
        int idade = 0;
        int semestre = 0;
        int opcao;
        boolean usuSaiu = false;
        do{
            try{
                erro = 0;
                qtdMaxima = Integer.parseInt(entrada.lerString("Qual a quantidade de alunos?"));
            } catch(NumberFormatException e){
                erro = 1;
                saida.mostrarMsg("QUANTIDADE INVALIDA!!! Tente Novamente");
            } catch(Exception e){
                erro = 1;
                saida.mostrarMsg("ERRO!! Tente Novamente!");
            }            
            if(erro == 0){
                if(qtdMaxima <= 0){
                    erro = 1;
                    saida.mostrarMsg("A quantidade de alunos DEVE ser POSITIVA!! Tente Novamente");
                }
            }
        }while(erro == 1);  
        Cadastro cadastro = new Cadastro(qtdMaxima);
         
        
        
        
        do{                 
            String[] itensMenu = {"1 - inserir", "2 - remover", "3 - editar", "4 - listar", "0 - sair"};
            opcao = menu.criarMenu(itensMenu);
            
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
                    
                    //Começo do teste pra inserção de idade                    
                    do{
                        try{
                            erro = 0;
                            idade = Integer.parseInt(entrada.lerString("Qual a idade do Aluno?"));
                        } catch(NumberFormatException e){
                            erro = 1;
                            saida.mostrarMsg("IDADE INVALIDA!!! Tente Novamente");
                        } catch(Exception e){
                            erro = 1;
                            saida.mostrarMsg("ERRO!! Tente Novamente!");
                        }            
                        if(erro == 0){
                            if(idade < 0 || idade > 151){
                                erro = 1;
                                saida.mostrarMsg("A idade do aluno DEVE ser entre 1 E 151");
                            }
                        }
                    }while(erro == 1);
                    //Fim do teste pra inserção de idade
                    
                    //Começo do teste de inserção de RA
                    do{
                        erro = 0;
                        ra = entrada.lerString("Qual o RA do aluno(RA1234567)?"); 
                        if(ra != null){                  
                            if(ra.equals("")){
                            erro = 1;
                            saida.mostrarMsg("o RA enviado esta VAZIO!!! Tente Novamente");
                            }
                        }                                              
                    }while(erro == 1);
                    if(ra == null){
                        break;
                    }                    
                    //Fim do teste de inserção de RA                    
                                         
                    
                    //Começo do teste pra inserção de semestre
                    do{
                        try{
                            erro = 0;
                            semestre = Integer.parseInt(entrada.lerString("Qual o semestre do aluno?"));
                        } catch(NumberFormatException e){
                            erro = 1;
                            saida.mostrarMsg("SEMESTRE INVALIDO!!! Tente Novamente");
                        } catch(Exception e){
                            erro = 1;
                            saida.mostrarMsg("ERRO!! Tente Novamente!");
                        }            
                        if(erro == 0){
                            if(semestre < 1 || semestre > 12){
                                erro = 1;
                                saida.mostrarMsg("A idade do aluno DEVE ser entre 15 E 100");
                            }
                        }
                    }while(erro == 1);
                    //Fim do teste pra inserção de semestre
                    
                    Aluno aluno = new Aluno(nomeAluno,idade,ra,disciplina,semestre);
                    
                    cadastro.inserir(aluno);
                    break;
                case 0:                    
                    opcao = menu.criarMenu(itensMenu);
                    break;
                default:
                    saida.mostrarMsg("Opção Invalida, tente novamente \n");
                    break;
            }
                
        }while(opcao != 0);
    }
}