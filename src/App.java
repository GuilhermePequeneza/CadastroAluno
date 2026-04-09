package src; 

import src.Entrada.*;
import src.Saida.*;
import src.InsercaoAluno.*;

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
        IEntrada entrada;
        ISaida saida;
        boolean isGrafica = false;
        
        if(isGrafica){
            entrada = new EntradaGrafica();
            saida = new SaidaGrafica();     
        }
        else{
            entrada = new EntradaTexto();             
            saida = new SaidaTexto();   
        }
        
       
        int erro = 0;
        int pos;
        int qtdMaxima = 0;
        int qtdAluno = 0;
        String input = null; // Para a gente guardar o input generico antes de dar parse
        String nomeAluno = null;
        String ra = null;
        String raEdit = null;
        String disciplina = null;
        int idade = 0;
        int semestre = 0;
        int opcao;        

        //Buscando possiveis erros na primeira instancia do Cadastro Aluno
        do{
            try{
                erro = 0;
                input = entrada.lerString("Qual a quantidade de alunos?");
    
            if (input == null) {       // usuário clicou X assim que Iniciou
                System.exit(0);       
            }
            
            qtdMaxima = Integer.parseInt(input);
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
        String[] itensMenu = {"1 - inserir", "2 - remover", "3 - editar", "4 - listar", "5 - Salvar Arquivo", "6 - Ler Arquivo", "0 - sair"};
            String[] confirmaErro = {"Deseja Sair?","1 - não", "0 - sim"};
            opcao = menu.criarMenu(itensMenu);
            
            //Troca de Operadores, e Chamada dos metodos respectivos
            switch(opcao){
                case 6:
                    cadastro.ler("arquivo");
                    break;
                case 5:
                    cadastro.salvar("arquivo");
                    break;
                case 4:  //Opção para listar os alunos
                    //Utiliza as Classe de Armazenamento em vetores
                    cadastro.listar();
                    break;
                    
                case 3: 
                    //Opção para editar alunos
                    if(qtdAluno > 0){
                        raEdit = entrada.lerString("Qual o ra do aluno para editar?");
                    
                        //verificação do caso: se der para modificar/tem aluno?
                        //verificação de cancelamento
                        if(raEdit == null || raEdit.equals("")){                            
                            break;
                            }
                        raEdit = raEdit.toUpperCase().trim();
                        pos = cadastro.acessarPAluno(raEdit);
                        //se a posição for esse sinal, é porque não achou
                        if(pos == -1){
                            saida.mostrarMsg("Esse aluno nao existe");
                            break;
                            }
                        cadastro.editar(pos);
                    }
                    else{
                        saida.mostrarMsg("Não tem alunos cadastrados para editar");
                    }
                    break;    
                    
                case 2: //opção para remover alunos
                    if(qtdAluno > 0){
                        ra = entrada.lerString("Qual o RA do aluno(RA1234567)?");
                        if(ra != null)
                        {
                            ra = ra.toUpperCase().trim();
                            cadastro.remover(ra);
                            qtdAluno--;
                        }
                    }
                    else{
                        saida.mostrarMsg("Não ha alunos para remover, crie um antes");
                    }
                    break;                  
                
                    
                case 1:
                    if(!isGrafica){
                        if(qtdAluno == qtdMaxima){ //verifica se pode adicionar mais um aluno na ED, se puder ele faz o processo de inserção
                            saida.mostrarMsg("Quantidade Maxima de alunos atingida\n");
                            break;
                        }
                        
                        
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
                            ra = entrada.lerString("Qual o RA do aluno ex:(RA1234567)?"); 
                            if(ra != null){ // o ra nao pode ser nulo pra fazermos as verificações e padronizações            
                                ra = ra.toUpperCase().trim();
                                if(ra.equals("")){ // Botao ok Apertado sem inserir nada
                                erro = 1;
                                saida.mostrarMsg("o RA enviado esta VAZIO!!! Tente Novamente");
                                }
                                if(cadastro.verificarRa(ra) == false){
                                    erro = 1;
                                    saida.mostrarMsg("Esse RA ja esta registrado, Tente Novamente");
                                }
                            }                                              
                        }while(erro == 1);
                        
                        if(ra == null){ //BOTAO CANCELAR APERTADO, LOGO USUARIO QUER SAIR DA INSERCAO
                            break;
                        }                    
                        //Fim do teste de inserção de RA                    
                               
                        
                        //Começo do teste para inserção da Disciplina
                         do{
                            try{
                                erro = 0;
                                disciplina = entrada.lerString("Qual a Disciplina do Aluno?");
                                if(ra != null){ // a disciplina nao pode ser nulo pra fazermos as verificações e padronizações            
                                disciplina = disciplina.toUpperCase().trim();
                                if(ra.equals("")){ // Botao ok Apertado sem inserir nada
                                    erro = 1;
                                    saida.mostrarMsg("A Disciplina Está vazia, tente novamente");
                                    }
                                }
                            }  catch(Exception e){
                                saida.mostrarMsg("Não encontrado Tente novamente");
                                erro = 1;
                            }           
                        }while(erro == 1);
                        //Fim do teste de inserção da Disciplina
                        
                        
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
                        qtdAluno++;
                        break;
                    }
                    else{
                        if(qtdAluno == qtdMaxima){ //verifica se pode adicionar mais um aluno na ED, se puder ele faz o processo de inserção
                            saida.mostrarMsg("Quantidade Maxima de alunos atingida\n");
                            break;
                        }                    
                        
                        TelaInsercao tela = new TelaInsercao();
                        InsercaoController controle = new InsercaoController(tela, cadastro);
                        tela.setVisible(true);
                        //qtdAluno = cadastro.getQuantidadeAtual();
                        break;
                    }
                    
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
