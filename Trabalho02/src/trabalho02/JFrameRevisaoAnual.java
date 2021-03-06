/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho02;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author gusta
 */
public class JFrameRevisaoAnual extends javax.swing.JFrame {

    /**
     * Creates new form JFrameRevisaoAnual
     */
    private RATableModel tmodel = new RATableModel();
    private RevisaoAnualDAO RADAO = new RevisaoAnualDAO();
    private AmbienteDAO ADAO = new AmbienteDAO();
    private ItemDAO IDAO = new ItemDAO();
    private ItensRevisaoDAO IRDAO = new ItensRevisaoDAO();
    private ServidorDAO SDAO = new ServidorDAO();
    private static Servidor logado;
    private List<Object> ambientes = ADAO.listar();
    private List<Object> itens = IDAO.listar();
    private List<Object> servidores = SDAO.listar();
    private List<RevisaoAnual> revisaoanual;
    private List<RevisaoAnual> revisaon = new ArrayList<RevisaoAnual>();
    private List<RevisaoAnual> revisaoe = new ArrayList<RevisaoAnual>();
    private List<RevisaoAnual> revisaoa = new ArrayList<RevisaoAnual>();

    public JFrameRevisaoAnual(Servidor s) {

        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        jTable1.setModel(tmodel);
        logado = s;
        revisaoanual = RADAO.listar();
        for (RevisaoAnual ra : revisaoanual) {
            switch (ra.getEstado()) {
                case "EM ANDAMENTO":
                    revisaoa.add(ra);
                    break;

                case "ENCERRADA":
                    revisaoe.add(ra);
                    break;

                case "NÃO INICIADA":
                    revisaon.add(ra);
                    break;
            }
        }
        sfilter.setModel(new DefaultComboBoxModel<>());
        afilter.setModel(new DefaultComboBoxModel<>());
        sfilter.addItem("Sem Filtro");
        afilter.addItem("Sem Filtro");

        for (RevisaoAnual ra : revisaoanual) {
            int flag = 0;
            int flaga = 0;
            tmodel.add(ra);
            for (int i = 0; i < sfilter.getModel().getSize(); i++) {
                if (ra.getServidor().toString().equals(sfilter.getItemAt(i).toString())) {
                    flag++;
                }
            }
            if (flag == 0) {
                sfilter.addItem(ra.getServidor());
            }
            for (int i = 0; i < afilter.getModel().getSize(); i++) {
                if (ra.getAmbiente().toString().equals(afilter.getItemAt(i).toString())) {
                    flaga++;
                }
            }
            if (flaga == 0) {
                afilter.addItem(ra.getAmbiente());
            }
        }

        jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
        TableColumnModel colModel = jTable1.getColumnModel();
        colModel.getColumn(0).setPreferredWidth(25);
        colModel.getColumn(1).setPreferredWidth(200);
        colModel.getColumn(3).setPreferredWidth(50);
        colModel.getColumn(3).setCellRenderer(new DateCellRenderer());
        colModel.getColumn(4).setCellRenderer(new DateCellRenderer());

        if (logado.getPapel().equals("comum")) {
            jButton1.setEnabled(false);
            jButton3.setEnabled(false);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        efilter = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        yfilter = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        sfilter = new javax.swing.JComboBox();
        afilter = new javax.swing.JComboBox();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(730, 507));
        setResizable(false);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTable1FocusGained(evt);
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable1KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Acessar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Criar Todas");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Filtros:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        efilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sem Filtro", "NÃO INICIADA", "EM ANDAMENTO", "ENCERRADA" }));
        efilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                efilterActionPerformed(evt);
            }
        });

        jLabel1.setText("Estado:");

        jLabel2.setText("Servidor:");

        jLabel3.setText("Ambiente:");

        jLabel4.setText("Ano:");

        yfilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yfilterActionPerformed(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/trabalho02/procurar.png"))); // NOI18N

        sfilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sfilterActionPerformed(evt);
            }
        });

        afilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                afilterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(efilter, 0, 169, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(yfilter)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(sfilter, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(afilter, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(efilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(sfilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(afilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(yfilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton3.setText("Excluir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Criar Uma");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Exportar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jMenu1.setText("Abrir");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Usuário");

        jMenuItem1.setText("Menu");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuItem2.setText("Sair");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Movimentações");

        jMenuItem3.setText("Abrir");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Revisões Anuais");

        jMenuItem4.setText("Abrir");
        jMenuItem4.setEnabled(false);
        jMenu4.add(jMenuItem4);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("CRUD");

        jMenuItem5.setText("Abrir");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem5);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        RevisaoAnual ra = null;
        if (jTable1.getSelectedRow() != -1) {
            ra = tmodel.get(jTable1.getSelectedRow());
        }
        if (ra == null) {
            JOptionPane.showMessageDialog(this, "Escolha uma revisão.");
        } else {
            if (ra.getEstado().equals("NÃO INICIADA")) {
                ra.setEstado("EM ANDAMENTO");
                tmodel.fireTableDataChanged();
            }
            ra.setData_modificacao(LocalDate.now());
            RADAO.alterar(ra);
            new JFrameAcessaRA(ra).setVisible(true);
            tmodel.fireTableDataChanged();
            atualizaListas();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int flag;
        for (Object s1 : servidores) {
            Servidor s = (Servidor) s1;
            for (Object a1 : ambientes) {
                Ambiente a = (Ambiente) a1;
                flag = 0;
                for (Object i1 : itens) {
                    Item i = (Item) i1;
                    if (a.getId() == i.getAmbiente().getId() && i.getDono().getId() == s.getId()) {
                        flag++;
                    }
                }
                if (flag != 0) {
                    RevisaoAnual ra = new RevisaoAnual();
                    ra.setAmbiente(a);
                    ra.setServidor(s);
                    ra.setData_criacao(LocalDate.now());
                    ra.setData_modificacao(LocalDate.now());
                    ra.setAno(LocalDate.now().getYear());
                    ra.setEstado("NÃO INICIADA");
                    ra = (RevisaoAnual) RADAO.adiciona(ra);
                    tmodel.add(ra);
                    for (Object i1 : itens) {
                        Item i = (Item) i1;
                        if (ra.getServidor().getId() == i.getDono().getId() && ra.getAmbiente().getId() == i.getAmbiente().getId()) {
                            ItensRevisao ir = new ItensRevisao();
                            ir.setData_criacao(LocalDate.now());
                            ir.setData_modificacao(LocalDate.now());
                            ir.setItem(i);
                            ir.setEstado(ir.getItem().getEstado());
                            ir.setRevisao(ra);
                            ir.setVerificacao("NÃO ENCONTRADO");
                            IRDAO.adiciona(ir);
                        }

                    }
                }

            }

        }
        atualizaListas();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        if (jTable1.getSelectedRowCount() > 0) {

            RevisaoAnual ra = tmodel.get(jTable1.getSelectedRow());
            if (ra.getEstado().equals("ENCERRADA")) {
                jButton1.setEnabled(false);
            } else {
                if (logado.getPapel().equals("adm")) {
                    jButton1.setEnabled(true);
                }
            }
        }

    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyReleased
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_DOWN || evt.getKeyCode() == KeyEvent.VK_UP) {
            RevisaoAnual ra = tmodel.get(jTable1.getSelectedRow());
            if (ra.getEstado().equals("ENCERRADA")) {
                jButton1.setEnabled(false);
            } else {
                if (logado.getPapel().equals("adm")) {
                    jButton1.setEnabled(true);
                }
            }
        }
    }//GEN-LAST:event_jTable1KeyReleased

    private void efilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_efilterActionPerformed
        // TODO add your handling code here:
        if (efilter.hasFocus()) {
            sfilter.setSelectedIndex(0);
            afilter.setSelectedIndex(0);
            yfilter.setText("");
            removeTable();
            switch (efilter.getSelectedIndex()) {
                case 0:

                    for (RevisaoAnual ra : revisaoanual) {
                        tmodel.add(ra);
                    }
                    break;
                case 1:
                    for (RevisaoAnual ra : revisaon) {
                        tmodel.add(ra);
                    }
                    break;
                case 2:
                    for (RevisaoAnual ra : revisaoa) {
                        tmodel.add(ra);
                    }
                    break;
                case 3:
                    for (RevisaoAnual ra : revisaoe) {
                        tmodel.add(ra);
                    }
                    break;
                default:
                    break;
            }
        }
    }//GEN-LAST:event_efilterActionPerformed

    private void sfilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sfilterActionPerformed
        // TODO add your handling code here:
        if (sfilter.hasFocus()) {
            yfilter.setText("");
            afilter.setSelectedIndex(0);
            efilter.setSelectedIndex(0);
            removeTable();
            if (sfilter.getSelectedIndex() != 0) {
                String ccod = sfilter.getSelectedItem().toString();
                int iend = ccod.indexOf(" ");
                if (iend != -1) {
                    ccod = ccod.substring(0, iend);
                    int cod = Integer.parseInt(ccod);
                    for (RevisaoAnual ra : revisaoanual) {
                        if (ra.getServidor().getId() == cod) {
                            tmodel.add(ra);
                        }
                    }

                }
            } else {
                for (RevisaoAnual ra : revisaoanual) {
                    tmodel.add(ra);
                }
            }
        }

    }//GEN-LAST:event_sfilterActionPerformed

    private void afilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_afilterActionPerformed
        // TODO add your handling code here:
        if (afilter.hasFocus()) {
            yfilter.setText("");
            sfilter.setSelectedIndex(0);
            efilter.setSelectedIndex(0);
            removeTable();
            if (afilter.getSelectedIndex() != 0) {
                String ccod = afilter.getSelectedItem().toString();
                int iend = ccod.indexOf(" ");
                if (iend != -1) {
                    ccod = ccod.substring(0, iend);
                    int cod = Integer.parseInt(ccod);
                    for (RevisaoAnual ra : revisaoanual) {
                        if (ra.getAmbiente().getId() == cod) {
                            tmodel.add(ra);
                        }
                    }

                }
            } else {
                for (RevisaoAnual ra : revisaoanual) {
                    tmodel.add(ra);
                }
            }
        }
    }//GEN-LAST:event_afilterActionPerformed

    private void yfilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yfilterActionPerformed
        // TODO add your handling code here:
        if (yfilter.hasFocus()) {
            efilter.setSelectedIndex(0);
            afilter.setSelectedIndex(0);
            sfilter.setSelectedIndex(0);
            removeTable();
            if (!yfilter.getText().isEmpty()) {

                for (RevisaoAnual ra : revisaoanual) {
                    if (ra.getAno() == Integer.parseInt(yfilter.getText())) {
                        tmodel.add(ra);
                    }
                }

            } else {
                for (RevisaoAnual ra : revisaoanual) {
                    tmodel.add(ra);
                }
            }
        }
    }//GEN-LAST:event_yfilterActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        RevisaoAnual ra = null;
        if (jTable1.getSelectedRow() != -1) {
            ra = tmodel.get(jTable1.getSelectedRow());
        }
        if (ra == null) {
            JOptionPane.showMessageDialog(this, "Escolha uma revisão.");
        } else {
            int opc = JOptionPane.showConfirmDialog(this, "Deseja continuar? Todas as informações sobre "
                    + "essa revisão serão perdidas.", "Excluir Revisão?", JOptionPane.OK_OPTION);
            if (opc == JOptionPane.OK_OPTION) {
                List<ItensRevisao> deletaritens = IRDAO.filtrar(ra.getId());
                for (ItensRevisao ir : deletaritens) {
                    IRDAO.exclui(ir);
                }
                RADAO.exclui(ra);
                tmodel.remove(jTable1.getSelectedRow());
                atualizaListas();
            }
        }

    }//GEN-LAST:event_jButton3ActionPerformed


    private void jTable1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTable1FocusGained
        // TODO add your handling code here:
        if (jTable1.getSelectedRowCount() != 0) {
            jButton3.setEnabled(true);
            jButton1.setEnabled(true);
        }

    }//GEN-LAST:event_jTable1FocusGained

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        dispose();
        new JFrameMenuUsuario(logado).setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        dispose();
        new JFrameLogin().setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        dispose();
        new JFrameMovimentacoes(logado).setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        dispose();
        new JFrameCRUD(logado).setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        new JFrameCriaRevisao(itens).setVisible(true);
        atualizaListas();
        removeTable();
        for (RevisaoAnual ra : revisaoanual) {
            tmodel.add(ra);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        RevisaoAnual ra = null;
        if (jTable1.getSelectedRow() != -1) {
            ra = tmodel.get(jTable1.getSelectedRow());
        }
        if (ra == null) {
            JOptionPane.showMessageDialog(this, "Escolha uma revisão.");
        } else {

            List<ItensRevisao> itensrevisao = IRDAO.filtrar(ra.getId());
            new ExportRA(itensrevisao, ra);

        }

    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(JFrameRevisaoAnual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameRevisaoAnual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameRevisaoAnual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameRevisaoAnual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameRevisaoAnual(logado).setVisible(true);
            }
        });
    }

    public void removeTable() {
        int aux = tmodel.getRowCount();
        for (int i = 0; i < aux; i++) {
            tmodel.remove(0);
        }
    }

    public void atualizaListas() {
        revisaoanual = RADAO.listar();
        itens = IDAO.listar();
        revisaoa.clear();
        revisaoe.clear();
        revisaon.clear();
        for (RevisaoAnual ra : revisaoanual) {
            switch (ra.getEstado()) {
                case "EM ANDAMENTO":
                    revisaoa.add(ra);
                    break;

                case "ENCERRADA":
                    revisaoe.add(ra);
                    break;

                case "NÃO INICIADA":
                    revisaon.add(ra);
                    break;
            }
        }
        for (RevisaoAnual ra : revisaoanual) {
            int flag = 0;
            int flaga = 0;
            for (int i = 0; i < sfilter.getModel().getSize(); i++) {
                if (ra.getServidor().toString().equals(sfilter.getItemAt(i).toString())) {
                    flag++;
                }
            }
            if (flag == 0) {
                sfilter.addItem(ra.getServidor());
            }
            for (int i = 0; i < afilter.getModel().getSize(); i++) {
                if (ra.getAmbiente().toString().equals(afilter.getItemAt(i).toString())) {
                    flaga++;
                }
            }
            if (flaga == 0) {
                afilter.addItem(ra.getAmbiente());
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox afilter;
    private javax.swing.JComboBox<String> efilter;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox sfilter;
    private javax.swing.JTextField yfilter;
    // End of variables declaration//GEN-END:variables
}
