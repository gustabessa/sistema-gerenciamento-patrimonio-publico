/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho02;

import java.time.LocalDate;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author gusta
 */
public class JFrameCriaMovItem extends javax.swing.JDialog {

    private ServidorDAO SDAO = new ServidorDAO();
    private AmbienteDAO ADAO = new AmbienteDAO();
    private ItemDAO IDAO = new ItemDAO();
    private MovimentacaoItemDAO MIDAO = new MovimentacaoItemDAO();
    private List<Object> Servidor = SDAO.listar();
    private List<Object> Ambiente = ADAO.listar();
    private List<Object> Item = IDAO.listar();
    private static MITableModel tmodel;
    /**
     * Creates new form JFrameCriaMovItem
     */
    public JFrameCriaMovItem(MITableModel tm) {
        initComponents();
        setLocationRelativeTo(null);
        setModal(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        icbox.setModel(new DefaultComboBoxModel());
        icbox.addItem("Escolha Item");
        acbox.setModel(new DefaultComboBoxModel());
        aorigem.setModel(new DefaultComboBoxModel());
        for(Object a : Ambiente) {
            aorigem.addItem(a);
        }
        Ambiente a = (Ambiente) aorigem.getSelectedItem();
        jLabel7.setText(a.getCampus().getAbreviacao());
        for(Object i1 : Item) {
            Item i = (Item) i1;
            if(i.getAmbiente().getId() == a.getId())
                icbox.addItem(i);
        }
        tmodel = tm;

        
        for(Object a1 : Ambiente) {
            acbox.addItem(a1);
        }
        Ambiente a1 = (Ambiente) acbox.getSelectedItem();
        cdestino.setText("Campus: " + a1.getCampus().getAbreviacao());
        ddestino.setText(a1.getServidor().toString());
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
        icbox = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        acbox = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        dorigem = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        ddestino = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        motivo = new javax.swing.JTextArea();
        cdestino = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        aorigem = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Item:");

        icbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                icboxActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Ambiente Origem:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Ambiente Destino:");

        acbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acboxActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Dono Origem:");

        dorigem.setEditable(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Dono Destino:");

        ddestino.setEditable(false);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Motivo:");

        motivo.setColumns(20);
        motivo.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        motivo.setRows(5);
        jScrollPane1.setViewportView(motivo);

        cdestino.setText("jLabel7");

        jButton1.setText("Confirmar");
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

        aorigem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aorigemActionPerformed(evt);
            }
        });

        jLabel7.setText("jLabel7");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(icbox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dorigem)
                    .addComponent(jSeparator1)
                    .addComponent(acbox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ddestino)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(aorigem, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel7)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(cdestino)
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(aorigem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(icbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dorigem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cdestino)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(acbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ddestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        MovimentacaoItem mi = new MovimentacaoItem();
        mi.setData_criacao(LocalDate.now());
        mi.setData_modificacao(LocalDate.now());
        Item i = (Item) icbox.getSelectedItem();
        mi.setItem(i);
        mi.setMotivo(motivo.getText());
        mi.setOrigem(i.getAmbiente());
        i.getAmbiente().setData_modificacao(LocalDate.now());
        ADAO.alterar(i.getAmbiente());
        i.setData_modificacao(LocalDate.now());
        Ambiente a = (Ambiente) acbox.getSelectedItem();
        mi.setDestino(a);
        i.setDono(a.getServidor());
        i.setAmbiente(a);
        i.getAmbiente().setData_modificacao(LocalDate.now());
        ADAO.alterar(i.getAmbiente());
        IDAO.alterar(i);
        mi = MIDAO.adiciona(mi);
        tmodel.add(mi);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void acboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acboxActionPerformed
        // TODO add your handling code here:
        if(acbox.hasFocus()) {
            Ambiente a = (Ambiente) acbox.getSelectedItem();
            cdestino.setText("Campus: " + a.getCampus().getAbreviacao());
            ddestino.setText(a.getServidor().toString());
        }
    }//GEN-LAST:event_acboxActionPerformed

    private void icboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_icboxActionPerformed
        // TODO add your handling code here:
        if(icbox.hasFocus()) {
            Item i = (Item) icbox.getSelectedItem();
            dorigem.setText(i.getDono().toString());
        }
    }//GEN-LAST:event_icboxActionPerformed

    private void aorigemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aorigemActionPerformed
        // TODO add your handling code here:
        if(aorigem.hasFocus()) {
            Ambiente a = (Ambiente) aorigem.getSelectedItem();
            jLabel7.setText(a.getCampus().getAbreviacao());
            int tam = icbox.getItemCount()-1;
            for(int i = 0; i < tam; i++) {
                icbox.removeItemAt(1);
            }
            for(Object i1 : Item) {
                Item i = (Item) i1;
                if(i.getAmbiente().getId() == a.getId())
                    icbox.addItem(i);
        }
        }
    }//GEN-LAST:event_aorigemActionPerformed

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
            java.util.logging.Logger.getLogger(JFrameCriaMovItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameCriaMovItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameCriaMovItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameCriaMovItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameCriaMovItem(tmodel).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox acbox;
    private javax.swing.JComboBox aorigem;
    private javax.swing.JLabel cdestino;
    private javax.swing.JTextField ddestino;
    private javax.swing.JTextField dorigem;
    private javax.swing.JComboBox icbox;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea motivo;
    // End of variables declaration//GEN-END:variables
}
