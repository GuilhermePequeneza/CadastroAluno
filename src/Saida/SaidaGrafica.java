package src.Saida;  
import javax.swing.JOptionPane;

/**
 * Classe para a saída Grafica implementada pela Inteface
 * 
 * @author Felipe Estima
 * @author Guilherme Pequeneza
 * @author Igor Dias
 * @author Thierry Nadjarian 
 * 
 * @version 10/05/26
 */
public class SaidaGrafica implements ISaida {
    public void mostrarMsg(String s){
        JOptionPane.showMessageDialog(null, s);
    }
}
