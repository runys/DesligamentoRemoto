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

import Persistencia.Computador;

public class NaoDesligavelException extends Exception {

    public NaoDesligavelException(String message) {
        super(message);
    }

    public NaoDesligavelException() {
    }

    /**
     * Metodo que valida se o computador pode ser desligado. se a reposta for nao,
     * quando ele for mandado desligar instantaneamente ele lancara a excessao 
     * NaoDesligavelException, e nao sera desligado.
     * 
     * @param pc computador a ser verificado se pode ser desligado
     * @throws NaoDesligavelException excessao que indica que o computador nao pode ser desligado remotamente
     */
    public static void isDesligavel(Computador pc) throws NaoDesligavelException {
        if (!pc.isDesligavel()) {
            throw new NaoDesligavelException();
        }
    }
}
