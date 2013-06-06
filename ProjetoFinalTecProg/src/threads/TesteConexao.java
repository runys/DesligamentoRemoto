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
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.UnknownHostException;

public class TesteConexao extends Thread {

    public Computador pc;

    /**
     * Construtor de testeconexao, que inicia o valor da variavel pc com o valor
     * recebida como parametro.
     * 
     * @param pc computador para ser verificado
     */
    public TesteConexao(Computador pc) {
        this.pc = pc;
    }

    /**
     * metodo reescrito da classe thread, que representa o codigo que sera execu
     * tado quando a thread for iniciada. Esse metodo verifica se o computador 
     * esta alcancavel pela rede local. Ele tem um tempo limite para resposta de
     * 3 (Tres) segundos, de forma a considerar o computador ligado apenas se o 
     * mesmo responder dentro desses 3 segundos. Entao o computador e adicionado
     * na lista de computadores ligados, e caso ele estivesse ligado e nao esta mais,
     * ele e retirado dessa lista, escrevendo no arquivo de relatorio do computador
     * juntamente com a hora que foi verificado que ele estava ligado e nao esta mais.
     */
    public void run() {
        try {
            if (pc.getIp().isReachable(3000)) {
                if (Cadastro.computadores_ligados.contains(pc) && Cadastro.lista_ligados.contains(pc)) {
                } else {
                    Cadastro.lista_ligados.addElement(pc);
                    Cadastro.computadores_ligados.add(pc);
                }
            } else {
                if (Cadastro.computadores_ligados.contains(pc) && Cadastro.lista_ligados.contains(pc)) {
                    Cadastro.lista_ligados.removeElement(pc);
                    Cadastro.computadores_ligados.remove(pc);
                    FileWriter o = new FileWriter(pc.getNome() + ".txt", true);
                    PrintWriter out = new PrintWriter(o, true);
                    out.println(Main.myResources.getString("teste.conexao.hora") + HoraAtual.hora + ":" + HoraAtual.minuto + ":" + HoraAtual.segundo + Main.myResources.getString("teste.conexao.data") + HoraAtual.dia + "/" + HoraAtual.mes + "/" + HoraAtual.ano);
                    out.close();
                    o.close();
                }
            }
        } catch (UnknownHostException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
        }
    }
}
