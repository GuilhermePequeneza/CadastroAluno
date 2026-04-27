package src;

 

import src.Saida.*;
import src.Entrada.*;

/**
 * Menu para mostrar as opções
 *
 * @author Felipe Estima
 * @author Guilherme Pequeneza
 * @author Igor Dias
 * @author Thierry Nadjarian 
 * 
 * @version 06/04/26
 */
public class Menu{
    
    /**
     * Faz as opções do Array dado as opções do Menu
     * 
     * @param Array de String
     * 
     * @return opçao escolhida pelo usuario
     */
    public int criarMenu(String opcoes[]){        
        IEntrada entrada = new EntradaGrafica();    
        ISaida saida = new SaidaGrafica();
        
        //IEntrada entrada = new EntradaTexto();
        //ISaida saida = new SaidaTexto();
        
        String input = "";
        int opcao = -1;
        int erro = 0;
        
        // monta menu
        String itens = "";
        for (int i = 0; i < opcoes.length; i++){
            itens = itens + "\n" + opcoes[i];
            
        }
        
        //Concaquenação de String (acho)
        itens = itens + "\n\nSelecione a opcao: ";
        do{
            try{
                erro = 0;
                input = entrada.lerString(itens);
                if(input != null){
                    if(!input.equals(""))
                        opcao = Integer.parseInt(input.trim());
                    else{
                        erro = 1;
                        saida.mostrarMsg("OPCAO VAZIA!!! Tente Novamente");
                    }
                }
            } catch(NumberFormatException e){
                erro = 1;
                saida.mostrarMsg("OPCAO INVALIDA!!! Tente Novamente");
            } catch(Exception e){
                erro = 1;
                saida.mostrarMsg("ERRO!! Tente Novamente!");
            }   
        }while(erro == 1);
        
        if(input == null){
            opcao = 0;
        }
        
        //opcao = Integer.parseInt(entrada.lerString(itens));
        return opcao;
    }
}
