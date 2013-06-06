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

import java.util.Calendar;

public class HoraAtual extends Thread {

    private static Calendar horario;
    static int hora, minuto, segundo, dia, mes, ano;
    
    /**
     * metodo reescrito da classe thread, que representa o codigo que sera execu
     * tado quando a thread for iniciada. Esse metodo eh executado a cada segundo
     * chamando o metodo atualizar hora, de forma a manter e atualizar a hora e 
     * a data frequentemente.
     */
    public void run() {
        while (true) {
            atualizarHora();
            try {
                sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }

    /**
     * Metodo que atualiza a data e a hora de acordo com a data e hora do sistema.
     */
    private static void atualizarHora() {
        horario = Calendar.getInstance();
        hora = horario.get(Calendar.HOUR_OF_DAY);
        minuto = horario.get(Calendar.MINUTE);
        segundo = horario.get(Calendar.SECOND);
        dia = horario.get(Calendar.DAY_OF_MONTH);
        mes = horario.get(Calendar.MONTH) + 1;
        ano = horario.get(Calendar.YEAR);
    }
}
