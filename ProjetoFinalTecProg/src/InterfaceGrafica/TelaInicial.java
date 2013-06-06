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
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import util.HoraException;
import util.IPCadastradoException;
import util.IPinvalidoException;
import util.NameException;
import util.NaoDesligavelException;

public class TelaInicial extends javax.swing.JFrame {

    /** Creates new form Main */
    public TelaInicial() {
        initComponents();
        cadastrados_list.setModel(Cadastro.lista);
        lista_on.setModel(Cadastro.lista_ligados);
        lista_monitoramento.setModel(Cadastro.lista_ligados);
        lista_select.setModel(Cadastro.lista_selected);
        sim.setSelected(true);

        atualizarIdiomaTela();
    }

    private void atualizarIdiomaTela() {
        setTitle(Main.myResources.getString("programa.nome"));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, Main.myResources.getString("cadastro.titulo.janela"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        jLabel2.setText(Main.myResources.getString("cadastro.atributo.nome"));
        jLabel1.setText(Main.myResources.getString("cadastro.atributo.ip"));
        jLabel3.setText(Main.myResources.getString("cadastro.atributo.horario"));
        jLabel5.setText(Main.myResources.getString("cadastro.atributo.desligada"));
        sim.setText(Main.myResources.getString("cadastro.atributo.sim"));
        nao.setText(Main.myResources.getString("cadastro.atributo.nao"));
        jButton5.setText(Main.myResources.getString("cadastro.botao.cadastrar"));
        jTabbedPane1.addTab(Main.myResources.getString("cadastro.titulo.aba"), cadastro_panel);
        lista_monitoramento.setBorder(javax.swing.BorderFactory.createTitledBorder(null, Main.myResources.getString("monitoramento.titulo.janela"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        jTabbedPane1.addTab(Main.myResources.getString("monitoramento.titulo.aba"), monitoramento_panel);
        cadastrados_list.setBorder(javax.swing.BorderFactory.createTitledBorder(null, Main.myResources.getString("maquinas.titulo.janela"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        jButton6.setText(Main.myResources.getString("maquinas.botao.deletar"));
        jButton8.setText(Main.myResources.getString("maquinas.botao.alterar"));
        jTabbedPane1.addTab(Main.myResources.getString("maquinas.titulo.aba"), jPanel1);
        lista_select.setBorder(javax.swing.BorderFactory.createTitledBorder(null, Main.myResources.getString("desligamento.lista2.titulo"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        lista_on.setBorder(javax.swing.BorderFactory.createTitledBorder(null, Main.myResources.getString("desligamento.lista1.titulo"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        jButton3.setText(Main.myResources.getString("desligamento.botao.desligar"));
        jLabel4.setText(Main.myResources.getString("desligamento.atributo.horario"));
        jButton7.setText(Main.myResources.getString("delisgamento.botao.alterar"));
        jTabbedPane1.addTab(Main.myResources.getString("desligamento.titulo.aba"), desligamento_panel);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        cadastro_panel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        hora_tf = new javax.swing.JFormattedTextField();
        ip_tf = new javax.swing.JTextField();
        nome_tf = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        sim = new javax.swing.JRadioButton();
        nao = new javax.swing.JRadioButton();
        jButton5 = new javax.swing.JButton();
        barra_idioma = new javax.swing.JComboBox();
        monitoramento_panel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        lista_monitoramento = new javax.swing.JList();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        cadastrados_list = new javax.swing.JList();
        jButton6 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        desligamento_panel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lista_select = new javax.swing.JList();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        lista_on = new javax.swing.JList();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        hora_tf2 = new javax.swing.JFormattedTextField();
        jButton7 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Desligamento Remoto");

        cadastro_panel.setToolTipText("");
        cadastro_panel.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cadastro de Máquina", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        jPanel2.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel2.setText("Nome da Máquina:");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(36, 30, 140, 17);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel1.setText("IP:");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(36, 70, 60, 17);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel3.setText("Horário de Desligamento:");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(30, 150, 180, 17);

        try {
            hora_tf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel2.add(hora_tf);
        hora_tf.setBounds(200, 150, 53, 30);
        jPanel2.add(ip_tf);
        ip_tf.setBounds(186, 70, 114, 30);

        nome_tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nome_tfActionPerformed(evt);
            }
        });
        jPanel2.add(nome_tf);
        nome_tf.setBounds(186, 30, 114, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel5.setText("Pode ser desligada?");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(30, 110, 120, 17);

        sim.setText("Sim");
        sim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simActionPerformed(evt);
            }
        });
        jPanel2.add(sim);
        sim.setBounds(180, 110, 50, 23);

        nao.setText("Nao");
        nao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                naoActionPerformed(evt);
            }
        });
        jPanel2.add(nao);
        nao.setBounds(240, 110, 50, 23);

        cadastro_panel.add(jPanel2);
        jPanel2.setBounds(40, 40, 340, 190);

        jButton5.setText("Cadastrar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        cadastro_panel.add(jButton5);
        jButton5.setBounds(140, 240, 102, 33);

        barra_idioma.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "pt_BR", "en_US" }));
        barra_idioma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                barra_idiomaActionPerformed(evt);
            }
        });
        cadastro_panel.add(barra_idioma);
        barra_idioma.setBounds(310, 240, 80, 30);

        jTabbedPane1.addTab("Cadastro", cadastro_panel);

        monitoramento_panel.setLayout(null);

        lista_monitoramento.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Computadores da Rede", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        jScrollPane3.setViewportView(lista_monitoramento);

        monitoramento_panel.add(jScrollPane3);
        jScrollPane3.setBounds(10, 10, 400, 260);

        jTabbedPane1.addTab("Monitoramento", monitoramento_panel);

        jPanel1.setLayout(null);

        cadastrados_list.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Máquinas Cadastradas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        jScrollPane4.setViewportView(cadastrados_list);

        jPanel1.add(jScrollPane4);
        jScrollPane4.setBounds(10, 11, 396, 200);

        jButton6.setText("Deletar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6);
        jButton6.setBounds(30, 220, 130, 40);

        jButton8.setText("Alterar");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton8);
        jButton8.setBounds(260, 220, 130, 40);

        jTabbedPane1.addTab("Máquinas Cadastradas", jPanel1);

        desligamento_panel.setLayout(null);

        lista_select.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Selecionadas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        jScrollPane1.setViewportView(lista_select);

        desligamento_panel.add(jScrollPane1);
        jScrollPane1.setBounds(260, 60, 130, 160);

        jButton1.setText(">");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        desligamento_panel.add(jButton1);
        jButton1.setBounds(180, 90, 50, 30);

        jButton2.setText("<");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        desligamento_panel.add(jButton2);
        jButton2.setBounds(180, 150, 50, 30);

        lista_on.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Na Rede", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        jScrollPane2.setViewportView(lista_on);

        desligamento_panel.add(jScrollPane2);
        jScrollPane2.setBounds(20, 60, 130, 160);

        jButton3.setText("Desligar Agora!");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        desligamento_panel.add(jButton3);
        jButton3.setBounds(20, 230, 180, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel4.setText("Horário de Desligamento:");
        desligamento_panel.add(jLabel4);
        jLabel4.setBounds(20, 20, 170, 17);

        try {
            hora_tf2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        desligamento_panel.add(hora_tf2);
        hora_tf2.setBounds(190, 10, 60, 30);

        jButton7.setText("Alterar Horário");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        desligamento_panel.add(jButton7);
        jButton7.setBounds(220, 230, 170, 30);

        jTabbedPane1.addTab("Desligamento Remoto", desligamento_panel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nome_tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nome_tfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nome_tfActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        if (lista_select.isSelectionEmpty()) {
            return;
        }
        Cadastro.lista_selected.remove(lista_select.getSelectedIndex());

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {

            util.NameException.validarNome(nome_tf.getText());
            util.HoraException.validarHora(hora_tf.getText());
            IPinvalidoException.validarIP(ip_tf.getText());

            InetAddress ip = InetAddress.getByName(ip_tf.getText());
            IPCadastradoException.isCadastrado(ip);

            int hora, minuto, segundo;
            String parte;
            parte = String.valueOf(hora_tf.getText().charAt(0)) + String.valueOf(hora_tf.getText().charAt(1));
            hora = Integer.parseInt(parte);
            parte = String.valueOf(hora_tf.getText().charAt(3)) + String.valueOf(hora_tf.getText().charAt(4));
            minuto = Integer.parseInt(parte);
            parte = String.valueOf(hora_tf.getText().charAt(6)) + String.valueOf(hora_tf.getText().charAt(7));
            segundo = Integer.parseInt(parte);


            Cadastro.computadorAdd(nome_tf.getText(), ip, hora, minuto, segundo, sim.isSelected());
            JOptionPane.showMessageDialog(null, Main.myResources.getString("mensagem.cadastro.sucesso"), Main.myResources.getString("mensagem.cadastro.sucesso.titulo"), 1);
            nome_tf.setText("");
            ip_tf.setText("");
            hora_tf.setText("");
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
        } catch (IPinvalidoException e) {
            JOptionPane.showMessageDialog(null, Main.myResources.getString("mensagem.erro.ipincorreto"), Main.myResources.getString("mensagem.erro.titulo"), 1);
            ip_tf.setText("");
        }

    }//GEN-LAST:event_jButton5ActionPerformed

private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
    if (cadastrados_list.isSelectionEmpty()) {
        return;
    }
    int index = cadastrados_list.getSelectedIndex();
    Computador pc = (Computador) Cadastro.lista.getElementAt(index);

    Editar janela = new Editar(new TelaInicial(), true, pc, index);
    janela.setLocationRelativeTo(null);
    janela.setResizable(false);
    janela.setVisible(true);

}//GEN-LAST:event_jButton8ActionPerformed

private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
    if (cadastrados_list.isSelectionEmpty()) {
        return;
    }

    if (JOptionPane.showConfirmDialog(cadastro_panel, Main.myResources.getString("mensagem.remover.confirmar")) != 0) {
        return;
    }
    Cadastro.deletarPC(cadastrados_list.getSelectedIndex());
    Cadastro.atualizarDados();


}//GEN-LAST:event_jButton6ActionPerformed

private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    for (int i = 0; i < Cadastro.lista_selected.size(); i++) {
        Computador pc = (Computador) Cadastro.lista_selected.getElementAt(i);

        try {
            NaoDesligavelException.isDesligavel(pc);

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
            System.out.println(Main.myResources.getString("mensagem.erro.clienteinicializado") + pc.getNome());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NaoDesligavelException e) {
            JOptionPane.showMessageDialog(null, Main.myResources.getString("mensagem.erro.ndesligado") + pc.getNome(), Main.myResources.getString("mensagem.erro.titulo"), 1);
        }

    }
    Cadastro.lista_selected.clear();
}//GEN-LAST:event_jButton3ActionPerformed

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    if (lista_on.isSelectionEmpty()) {
        return;
    }

    Computador pc = (Computador) lista_on.getSelectedValue();
    for (int i = 0; i < Cadastro.lista_selected.size(); i++) {
        if (Cadastro.lista_selected.getElementAt(i).equals(pc)) {
            return;
        }
    }
    Cadastro.lista_selected.addElement(pc);
}//GEN-LAST:event_jButton1ActionPerformed

private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed

    try {
        int hora, minuto, segundo;
        String parte;

        parte = String.valueOf(hora_tf2.getText().charAt(0)) + String.valueOf(hora_tf2.getText().charAt(1));
        hora = Integer.parseInt(parte);
        parte = String.valueOf(hora_tf2.getText().charAt(3)) + String.valueOf(hora_tf2.getText().charAt(4));
        minuto = Integer.parseInt(parte);
        parte = String.valueOf(hora_tf2.getText().charAt(6)) + String.valueOf(hora_tf2.getText().charAt(7));
        segundo = Integer.parseInt(parte);

        for (int index = 0; index < Cadastro.lista_selected.size(); index++) {
            Computador pc = (Computador) Cadastro.lista_selected.getElementAt(index);
            int i = Cadastro.computadores.indexOf(pc);
            pc.setHoras(hora);
            pc.setMinutos(minuto);
            pc.setSegundos(segundo);
            Cadastro.addByObject(pc, i);
        }

        Cadastro.checar();
        Cadastro.lista_selected.clear();
        JOptionPane.showMessageDialog(null, Main.myResources.getString("mensagem.cadastro.editar.sucesso"), Main.myResources.getString("mensagem.cadastro.sucesso.titulo"), 1);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, Main.myResources.getString("mensagem.cadastro.editar.hora"), Main.myResources.getString("mensagem.erro.titulo"), 1);
        hora_tf2.setText("");
    }


}//GEN-LAST:event_jButton7ActionPerformed

private void simActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simActionPerformed
    sim.setSelected(true);
    nao.setSelected(false);
}//GEN-LAST:event_simActionPerformed

private void naoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_naoActionPerformed
    sim.setSelected(false);
    nao.setSelected(true);
}//GEN-LAST:event_naoActionPerformed

private void barra_idiomaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_barra_idiomaActionPerformed
    if (barra_idioma.getSelectedIndex() == 0) {
        Main.myResources = ResourceBundle.getBundle("International/Messages", Locale.getDefault());
    } else {
        Main.myResources = ResourceBundle.getBundle("International/Messages", Locale.US);
    }

    atualizarIdiomaTela();

}//GEN-LAST:event_barra_idiomaActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox barra_idioma;
    private javax.swing.JList cadastrados_list;
    private javax.swing.JPanel cadastro_panel;
    private javax.swing.JPanel desligamento_panel;
    private javax.swing.JFormattedTextField hora_tf;
    private javax.swing.JFormattedTextField hora_tf2;
    private javax.swing.JTextField ip_tf;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JList lista_monitoramento;
    private javax.swing.JList lista_on;
    private javax.swing.JList lista_select;
    private javax.swing.JPanel monitoramento_panel;
    private javax.swing.JRadioButton nao;
    private javax.swing.JTextField nome_tf;
    private javax.swing.JRadioButton sim;
    // End of variables declaration//GEN-END:variables
}
