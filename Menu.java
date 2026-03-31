import Saida.*;
import Entrada.*;

/**
 * Write a description of class MenuGrafico here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Menu{
    
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