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
package threads;

import Persistencia.Cadastro;
import Persistencia.Computador;
import java.util.Iterator;

public class Monitoramento extends Thread {

    /**
     * metodo reescrito da classe thread, que representa o codigo que sera execu
     * tado quando a thread for iniciada. Esse metodo verifica todos os computadores
     * ligados a cada 20 segundos e cria uma thread de Desligador para cada computador
     * de forma a verificar se está na hora de eles serem desligados
     */
    public void run() {

        while (true) {
            try {
                sleep(20000);
                Iterator i = Cadastro.computadores_ligados.iterator();
                while (i.hasNext()) {
                    Computador pc;
                    pc = (Computador) i.next();
                    Desligador desl = new Desligador(pc);
                    desl.start();
                }//end while do iterator
            } catch (InterruptedException e) {
            }
        }//while true
    }//end run
}//end class

