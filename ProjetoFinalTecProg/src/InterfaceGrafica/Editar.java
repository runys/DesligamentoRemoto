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
package InterfaceGrafica;

import Persistencia.Cadastro;
import Persistencia.Computador;
import desligamentoremoto.Main;
import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.swing.JOptionPane;
import util.HoraException;
import util.IPCadastradoException;
import util.IPinvalidoException;
import util.NameException;

/**
 *
 * @author marcos
 */
public class Editar extends javax.swing.JDialog {

    Computador pc;
    int index;

    public Editar(java.awt.Frame parent, boolean modal, Computador _pc, int i) {
        super(parent, modal);
        initComponents();
        this.pc = _pc;
        this.index = i;

        nome_tf.setText(pc.getNome());
        ip_tf.setText(String.valueOf(pc.getIp()).substring(1));

        String hora = String.valueOf(pc.getHoras());
        String minutos = String.valueOf(pc.getMinutos());
        String segundos = String.valueOf(pc.getSegundos());

        sim.setSelected(pc.isDesligavel());
        nao.setSelected(!pc.isDesligavel());

        if (hora.length() != 2) {
            hora = '0' + hora;
        }

        if (minutos.length() != 2) {
            minutos = '0' + minutos;
        }

        if (segundos.length() != 2) {
            segundos = '0' + segundos;
        }

        hora = hora + minutos + segundos;

        hora_tf.setText(hora);
        setTitle(Main.myResources.getString("editar.janela.titulo"));
        jLabel1.setText(Main.myResources.getString("editar.atributo.nome"));
        jLabel2.setText(Main.myResources.getString("editar.atributo.ip"));
        jLabel3.setText(Main.myResources.getString("editar.atributo.desligamento"));
        jButton2.setText(Main.myResources.getString("editar.botao.cancelar"));
        jButton1.setText(Main.myResources.getString("editar.botao.editar"));
        jLabel4.setText(Main.myResources.getString("editar.atributo.desligavel"));
        sim.setText(Main.myResources.getString("editar.atributo.sim"));
        nao.setText(Main.myResources.getString("editar.atributo.nao"));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nome_tf = new javax.swing.JTextField();
        ip_tf = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        hora_tf = new javax.swing.JFormattedTextField();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        sim = new javax.swing.JRadioButton();
        nao = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editar Cadastro");

        jLabel1.setText("Nome:");

        jLabel2.setText("IP:");

        jLabel3.setText("Desligamento:");

        try {
            hora_tf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        hora_tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hora_tfActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("Editar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setText("Desligavel:");

        sim.setText("sim");
        sim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simActionPerformed(evt);
            }
        });

        nao.setText("não");
        nao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                naoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ip_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nome_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)
                        .addGap(29, 29, 29)
                        .addComponent(hora_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)
                        .addGap(27, 27, 27)
                        .addComponent(sim)
                        .addGap(18, 18, 18)
                        .addComponent(nao))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nome_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(ip_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(sim)
                    .addComponent(nao))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(hora_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void hora_tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hora_tfActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_hora_tfActionPerformed

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

    try {
        util.NameException.validarNome(nome_tf.getText());
        util.HoraException.validarHora(hora_tf.getText());
        IPinvalidoException.validarIP(ip_tf.getText());
        InetAddress ip = InetAddress.getByName(ip_tf.getText());
        IPCadastradoException.existeOutroIp(ip, pc);

        int hora, minuto, segundo;
        String parte;

        parte = String.valueOf(hora_tf.getText().charAt(0)) + String.valueOf(hora_tf.getText().charAt(1));
        hora = Integer.parseInt(parte);
        parte = String.valueOf(hora_tf.getText().charAt(3)) + String.valueOf(hora_tf.getText().charAt(4));
        minuto = Integer.parseInt(parte);
        parte = String.valueOf(hora_tf.getText().charAt(6)) + String.valueOf(hora_tf.getText().charAt(7));
        segundo = Integer.parseInt(parte);


        pc.setNome(nome_tf.getText());
        pc.setIp(ip);
        pc.setHoras(hora);
        pc.setMinutos(minuto);
        pc.setSegundos(segundo);
        pc.setDesligavel(sim.isSelected());
        Cadastro.addByObject(pc, index);
        JOptionPane.showMessageDialog(null, Main.myResources.getString("mensagem.cadastro.editar.sucesso"), Main.myResources.getString("mensagem.cadastro.sucesso.titulo"), 1);
        this.dispose();
    } catch (HoraException e) {
        JOptionPane.showMessageDialog(null, Main.myResources.getString("mensagem.erro.hora"), Main.myResources.getString("mensagem.erro.titulo"), 1);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, Main.myResources.getString("mensagem.erro.horavazia"), Main.myResources.getString("mensagem.erro.titulo"), 1);
        hora_tf.setText("");
    } catch (NameException nome) {
        JOptionPane.showMessageDialog(null, Main.myResources.getString("mensagem.erro.nomevazio"), Main.myResources.getString("mensagem.erro.titulo"), 1);
    } catch (UnknownHostException e) {
        JOptionPane.showMessageDialog(null, Main.myResources.getString("mensagem.erro.ipincorreto"), Main.myResources.getString("mensagem.erro.titulo"), 1);
        ip_tf.setText("");
    } catch (IPCadastradoException e) {
        JOptionPane.showMessageDialog(null, Main.myResources.getString("mensagem.erro.ipcadastrado"), Main.myResources.getString("mensagem.erro.titulo"), 1);
        ip_tf.setText("");
    }catch (IPinvalidoException e) {
        JOptionPane.showMessageDialog(null, Main.myResources.getString("mensagem.erro.ipincorreto"), Main.myResources.getString("mensagem.erro.titulo"), 1);
        ip_tf.setText("");
    }
}//GEN-LAST:event_jButton1ActionPerformed

private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    this.dispose();
}//GEN-LAST:event_jButton2ActionPerformed

private void simActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simActionPerformed
    sim.setSelected(true);
    nao.setSelected(false);
}//GEN-LAST:event_simActionPerformed

private void naoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_naoActionPerformed
    nao.setSelected(true);
    sim.setSelected(false);
}//GEN-LAST:event_naoActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField hora_tf;
    private javax.swing.JTextField ip_tf;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton nao;
    private javax.swing.JTextField nome_tf;
    private javax.swing.JRadioButton sim;
    // End of variables declaration//GEN-END:variables
}
