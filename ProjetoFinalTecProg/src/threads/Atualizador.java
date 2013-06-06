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

public class Atualizador extends Thread {

    /**
     * metodo reescrito da classe thread, que representa o codigo que sera execu
     * tado quando a thread for iniciada. Essa thread chama o metodo checar perio
     * dicamente para checar os computadores que estao na rede e atualizar a lista.
     */
    public void run() {
        while (true) {
            Cadastro.checar();
            try {
                sleep(5000);
            } catch (InterruptedException e) {
            }
        }
    }
}
