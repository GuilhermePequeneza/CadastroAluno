package src;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PessoaTest {

    private Pessoa pessoa;

    // O @BeforeEach roda antes de cada método de @Test, 
    // garantindo que temos um objeto novo e limpo para testar.
    @BeforeEach
    public void setUp() {
        pessoa = new Pessoa("Ana Silva", 25);
    }

    @Test
    public void testConstrutorAtribuiIdadeCorretamente() {
        // Verifica se a idade que passamos no setUp (25) foi salva na variável
        assertEquals(25, pessoa.idade, "A idade deve ser inicializada corretamente no construtor.");
    }

    @Test
    public void testConstrutorCriaObjetoNomePessoa() {
        // Verifica se o objeto NomePessoa foi instanciado (não é nulo)
        assertNotNull(pessoa.nome, "O objeto NomePessoa deve ser criado e não pode ser nulo.");
        
        // Dica: Se a sua classe NomePessoa tiver um método getNome() ou toString(), 
        // o teste ideal e completo dessa linha seria algo assim:
        // assertEquals("Ana Silva", pessoa.nome.toString(), "O nome dentro do objeto NomePessoa deve ser igual ao passado.");
    }

    @Test
    public void testToStringRetornaVazio() {
        // Testa a regra de negócio atual do seu código, que diz que o toString retorna ""
        assertEquals("", pessoa.toString(), "O método toString() deve retornar uma string vazia.");
    }
}