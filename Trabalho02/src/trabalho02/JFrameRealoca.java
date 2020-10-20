/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho02;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author gusta
 */
public class JFrameRealoca extends javax.swing.JDialog {

    private ServidorDAO SDAO = new ServidorDAO();
    private CampusDAO CDAO = new CampusDAO();
    private AmbienteDAO ADAO = new AmbienteDAO();
    private MovimentacaoDonoDAO MDDAO = new MovimentacaoDonoDAO();
    private ItemDAO IDAO = new ItemDAO();
    private List<Item> Item = (List) IDAO.listar();
    private List<Servidor> Servidor = (List) SDAO.listar();
    private List<Campus> Campus = (List) CDAO.listar();
    private List<Ambiente> Ambiente = (List) ADAO.listaOrdenaCampus();

    public class ServidorAmbCount {
        private Servidor servidor;
        private int ambCount;

        public trabalho02.Servidor getServidor() {
            return servidor;
        }

        public void setServidor(trabalho02.Servidor servidor) {
            this.servidor = servidor;
        }

        public int getAmbCount() {
            return ambCount;
        }

        public void setAmbCount(int ambCount) {
            this.ambCount = ambCount;
        }

    }
    public class AmbCountComparator implements Comparator<ServidorAmbCount> {

    @Override
    public int compare(ServidorAmbCount o1, ServidorAmbCount o2) {
        if(o1.getAmbCount()< o2.getAmbCount())
            return -1;
        else if(o1.getAmbCount() == o2.getAmbCount())
            return 0;
        else return 1;
    }
}

    /**
     * Creates new form JFrameRealoca
     */
    public JFrameRealoca() {
        initComponents();
        setLocationRelativeTo(null);
        setModal(true);

        jComboBox1.addItem("Escolha um Servidor");
        jComboBox2.addItem("Escolha um Campus");
        jComboBox3.addItem("Escolha um Campus");

        for (Campus c : Campus) {
            jComboBox2.addItem(c);
            jComboBox3.addItem(c);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jComboBox3 = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Escolha um Servidor para Realocar:");

        jComboBox1.setMaximumRowCount(5);

        jLabel2.setText("Escolha o Campus destino:");

        jComboBox2.setMaximumRowCount(4);

        jComboBox3.setMaximumRowCount(5);
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        jLabel3.setText("Escolha o Campus origem:");

        jButton1.setText("Realocar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
        if (jComboBox3.hasFocus()) {
            int tam = jComboBox1.getItemCount() - 1;
            if (tam >= 1) {
                for (int i = 0; i < tam; i++) {
                    jComboBox1.removeItemAt(1);
                }
            }
            if (jComboBox3.getSelectedIndex() != 0) {
                Campus c = (Campus) jComboBox3.getSelectedItem();
                for (Servidor s : Servidor) {
                    if (s.getCampus().getId() == c.getId()) {
                        jComboBox1.addItem(s);
                    }
                }
            }
        }
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (jComboBox2.getSelectedIndex() == jComboBox3.getSelectedIndex()
                || (jComboBox1.getSelectedIndex() == 0 || jComboBox2.getSelectedIndex() == 0 || jComboBox3.getSelectedIndex() == 0)) {
            if (jComboBox2.getSelectedIndex() == jComboBox3.getSelectedIndex()) {
                JOptionPane.showMessageDialog(null, "Os Campus de Origem e Destino devem ser diferentes.");
            }
            if (jComboBox1.getSelectedIndex() == 0 || jComboBox2.getSelectedIndex() == 0 || jComboBox3.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(null, "Escolha um Servidor, Campus de origem e destino válidos.");
            }
        } else {
            int ac = 0;
            List<ServidorAmbCount> SAC = new ArrayList<>();
            Campus cd = (Campus) jComboBox2.getSelectedItem();
            Campus co = (Campus) jComboBox3.getSelectedItem();
            Servidor sr = (Servidor) jComboBox1.getSelectedItem();
            int SelectedServCount = 0;
            for (Servidor s : Servidor) {
                ac = 0;
                if (s.getCampus().getId() == co.getId()) {
                    for (Ambiente a : Ambiente) {
                        if (a.getCampus().getId() == co.getId()) {
                            if (a.getServidor().getId() == s.getId()) {
                                ac++;

                            }
                        }
                    }

                    ServidorAmbCount sac = new ServidorAmbCount();
                    sac.setServidor(s);
                    sac.setAmbCount(ac);
                    SAC.add(sac);
                }
            }
            SAC.sort(new AmbCountComparator());
            Object SACv[] = SAC.toArray();
            int posServ;
            for(int i = 0; i < SACv.length; i++) {
                ServidorAmbCount sac = (ServidorAmbCount) SACv[i];
                if(sac.getServidor().getId() == sr.getId()) {
                    posServ = i;
                    SelectedServCount = sac.getAmbCount();
                }
            }
            for(Ambiente a : Ambiente) {
                ServidorAmbCount sac = (ServidorAmbCount) SACv[0];
                if(a.getServidor().getId() == sr.getId()) {
                    a.setServidor(sac.getServidor());
                    ADAO.alterar(a);
                    for(Item i : Item) {
                        if(i.getAmbiente().getId() == a.getId()) {
                            i.setDono(sac.getServidor());
                            IDAO.alterar(i);
                        }          
                    }
                    MovimentacaoDono md = new MovimentacaoDono();
                    md.setAmbiente(a);
                    md.setData_criacao(LocalDate.now());
                    md.setData_modificacao(LocalDate.now());
                    md.setDestino(sac.getServidor());
                    md.setMotivo("Servidor posteriormente responsável foi realocado de Campus.");
                    md.setOrigem(sr);
                    MDDAO.adiciona(md);
                }
            }
            sr.setCampus(cd);
            SDAO.alterar(sr);
            dispose();

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFrameRealoca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameRealoca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameRealoca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameRealoca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameRealoca().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
