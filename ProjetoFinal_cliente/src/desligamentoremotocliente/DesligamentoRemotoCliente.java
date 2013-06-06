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
package desligamentoremotocliente;

import java.io.*;
import java.net.*;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import metodos.Validacao;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class DesligamentoRemotoCliente {
    //porta padrão

    public static final int PORTA = 9876;
    //strings com os comandos para desligamento
    public static final String DESLIGAR = "shutdown";
    public static final String DESLIGA_COMMAND_WINDOWS = "shutdown -s";
    public static final String DESLIGA_COMMAND_UNIX = "sudo shutdown now";
    public static final String DESLIGA_COMMAND_MAC = "shutdown";
    //criação do log
    private static final Logger log = Logger.getLogger(DesligamentoRemotoCliente.class.getName());
    //internacionalização -  inicializando o documento com as mensagens
    private static ResourceBundle myResources = ResourceBundle.getBundle("desligamentoremotocliente/Messages", Locale.getDefault());

    public static void main(String[] args) {
        //cliente iniciado
        try {
            FileHandler fh = new FileHandler("%h/logCliente%g.txt");
            fh.setFormatter(new SimpleFormatter());
            log.addHandler(fh);
        } catch (IOException e) {
        }

        log.info(myResources.getString("logs.inicializacao.programa"));

        try {
            //cria um socket para entrada de dados
            Socket entrada;
            //inicializa um socket servidor para ouvir a porta 9876
            ServerSocket server = new ServerSocket(PORTA);
            log.log(Level.CONFIG, "{0}{1}", new Object[]{myResources.getString("logs.conectado.porta"), PORTA});
            //aguarda o recebimento de uma mensagem
            System.out.println(myResources.getString("prompt.aceitar.mensagem"));
            log.info(myResources.getString("logs.aguardando.mensagem"));

            while (true) {
                //socket de entrada aguarda uma mensagem 
                entrada = server.accept();
                //recebe a mensagem
                InputStream in = entrada.getInputStream();
                //le a mensagem
                BufferedReader is = new BufferedReader(new InputStreamReader(in));
                //transforma em String
                String msg = is.readLine();
                log.log(Level.INFO, "{0}{1}{2}{3}", new Object[]{myResources.getString("logs.mensagem.recebida"), entrada.getInetAddress(), myResources.getString("logs.conteudo"), msg});
                //se a mensagem for igual a "shutdown"
                if (msg.equals(DESLIGAR)) {
                    //cria um novo Runtime e um Processo
                    Runtime rt = Runtime.getRuntime();
                    Process process;
                    //Grava o sistema operacional
                    log.log(Level.INFO, "SO: {0}", System.getProperty("os.name").toLowerCase());

                    //Para cada sistema operacional há um comando diferente
                    if (Validacao.isWindows()) {
                        log.log(Level.CONFIG, "{0}" + DESLIGA_COMMAND_WINDOWS, myResources.getString("logs.comando"));
                        //atribui ao processo a execução do comando
                        process = rt.exec("shutdown -t 60"); //configura shutdown para ocorrer em 1 minuto
                        process = rt.exec(DESLIGA_COMMAND_WINDOWS);
                        log.info(myResources.getString("logs.computador.desligado"));
                    } else if (Validacao.isUnix()) {
                        log.log(Level.CONFIG, "{0}" + DESLIGA_COMMAND_UNIX, myResources.getString("logs.comando"));
                        //atribui ao processo a execução do comando
                        process = rt.exec(DESLIGA_COMMAND_UNIX);
                        log.info(myResources.getString("logs.computador.desligado"));
                    } else if (Validacao.isMac()) {
                        log.log(Level.CONFIG, "{0}" + DESLIGA_COMMAND_MAC, myResources.getString("logs.comando"));
                        //atribui ao processo a execução do comando
                        process = rt.exec(DESLIGA_COMMAND_MAC);
                        log.info(myResources.getString("logs.computador.desligado"));
                    } else {
                        log.info(myResources.getString("prompt.sem.suporte"));
                    }
                }
                //finaliza a leitura da mensagem
                while (msg != null) {
                    System.out.println(msg);
                    msg = is.readLine();
                }
                //fecha as entradas
                in.close();
                entrada.close();
            }

        } catch (SocketException a) {
            log.log(Level.WARNING, "{0}{1}", new Object[]{myResources.getString("erro.porta.indisponivel"), PORTA});
        } catch (IOException b) {
            log.warning(myResources.getString("erro.io"));
        }
    }
}
