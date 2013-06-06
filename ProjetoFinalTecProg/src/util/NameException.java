/**
 * Universidade de Brasilia
 * Faculdade UnB - Campus Gama
 * Disciplina: Tecnicas de Programacao
 * Professor: Giovanni Almeida Santos
 * Projeto Final 
 * Alunos: - Marcos Ronaldo Pereira Junior
 *           Matricula: 09/0124511
 *         - Tiago Gomes Pereira
 *           Matricula: 09/0134222
 * 
 * @author Marcos Ronaldo Pereira Junior
 * @author Tiago Gomes Pereira
 * 
 */
package util;

public class NameException extends Exception {

    public NameException() {
    }

    public NameException(String message) {
        super(message);
    }

    /**
     * Metodo que valida o nome inserido como parametro. se o nome nao for valido,
     * ele lança uma excessao do tipo NameException. Caso contrario nada acontece.
     * 
     * @param nome nome a ser validado
     * @throws NameException excessao que indica que o nome nao e valido
     */
    public static void validarNome(String nome) throws NameException {
        if (nome.equals("")) {
            throw new NameException();
        }
    }
}
