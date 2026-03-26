package Saida;
import javax.swing.JOptionPane;

/**
 * Escreva uma descrição da classe SaidaGrafica aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class SaidaGrafica implements ISaida {
    public void mostrarMsg(String s){
        JOptionPane.showMessageDialog(null, s);
    }
}
