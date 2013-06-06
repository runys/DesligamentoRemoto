/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author Marcos
 */
public class IPinvalidoException extends Exception {

    public IPinvalidoException() {
    }

    public IPinvalidoException(String message) {
        super(message);
    }

    public static void validarIP(String x) throws IPinvalidoException {
        if (x.equals("")) {
            throw new IPinvalidoException();
        }
    }
}
