package src;

 

import src.Saida.*;
import src.Entrada.*;
import javax.swing.JOptionPane;

/**
 * ArmazenadorArray implementa a Interface do Armazenador.
 * 
 * @author Felipe Estima
 * @author Guilherme Pequenezza
 * @author Igor Dias
 * @author Thierry Nadjarian 
 * 
 * @version 06/04/26
 */
public class ArmazenadorArray implements IArmazenador
    {
    
    IEntrada entrada;
    ISaida saida;
    boolean isGrafica = true; 
    
    private int qtdMaxima;
    public Aluno[] alunos;
    int qtdAlunos;
    
    /**
     * Construtor: Armazena os alunos cadastrados em um Array
     * 
     * @param Quantidade Maxima de Alunos
     * 
     */
    ArmazenadorArray(int qtd){
        if(isGrafica){
        entrada = new EntradaGrafica();
        saida = new SaidaGrafica();     
        }
        else{
            entrada = new EntradaTexto();             
            saida = new SaidaTexto();   
        }
        qtdMaxima = qtd;
        alunos = new Aluno[qtdMaxima];
        qtdAlunos = 0;
    }
    
    /**
     * Caso a Quantidade maxima de alunos for atingida retorna a Mensagem
     * Caso a Quantidade maxima de alunos não for atingida Cria Aluno
     * 
     * @param objeto Aluno
     */
    public boolean inserirAluno(Aluno a){
        if(qtdAlunos == qtdMaxima){
            return false;
        }
        else{
            alunos[qtdAlunos] = a;
            qtdAlunos++;
            return true;
        }
    }
    
    /**
     * Verifica se o RA existe dentro da Estrutura de Dados
     * 
     * @param RA do Aluno
     * 
     * @return True ou False
     */
    public boolean verificarRa(String ra){   //metodo usado para verificar se um RA ja existe na ED
        for(int i = 0;i<qtdAlunos;i++){
            if(alunos[i].getRA().equals(ra)){                
                //saida.mostrarMsg("Já existe um aluno com esse RA, tente outro\n");
                //A mensagem de que ja existe um aluno com esse RA não sai por aqui, ela sai pelo App
                return false;
            }
        }
        return true;
    }
    
    /**
     * Remove o Aluno escolhido com base no RA disponibilizado
     * 
     * @param RA do Aluno
     */
    public boolean removerAluno(String ra){
        if(qtdAlunos == 0){
            return false;
        }
        else{
            for(int i = 0;i<qtdAlunos;i++){
                if(alunos[i].getRA().equals(ra)){
                    for(int j = i;j<qtdAlunos - 1;j++){
                        alunos[j] = alunos[j+1];
                    }
                    alunos[qtdAlunos-1] = null;
                    qtdAlunos--;
                    return true;
                }
            }
            return false;
        }
    }
    
    /**
     * 
     * Mostra todos os alunos já criados.
     * Caso vazio mostra uma mensagem
     */
    public void listarAlunos(){
        if(qtdAlunos == 0)      
            saida.mostrarMsg("Nao existem Alunos\n");
                        
        for(int i = 0;i<qtdAlunos;i++){
            saida.mostrarMsg(alunos[i].toString());                        
        }        
    }    
    
    /**
     * Dado o ra do aluno
     * É possível alterar os atributos do respectivo aluno.
     * 
     * @param RA do Aluno
     */
    public boolean editarAluno(String ra) {
        boolean achou = false;
        int i = 0;
        
        // Busca o aluno no vetor
        while(i < qtdAlunos && !achou){                  
            if(alunos[i].getRA().equals(ra)){
               achou = true;              
            } else {
               i++; 
            }
        }
        
        if(!achou){
            return false;
        } else {
            if(isGrafica){
            TelaEdicao telaEdicao = new TelaEdicao();
            new Edicao(telaEdicao, alunos[i]);        
            telaEdicao.setVisible(true); 
            }
            else{                
                saida.mostrarMsg("--- Editando Aluno: " + alunos[i].getRA() + " ---");
                
                // Editar Nome
                String inputNome = entrada.lerString("Novo nome do Aluno? (Deixe em branco para manter '" + alunos[i].nome.toString() + "')");
                if (inputNome != null && !inputNome.trim().isEmpty()) {
                    alunos[i].nome = new NomePessoa(inputNome.trim());
                }
                
                // Editar Idade
                String inputIdade = entrada.lerString("Nova Idade do Aluno? (Deixe em branco para manter '" + alunos[i].idade + "')");
                if (inputIdade != null && !inputIdade.trim().isEmpty()) {
                    try {
                        alunos[i].idade = Integer.parseInt(inputIdade.trim());
                    } catch (NumberFormatException e) {
                        saida.mostrarMsg("Idade inválida! A idade antiga será mantida.");
                    }
                }
                
                // Editar Disciplina
                String inputDisciplina = entrada.lerString("Nova disciplina? (Deixe em branco para manter '" + alunos[i].getDisciplina() + "')");
                if (inputDisciplina != null && !inputDisciplina.trim().isEmpty()) {
                    alunos[i].setDisciplina(inputDisciplina.trim());
                }
                
                // Editar Semestre
                String inputSemestre = entrada.lerString("Novo semestre? (Deixe em branco para manter '" + alunos[i].getSemestre() + "')");
                if (inputSemestre != null && !inputSemestre.trim().isEmpty()) {
                    try {
                        alunos[i].setSemestre(Integer.parseInt(inputSemestre.trim()));
                    } catch (NumberFormatException e) {
                        saida.mostrarMsg("Semestre inválido! O semestre antigo será mantido.");
                    }
                }
                
                saida.mostrarMsg("Edição concluída com sucesso no modo texto!");
            }
        }
        return true;
    }
    
    public Aluno[] getAlunos(){
        return alunos;
    }
    public int getQtdMaxima(){
        return qtdMaxima;
    }
    
    /**
     * Pega a Qtd de alunos atuais armazenados
     * 
     * @return Qtd de alunos
     */
    public int getQtdAlunos(){
        return qtdAlunos;
    }
}
