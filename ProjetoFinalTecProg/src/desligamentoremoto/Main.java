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
package desligamentoremoto;

import InterfaceGrafica.TelaInicial;
import Persistencia.Cadastro;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import threads.Atualizador;
import threads.HoraAtual;
import threads.Monitoramento;
import threads.Relator;

public class Main {

    //Log
    public static final Logger log = Logger.getLogger("logging");
    
    //Arquivo de internacionalização
    public static ResourceBundle myResources = ResourceBundle.getBundle("International/Messages", Locale.getDefault());
    //Porta
    public static final int PORTA = 9876;

    /**
     * Funcao principal do programa. Ela sera iniciada quando o programa for executado
     * e ela instancia a tela principal e as threads iniciais que serao executadas
     * ao longo do programa.
     * 
     * @param args parametros recebidos no metodos principal opcionalmente quando
     * o programa e executado.
     */
    public static void main(String[] args) {
        
        try{
            FileHandler fh = new FileHandler("%h/logServidor%g.txt");
            fh.setFormatter(new SimpleFormatter());
            log.addHandler(fh);
        }catch(IOException e){
        }
        
        log.info(myResources.getString("log.programa.iniciado"));
        Cadastro.iniciarLista();
        HoraAtual horario = new HoraAtual();
        horario.start();

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                TelaInicial tela = new TelaInicial();
                tela.setVisible(true);
                tela.setResizable(false);
            }
        });

        Atualizador at = new Atualizador();
        at.start();

        Monitoramento a = new Monitoramento();
        a.start();

        Relator rel = new Relator();
        rel.start();

    }
}
