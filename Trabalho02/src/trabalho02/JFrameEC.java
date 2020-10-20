/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho02;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author gusta
 */
public class JFrameEC extends javax.swing.JDialog {

    /**
     * Creates new form JFrameEC
     */
    private static List<Object> campus;
    private AmbienteDAO ADAO = new AmbienteDAO();
    private ServidorDAO SDAO = new ServidorDAO();
    private ItemDAO IDAO = new ItemDAO();
    private MovimentacaoDonoDAO MDDAO = new MovimentacaoDonoDAO();

    public JFrameEC(List<Object> c) {
        initComponents();
        setLocationRelativeTo(null);
        setModal(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        jComboBox1.addItem("Escolha um Campus");
        //--
        campus = c;
        //--
//        CampusDAO CDAO = new CampusDAO();
//        campus = CDAO.listar();
        int flag = 0;
        for (Object c1 : campus) {
            jComboBox1.addItem(c1);
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
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Escolha um Campus:");

        jComboBox1.setMaximumRowCount(3);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(132, 132, 132)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(112, 112, 112)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (jComboBox1.getSelectedIndex() != 0) {
            List<Item> itens = (List) IDAO.listar();
            Campus c = (Campus) jComboBox1.getSelectedItem();
            List<Ambiente> ambientes = (List) ADAO.listar();
            List<Ambiente> ambientesori = new ArrayList<>();
            List<Servidor> servidoresorigem = new ArrayList<>();
            List<Servidor> servidoresdestino = (List) SDAO.listar();
            int acount = 0;
            for (Ambiente a : ambientes) {
                if (a.getCampus().getId() == c.getId()) {
                    servidoresorigem.add(a.getServidor());
                    ambientesori.add(a);
                    a.setServidor(null);
                    acount++;
                }
            }
                    System.out.println(ambientesori.size());
                    System.out.println(servidoresorigem.size());
            int rcount = 0;
            while (rcount < acount) {
                for (Servidor s : servidoresdestino) {
                    if (rcount == acount) {
                        break;
                    }
                    if (s.getCampus().getId() == c.getId()) {
                        int i;
                        Ambiente aaux;
                        i = new Random().nextInt(ambientesori.size());
                        aaux = ambientesori.get(i);
                        while (aaux.getServidor() != null || aaux.getCampus().getId() != c.getId()) {
                            i = new Random().nextInt(ambientesori.size());
                            aaux = ambientesori.get(i);
                        }

                        aaux.setServidor(s);
                        ADAO.alterar(aaux);
                        for (Item i1 : itens) {
                            if (i1.getAmbiente().getId() == aaux.getId()) {
                                i1.setDono(s);
                                i1.setData_modificacao(LocalDate.now());
                                IDAO.alterar(i1);
                            }
                        }
                        rcount++;
                    }
                }
            }
            for (int i = 0; i < servidoresorigem.size(); i++) {
                Ambiente a = ambientesori.get(i);
                Servidor s = servidoresorigem.get(i);
                if (a.getCampus().getId() == c.getId()) {
                    // COM ESTA VALIDAÇÃO, QUANDO UM AMBIENTE NÃO MUDA DE DONO ALEATÓRIAMENTE, A MOVIMENTAÇÃO
                    // NÃO É GERADA!
                    if (a.getServidor().getId() != s.getId()) {
                        MovimentacaoDono md = new MovimentacaoDono();
                        md.setData_criacao(LocalDate.now());
                        md.setData_modificacao(LocalDate.now());
                        md.setAmbiente(a);
                        md.setMotivo("REDISTRIBUIÇÃO ALEATÓRIA DE AMBIENTES.\nTODOS OS ITENS MUDARAM DE TITULARIDADE.");
                        md.setOrigem(s);
                        a.setData_modificacao(LocalDate.now());
                        md.setDestino(a.getServidor());
                        ADAO.alterar(a);
                        MDDAO.adiciona(md);
                    }
                }         
            }
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
            java.util.logging.Logger.getLogger(JFrameEC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameEC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameEC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameEC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameEC(campus).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
