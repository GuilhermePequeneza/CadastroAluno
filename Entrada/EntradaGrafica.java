package Entrada;
import javax.swing.JOptionPane;

/**
 * Classe principal.
 * 
 * @author Julio Arakaki 
 * @version 20250310
 */
public class EntradaGrafica implements IEntrada {

    /**
     * Método lerString - le uma string pelo teclado e retorna
     *
     * @param mensagem Mesnsage na console
     * @return s string lida
     */
    public String lerString(String mensagem){
        
        // Faz a leitura pelo teclado
        String s = JOptionPane.showInputDialog(mensagem);
                
        // Retorna a string lida
        return s;
    }
}
