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

import Persistencia.Computador;
import desligamentoremoto.Main;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Socket;

public class Desligador extends Thread {

    public Computador pc;

    /**
     * Construtor do desligador.
     * @param pc computador a ser desligado
     */
    public Desligador(Computador pc) {
        this.pc = pc;
    }

    /**
     * metodo reescrito da classe thread, que representa o codigo que sera execu
     * tado quando a thread for iniciada. Ele verifica se esta na hora de desligar
     * o computador e se ele pode ser desligado. Se a resposta for sim, ele envia
     * uma mensagem ao computador atraves do ip do mesmo para ele se desligar.
     */
    public void run() {

        if (pc.getHoras() == HoraAtual.hora && pc.getMinutos() == HoraAtual.minuto && pc.isDesligavel() == true) {
            try {

                Socket conexao = new Socket(pc.getIp(), Main.PORTA);
                try {
                    //Cria uma entrada no socket de entrada
                    InputStream in = conexao.getInputStream();
                    //Uma saída para enviar a msg
                    PrintWriter os = new PrintWriter(conexao.getOutputStream());
                    //digita a mensagem
                    String msg = "shutdown";
                    //escreve a msg na saída
                    os.write(msg);
                    //fecha a saída
                    os.close();

                } catch (IOException e) {
                    System.out.println(Main.myResources.getString("mensagem.erro.conexao"));
                }
                conexao.close();
            } catch (ConnectException a) {
                System.out.println(Main.myResources.getString("mensagem.erro.clienteinicializado") + pc.getNome() );
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
