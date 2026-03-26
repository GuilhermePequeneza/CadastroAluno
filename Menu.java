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
        //IEntrada entrada = new EntradaTexto();
        int opcao = -1;
        int erro = 0;
        
        // monta menu
        String itens = "";
        for (int i = 0; i < opcoes.length; i++){
            itens = itens + "\n" + opcoes[i];
            
        }
        
        itens = itens + "\n\nSelecione a opcao: ";
        /*do{
            try{
                erro = 0;
                opcao = Integer.parseInt(entrada.lerString(itens));
            } catch(NumberFormatException e){
                erro = 1;
                saida.mostrarMsg("QUANTIDADE INVALIDA!!! Tente Novamente");
            } catch(Exception e){
                erro = 1;
                saida.mostrarMsg("ERRO!! Tente Novamente!");
            }            
            if(erro == 0){
                if(qtdMaxima < 0 ){
                    erro = 1;
                    saida.mostrarMsg("A quantidade de alunos DEVE ser POSITIVA!! Tente Novamente");
                }
            }
        }while(erro == 1);*/
        opcao = Integer.parseInt(entrada.lerString(itens));
        return opcao;
    }
}