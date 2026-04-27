package src;

import java.io.*;
/**
 * @author julio
 * Classe para gravar e ler arquivo binario
 */
public class ArquivoBinario implements IPersistencia{
    
    String nomeArq;
    
    ArquivoBinario(String nomeArq){
        this.nomeArq = nomeArq;
    }

    /**
     * Method gravarObj grava um objeto em arquivo
     *
     * @param objeto objeto a ser gravado
     * @param nomeArq nome do arquivo
     */
    public boolean gravarObj(Object objeto){
        ObjectOutputStream output = null;
        try {
            File file = new File(this.nomeArq);
            output = new ObjectOutputStream(new FileOutputStream(file)); //envia o sinal para criar o arquivo, mas só cria nem escreve
            output.writeObject(objeto);  // escreve o objeto no arquivo
        }
        catch(FileNotFoundException e){
            return false;
        }
        catch(NullPointerException e){
            return false;
        }
        catch(Exception e){
            return false;
        } 
        finally {
            try {
                output.close();
            } catch(Exception ex) {
                // Nao faz nada!
            }
        }
        return true;
    }

    /**
     * Method lerObj
     *
     * @param nomeArq nome do arquivo a ser lido
     * @return Object o objeto lido
     */
    public Object lerObj(){
        Object objeto = null;
        ObjectInputStream input = null;
        try {
            File file = new File(this.nomeArq);
            input = new ObjectInputStream(new FileInputStream(file));
            objeto = (Object)input.readObject();  // le o objeto do arquivo
            //System.out.println(" " + objeto); //deveria pirntar amas como o tooString deve estar no Aluno/NomePessoa
        }
        catch(FileNotFoundException e){
            
        }
        catch(NullPointerException e){
            
        }
        catch(Exception e){
            
        } 
        finally {
            try {
                input.close();
            } catch(Exception ex) {
                // Nao faz nada!
            }
        }
        return objeto;
    }
}
