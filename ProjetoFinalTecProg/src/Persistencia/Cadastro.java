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
package Persistencia;

import desligamentoremoto.Main;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import java.util.Iterator;
import javax.swing.DefaultListModel;
import threads.TesteConexao;

public class Cadastro {

    public static final ArrayList<Computador> computadores = new ArrayList(); 
    public static final ArrayList<Computador> computadores_ligados = new ArrayList();
    public static final DefaultListModel lista = new DefaultListModel();
    public static final DefaultListModel lista_ligados = new DefaultListModel();
    public static final DefaultListModel lista_selected = new DefaultListModel();


    /**
     * Este metodo atualiza os dados presentes no arquivo de texto, basicamente 
     * reescrevendo-o quando for necessario adicionar dados ou retirar dados.
     */
    public static void atualizarDados() {
        try {
            FileWriter o = new FileWriter("ListaPC.txt");
            PrintWriter out = new PrintWriter(o);

            Iterator i = computadores.iterator();
            while (i.hasNext()) {
                Computador pc = (Computador) i.next();
                out.println(pc.getNome());
                out.println(pc.getIp());
                out.println(pc.getHoras());
                out.println(pc.getMinutos());
                out.println(pc.getSegundos());
                out.println(pc.isDesligavel());
                out.println();
            }

            out.flush();
            out.close();
            o.close();
        } catch (Exception x) {
            System.out.println(x.getMessage());
        }
    }

    /**
     * 
     * Este metodo adicona um computador ao arraylist de computadores, e em seguida
     * chama o metodo de atualizar dados para atualizar o arquivo com o novo computador
     * incluido. O novo computador e adicionado no fim do arquivo.
     * 
     * @param nome nome do computador
     * @param ip endereço ip v4 do computador
     * @param hora hora de desligamento obrigatorio do computador
     * @param minutos minutos de desligamento obrigatorio do computador
     * @param segundos segundos de desligamento obrigatorio do computador
     * @param desligavel indica se o computador pode ser desligado remotamente
     */
    public static void computadorAdd(String nome, InetAddress ip, int hora, int minutos, int segundos, boolean desligavel) {
        try {
            Computador pc = new Computador(ip, nome, hora, minutos, segundos, desligavel);
            computadores.add(pc);
            atualizarDados();
            lista.addElement(pc);
            Main.log.log(Level.INFO, "{0}{1}", new Object[]{Main.myResources.getString("log.pc.adicionado"), pc.getNome()});
        } catch (Exception E) {
            JOptionPane.showMessageDialog(null, "ERROR", "Erro no Cadastro", 1);
        }
    }

    /**
     * Esse metodo adiciona um computador no local indicado pelo indice "index"
     * removendo o computador que estava neste indice. E utilizado durante o programa
     * para alterar um cadastro, editando-o e em seguida fazendo uma sobrescrita.
     * Assim como o metodo de adicionar computador ao fim da lista, esse metodo 
     * tambem chama o metodo de atualizar dados, de forma a manter o arquivo sempre
     * atual com os computadores cadastrados.
     * 
     * @param pc objeto computador a ser adicionado
     * @param index indice onde o arquivo sera adicionado
     */
    public static void addByObject(Computador pc, int index) {
        try {
            computadores.add(index, pc);
            deletarPC(index);
            atualizarDados();
            lista.add(index, pc);
            Main.log.log(Level.INFO, "{0}{1}", new Object[]{Main.myResources.getString("log.pc.editado"), pc.getNome()});
        } catch (Exception E) {
            JOptionPane.showMessageDialog(null, "ERROR", "Erro no Cadastro", 1);
        }
    }

    /**
     * Metodo que deleta um computador armazenado em um indice "index". ele tambem
     * chama o metodo de atualizar dados para reescrever o arquivo.
     * 
     * @param index indice onde se encontra o arquivo a ser removido
     */
    public static void deletarPC(int index) {
        Computador pc = computadores.get(index);
        computadores.remove(index);
        lista.remove(index);
        
        if (computadores_ligados.contains(pc) && lista_ligados.contains(pc)) {
            lista_ligados.removeElement(pc);
            computadores_ligados.remove(pc);
        }
        Main.log.log(Level.INFO, "{0}{1}", new Object[]{Main.myResources.getString("log.pc.deletado"), pc.getNome()});
    }

    /**
     * Metodo que inicia a lista quando o programa e iniciado. Na classe main ele
     * eh invocado antes de a janela principal ser instanciada, de forma a carregar
     * os dados do arquivo na memoria, preenchendo o arraylist "computadores".
     */
    public static void iniciarLista() {
        try {
            FileReader file = new FileReader("ListaPC.txt");
            BufferedReader fileReader = new BufferedReader(file);
            fileReader.mark(200);

            while (fileReader.readLine() != null) {
                fileReader.reset();
                Computador pc = new Computador();
                pc.setNome(fileReader.readLine());
                InetAddress ip = InetAddress.getByName(fileReader.readLine().substring(1));
                pc.setIp(ip);
                pc.setHoras(Integer.parseInt(fileReader.readLine()));
                pc.setMinutos(Integer.parseInt(fileReader.readLine()));
                pc.setSegundos(Integer.parseInt(fileReader.readLine()));
                pc.setDesligavel(Boolean.valueOf(fileReader.readLine()));
                fileReader.readLine(); //pular linha
                computadores.add(pc);
                fileReader.mark(200);
            }

            file.close();
            fileReader.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Iterator i = computadores.iterator();
        while (i.hasNext()) {
            lista.addElement(i.next());
        }
    }

    /**
     * Metodo que e invocado pela thread Atualizador, de forma a manter a lista
     * de computadores ligados atualizada. ela percorre o array de computadores 
     * cadastrados e para cada computador ele incia uma thread de testeconexao
     * para ver se o computador esta alcancavel pela rede.
     */
    public static void checar() {

        Iterator i = computadores.iterator();
        while (i.hasNext()) {
            Computador pc = (Computador) i.next();
            TesteConexao teste = new TesteConexao(pc);
            teste.start();
        }
    }
}
