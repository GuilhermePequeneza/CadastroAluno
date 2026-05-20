package src.Entrada; 
import javax.swing.JOptionPane;

/**
 * Classe principal.
 * 
 * @author Felipe Estima
 * @author Guilherme Pequeneza
 * @author Igor Dias
 * @author Thierry Nadjarian 
 * 
 * @version 10/05/26
 */
public class EntradaGrafica implements IEntrada {

    /**
     * Método lerString - le uma string pelo teclado e retorna
     *
     * @param Mesnsage na console
     * @return s string lida
     */
    public String lerString(String mensagem){
        
        // Faz a leitura pelo teclado
        String s = JOptionPane.showInputDialog(mensagem);
                
        // Retorna a string lida
        return s;
    }
}
