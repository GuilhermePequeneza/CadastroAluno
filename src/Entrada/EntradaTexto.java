package src.Entrada;  
import java.util.Scanner;

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
public class EntradaTexto implements IEntrada {

    /**
     * Ler String
     *
     * @param Mensagem no console
     * @return s string lida
     */
    public String lerString(String mensagem){
        
        // Cria um objeto da classe Scanner, para leitura pelo teclado
        Scanner sc = new Scanner(System.in);

        // Mostra msg na console
        System.out.print(mensagem);
        
        // Faz a leitura pelo teclado
        String s = sc.nextLine();
        
        // Fecha dispositivo de entrada
        sc.close();
        
        // Retorna a string lida
        return s;
    }
}
