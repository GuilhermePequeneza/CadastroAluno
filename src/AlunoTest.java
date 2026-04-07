package src;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AlunoTest {

    private Aluno aluno;

    // Esse método roda antes de cada teste, criando um aluno novo e "limpo"
    @BeforeEach
    public void setUp() {
        aluno = new Aluno("João Pedro", 20, "RA987654", "Programação Orientada a Objetos", 2);
    }

    @Test
    public void testGetRA() {
        assertEquals("RA987654", aluno.getRA(), "O RA retornado deve ser igual ao passado no construtor.");
    }

    @Test
    public void testSetDisciplinaESemestre() {
        // Altera os valores
        aluno.setDisciplina("Engenharia de Software");
        aluno.setSemestre(3);

        // Como a classe não tem getDisciplina() e getSemestre(), 
        // testamos se as variáveis foram alteradas lendo o toString()
        String resultado = aluno.toString();
        
        assertTrue(resultado.contains("Engenharia de Software"), "O toString deve conter a nova disciplina.");
        assertTrue(resultado.contains("Semestre: 3"), "O toString deve conter o novo semestre.");
    }

    @Test
    public void testToString() {
        String resultadoEsperado = "Nome: João Pedro\nIdade: 20\nRA: RA987654\nDisciplina: Programação Orientada a Objetos\nSemestre: 2";
        assertEquals(resultadoEsperado, aluno.toString(), "O formato do toString está incorreto.");
    }
}