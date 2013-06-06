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

public class HoraException extends Exception {

    public HoraException() {
    }

    public HoraException(String message) {
        super(message);
    }

    /**
     * Metodo que valida a hora inserida no parametro. se a hora nao for valida,
     * ele lança uma excessao do tipo HoraException. Caso contrario nada acontece.
     * 
     * @param hora hora a ser validada
     * @throws HoraException excessao que indica que a hora esta incorreta
     */
    public static void validarHora(String hora) throws HoraException {
        int horaa, minuto, segundo;
        String parte;

        parte = String.valueOf(hora.charAt(0)) + String.valueOf(hora.charAt(1));
        horaa = Integer.parseInt(parte);
        parte = String.valueOf(hora.charAt(3)) + String.valueOf(hora.charAt(4));
        minuto = Integer.parseInt(parte);
        parte = String.valueOf(hora.charAt(6)) + String.valueOf(hora.charAt(7));
        segundo = Integer.parseInt(parte);

        if (!(horaa < 24 && horaa >= 0 && minuto < 60 && minuto >= 0 && segundo < 60 && segundo >= 0)) {
            throw new HoraException();
        }


    }
}
