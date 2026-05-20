package src;

 


/**
 * Interface para Salvamento de dados
 * 
 * @author Felipe Estima
 * @author Guilherme Pequeneza
 * @author Igor Dias
 * @author Thierry Nadjarian 
 * 
 * @version 10/05/26
 */

public interface IPersistencia
{    
    public boolean gravarObj(Object objeto); //salva o arquivo com Objetos generalizado
    public Object lerObj(); // 
}
