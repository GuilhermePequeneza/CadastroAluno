package src;

import src.Saida.*;
import src.Entrada.*;

/**
 * ArmazenadorLista implementa a Interface IArmazenador usando Lista Ligada.
 *
 * Diferente do ArmazenadorArray, aqui não há tamanho máximo fixo.
 * Cada aluno é guardado em um Nó que aponta para o próximo.
 *
 *   [cabeca] -> [No:Aluno1] -> [No:Aluno2] -> [No:Aluno3] -> null
 *
 * @author Felipe Estima
 * @author Guilherme Pequeneza
 * @author Igor Dias
 * @author Thierry Nadjarian 
 * 
 * @version 10/05/26
 */
public class ArmazenadorLista implements IArmazenador {

    IEntrada entrada;
    ISaida saida;
    boolean isGrafica = true;

    private No cabeca;       // primeiro nó da lista (null = lista vazia)
    private int qtdAlunos;   // quantidade atual de alunos
    private int qtdMaxima;   // limite definido pelo usuário
    
    public class No {
    Aluno aluno;   // objeto armazenado neste nó
    No proximo;    // referência para o próximo nó (null = fim da lista)
    
    /**
     * Nó da Lista Ligada.
     * Cada nó guarda um Aluno e aponta para o próximo nó da lista.
     */
    No(Aluno aluno) {
        this.aluno = aluno;
        this.proximo = null;
        }
    }
    /**
     * Construtor: inicia a lista vazia com um limite máximo.
     *
     * @param qtd Quantidade máxima de alunos permitida
     */
    ArmazenadorLista(int qtd) {
        if (isGrafica) {
            entrada = new EntradaGrafica();
            saida = new SaidaGrafica();
        } else {
            entrada = new EntradaTexto();
            saida = new SaidaTexto();
        }
        qtdMaxima = qtd;
        cabeca = null;   // lista começa vazia
        qtdAlunos = 0;
    }

    /**
     * Insere um aluno no FINAL da lista.
     *
     * Caminha até o último nó e liga o novo nó lá.
     * Se a lista estiver vazia, o novo nó vira a cabeça.
     *
     * @param a Objeto Aluno a inserir
     * @return true se inserido, false se limite atingido
     */
    public boolean inserirAluno(Aluno a) {
        if (qtdAlunos == qtdMaxima) {
            return false;
        }

        No novoNo = new No(a);

        if (cabeca == null) {
            // lista vazia: novo nó é a cabeça
            cabeca = novoNo;
        } else {
            // percorre até o último nó
            No atual = cabeca;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            // liga o último nó ao novo
            atual.proximo = novoNo;
        }

        qtdAlunos++;
        return true;
    }

    /**
     * Verifica se o RA já existe na lista.
     *
     * Percorre todos os nós comparando o RA.
     *
     * @param ra RA a verificar
     * @return true se RA disponível (não existe), false se já existe
     */
    public boolean verificarRa(String ra) {
        No atual = cabeca;
        while (atual != null) {
            if (atual.aluno.getRA().equals(ra)) {
                return false; // RA já existe
            }
            atual = atual.proximo;
        }
        return true; // RA disponível
    }

    /**
     * Remove o aluno com o RA informado.
     *
     * Redirecionamos o ponteiro do anterior para o proximo
     * fica assim: anterior -> atual -> proximo
     *              anterior -> proximo
     *
     * @param ra RA do aluno a remover
     * @return true se removido, false se não encontrado
     */
    public boolean removerAluno(String ra) {
        if (cabeca == null) {
            return false;
        }

        // caso especial: o aluno a remover é a cabeça da lista
        if (cabeca.aluno.getRA().equals(ra)) {
            cabeca = cabeca.proximo; // cabeça passa a ser o segundo nó
            qtdAlunos--;
            return true;
        }

        // percorre procurando o nó ANTERIOR ao que será removido
        No anterior = cabeca;
        No atual = cabeca.proximo;

        while (atual != null) {
            if (atual.aluno.getRA().equals(ra)) {
                // pula o nó atual: anterior aponta pro próximo do atual
                anterior.proximo = atual.proximo;
                qtdAlunos--;
                return true;
            }
            anterior = atual;
            atual = atual.proximo;
        }

        return false; // não encontrado
    }

    /**
     * Lista todos os alunos percorrendo a lista do início ao fim.
     */
    public void listarAlunos() {
        if (qtdAlunos == 0) {
            saida.mostrarMsg("Nao existem Alunos\n");
            return;
        }

        No atual = cabeca;
        while (atual != null) {
            saida.mostrarMsg(atual.aluno.toString());
            atual = atual.proximo;
        }
    }

    /**
     * Edita o aluno com o RA informado.
     *
     * Percorre a lista até achar o nó e edita o aluno dentro dele.
     *
     * @param ra RA do aluno a editar
     * @return true se editado, false se não encontrado
     */
    public boolean editarAluno(String ra) {
        No atual = cabeca;

        // percorre a lista procurando o RA
        while (atual != null) {
            if (atual.aluno.getRA().equals(ra)) {
                // achou o nó — pode editar o aluno dentro do nó
                if (isGrafica) {
                    TelaEdicao telaEdicao = new TelaEdicao();
                    new Edicao(telaEdicao, atual.aluno);
                    telaEdicao.setVisible(true);
                } else {
                    saida.mostrarMsg("--- Editando Aluno: " + atual.aluno.getRA() + " ---");

                    String inputNome = entrada.lerString("Novo nome? (em branco para manter '" + atual.aluno.nome.toString() + "')");
                    if (inputNome != null && !inputNome.trim().isEmpty()) {
                        atual.aluno.nome = new NomePessoa(inputNome.trim());
                    }

                    String inputIdade = entrada.lerString("Nova idade? (em branco para manter '" + atual.aluno.idade + "')");
                    if (inputIdade != null && !inputIdade.trim().isEmpty()) {
                        try {
                            atual.aluno.idade = Integer.parseInt(inputIdade.trim());
                        } catch (NumberFormatException e) {
                            saida.mostrarMsg("Idade inválida! A antiga será mantida.");
                        }
                    }

                    String inputDisciplina = entrada.lerString("Nova disciplina? (em branco para manter '" + atual.aluno.getDisciplina() + "')");
                    if (inputDisciplina != null && !inputDisciplina.trim().isEmpty()) {
                        atual.aluno.setDisciplina(inputDisciplina.trim());
                    }

                    String inputSemestre = entrada.lerString("Novo semestre? (em branco para manter '" + atual.aluno.getSemestre() + "')");
                    if (inputSemestre != null && !inputSemestre.trim().isEmpty()) {
                        try {
                            atual.aluno.setSemestre(Integer.parseInt(inputSemestre.trim()));
                        } catch (NumberFormatException e) {
                            saida.mostrarMsg("Semestre inválido! O antigo será mantido.");
                        }
                    }


                    saida.mostrarMsg("Edição concluída com sucesso!");
                }
                return true;
                
            }
            atual = atual.proximo;
        }

        return false; // RA não encontrado
    }

    /**
     * Converte a lista ligada para um array de Alunos.
     * Necessário para compatibilidade com salvamento em arquivo.
     *
     * @return Array com todos os alunos na ordem da lista
     */
    public Aluno[] getAlunos() {
        Aluno[] resultado = new Aluno[qtdAlunos];
        No atual = cabeca;
        int i = 0;
        while (atual != null) {
            resultado[i] = atual.aluno;
            i++;
            atual = atual.proximo;
        }
        return resultado;
    }

    public int getQtdMaxima() {
        return qtdMaxima;
    }

    public int getQtdAlunos() {
        return qtdAlunos;
    }
}