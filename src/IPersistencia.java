package src;

 


/**
 * Escreva a descrição da interface IPersistencia aqui.
 * 
 * @author (seu nome aqui) 
 * @version (um número da versão ou data aqui)
 */

public interface IPersistencia
{    
    public boolean gravarObj(Object objeto); //salva o arquivo com Objetos generalizado
    public Object lerObj(); // 
}
