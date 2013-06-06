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

import Persistencia.Cadastro;
import Persistencia.Computador;
import java.net.InetAddress;
import java.util.Iterator;

public class IPCadastradoException extends Exception {

    public IPCadastradoException(String message) {
        super(message);
    }

    public IPCadastradoException() {
    }

        /**
     * Metodo que valida o ip inserido como parametro. se o ip ja estiver cadastrado,
     * ele lança uma excessao do tipo IPCadastradoException. Caso contrario nada
     * acontece.
     * 
     * @param ip ip a ser validado
     * @throws IPCadastradoException excessao que indica que o ip ja esta cadastrado no sistema
     */
    public static void isCadastrado(InetAddress ip) throws IPCadastradoException{
        Iterator i = Cadastro.computadores.iterator();
        while (i.hasNext()) {
            Computador pc = (Computador) i.next();
            if (pc.getIp().equals(ip)) {
                throw new IPCadastradoException();
            }
        }
    }
    
    public static void existeOutroIp(InetAddress ip, Computador pcin) throws IPCadastradoException{
        Iterator i = Cadastro.computadores.iterator();
        while (i.hasNext()) {
            Computador pc = (Computador) i.next();
            if (pc.getIp().equals(ip) && !pc.equals(pcin)) {
                throw new IPCadastradoException();
            }
        }
    }  
}
