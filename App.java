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

        //Buscando possiveis erros na primeira instancia do Cadastro Aluno
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
            String[] confirmaErro = {"1 - não", "0 - sim"};
            opcao = menu.criarMenu(itensMenu);
            
            //Troca de Operadores, e Chamada dos metodos respectivos
            switch(opcao){
                case 3:
                    //Utiliza as Classe de Armazenamento em vetores
                    cadastro.listar();
                    break;
                case 2:
                    ra = entrada.lerString("Qual o RA do aluno(RA1234567)?");
                    cadastro.remover(ra);
                    break;

                case 1:
                    
                    //Começo do teste pra inserção de nomeAluno   
                    do{
                        erro = 0;
                        nomeAluno = entrada.lerString("Qual o nome do aluno?");
                        if(nomeAluno != null){ // o nomeAluno nao pode ser nulo pra fazermos as verificações e padronizações
                            nomeAluno = nomeAluno.trim(); // nomeAluno Recebe um metodo que Limpa espaços excedentes 
                            if(nomeAluno.equals("")){ // Botao ok Apertado sem inserir nada
                                erro = 1;
                                saida.mostrarMsg("Nome Vazio!! Tente Novamente!");
                            }
                        }
                    }while(erro == 1);
                    
                    if(nomeAluno == null){ //BOTAO CANCELAR APERTADO, LOGO USUARIO QUER SAIR DA INSERCAO
                        break;
                    }
                    //Fim do teste pra inserção de nomeAluno
                    
                    
                    //Começo do teste pra inserção de idade                    
                    do{
                        try{
                            erro = 0;
                            idade = Integer.parseInt(entrada.lerString("Qual a idade do Aluno?"));
                        } catch(NumberFormatException e){ //Execessao acionada pra caso Usuario entre com Algo != de Numero
                            erro = 1;
                            saida.mostrarMsg("IDADE INVALIDA!!! Tente Novamente");
                        }

                        if(erro == 0){ // NAO TEM PORQUE VERIFICAR ERRO SE JA TEVE UM ERRO
                            if(idade < 1 || idade > 116){
                                erro = 1;
                                saida.mostrarMsg("A idade do aluno DEVE ser entre 1 E 116");
                            }
                        }
                    }while(erro == 1);
                    //Fim do teste pra inserção de idade
                    
                    //Começo do teste de inserção de RA
                    do{
                        erro = 0;
                        ra = entrada.lerString("Qual o RA do aluno(RA1234567)?"); 
                        if(ra != null){ // o ra nao pode ser nulo pra fazermos as verificações e padronizações            
                            ra = ra.toUpperCase().trim();
                            if(ra.equals("")){ // Botao ok Apertado sem inserir nada
                            erro = 1;
                            saida.mostrarMsg("o RA enviado esta VAZIO!!! Tente Novamente");
                            }
                        }                                              
                    }while(erro == 1);
                    
                    if(ra == null){ //BOTAO CANCELAR APERTADO, LOGO USUARIO QUER SAIR DA INSERCAO
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
                        }           
                        if(erro == 0){ // NAO TEM PORQUE VERIFICAR ERRO SE JA TEVE UM ERRO
                            if(semestre < 1 || semestre > 12){
                                erro = 1;
                                saida.mostrarMsg("O Semestre DEVE SER entre 1 e 12");
                            }                            
                        }
                    }while(erro == 1);
                    //Fim do teste pra inserção de semestre
                    
                    Aluno aluno = new Aluno(nomeAluno,idade,ra,disciplina,semestre);
                    
                    cadastro.inserir(aluno);
                    break;
                case 0:    
                    opcao = menu.criarMenu(confirmaErro);
                    break;                
                default:
                    saida.mostrarMsg("Opção Invalida, tente novamente \n");
                    break;
            }
                
        }while(opcao != 0);
    }
}