package src;

import java.io.*;
/**
 * Salva os objetos dados em Binario
 * 
 * @author Felipe Estima
 * @author Guilherme Pequeneza
 * @author Igor Dias
 * @author Thierry Nadjarian 
 * 
 * @version 10/05/26
 */
public class ArquivoBinario implements IPersistencia{
    
    String nomeArq;
    
    ArquivoBinario(String nomeArq){
        this.nomeArq = nomeArq;
    }

    /**
     * Method gravarObj grava um objeto em arquivo
     *
     * @param objeto a ser gravado
     * @return Retorna quando nao foi possivel gravar
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
     * Le o objeto
     *
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
