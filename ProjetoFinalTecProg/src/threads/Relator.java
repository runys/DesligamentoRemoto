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
import desligamentoremoto.Main;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

public class Relator extends Thread {

    /**
     * metodo reescrito da classe thread, que representa o codigo que sera execu
     * tado quando a thread for iniciada. Esse metodo é responsável por armazenar
     * em um arquivo texto todas as vezes que um computador for desligado ou ligado.
     * Sendo assim ele permanece rodando durante toda a execução do programa para 
     * checar quando um computador foi desligado ou ligado. Entao ele escreve tal
     * informação num arquivo de texto com o nome do computador, de forma a manter
     * uma espécie de relatório para saber quando o computador esteve ligado e quando
     * ele foi desligado.
     */
    public void run() {
        while (true) {
            try {
                sleep(2000);

                Iterator i = Cadastro.computadores_ligados.iterator();
                while (i.hasNext()) {
                    Computador pc = (Computador) i.next();

                    try {
                        FileReader file = new FileReader(pc.getNome() + ".txt");
                        BufferedReader fileReader = new BufferedReader(file);
                        FileWriter o = new FileWriter(pc.getNome() + ".txt", true);
                        PrintWriter out = new PrintWriter(o, true);
                        fileReader.mark(200);
                        String ultimaLinha = "";

                        while (fileReader.readLine() != null) {
                            fileReader.reset();
                            ultimaLinha = fileReader.readLine();
                            fileReader.mark(200);
                        }
                        if (ultimaLinha.charAt(0) == 'l') {
                        } else {
                            out.println(Main.myResources.getString("relator.ligado.hora") + HoraAtual.hora + ":" + HoraAtual.minuto + ":" + HoraAtual.segundo + Main.myResources.getString("relator.ligado.data") + HoraAtual.dia + "/" + HoraAtual.mes + "/" + HoraAtual.ano);
                        }
                        out.flush();
                        o.close();
                        file.close();
                        fileReader.close();
                    } catch (FileNotFoundException e) {
                        FileWriter o = new FileWriter(pc.getNome() + ".txt", true);
                        PrintWriter out = new PrintWriter(o, true);
                        out.println(Main.myResources.getString("relator.ligado.hora") + HoraAtual.hora + ":" + HoraAtual.minuto + ":" + HoraAtual.segundo + Main.myResources.getString("relator.ligado.data") + HoraAtual.dia + "/" + HoraAtual.mes + "/" + HoraAtual.ano);
                        out.flush();
                        out.close();
                        o.close();
                    }
                }//end while do iterator
            } catch (InterruptedException e) {
            } catch (IOException e) {
            }
        }//while true
    }
}
