/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * viewDosen.java
 *
 * Created on Mar 21, 2014, 3:09:14 PM
 */
package view;

import kelas.Dosen;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import kelas.Ruang;
import kontrol.DosenKontrol;
import kontrol.RuangKontrol;
import tabelModel.Dosen_TM;
import tabelModel.Ruang_TM;

/**
 *
 * @author Mich
 */
public class viewDosen extends javax.swing.JFrame {

    /** Creates new form viewDosen */
    public viewDosen() {
        initComponents();
        setLocationRelativeTo(null);

        dialogDosen.setVisible(false);
        dialogDosen.setSize(600, 430);
        dialogDosen.setLocationRelativeTo(null);
        dialogDosen.setTitle("List Dosen");
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialogDosen = new javax.swing.JDialog();
        jLabel29 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        listDosenTabel = new javax.swing.JTable();
        listDosenCloseButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        homeButton = new javax.swing.JButton();
        matkulButton = new javax.swing.JButton();
        dosenButton = new javax.swing.JButton();
        ruangButton = new javax.swing.JButton();
        kelasButton = new javax.swing.JButton();
        penjadwalanButton = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        idDosenText = new javax.swing.JTextField();
        namaDosenText = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox();
        simpanButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        batalButton = new javax.swing.JButton();
        tabelButton = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();

        jLabel29.setFont(new java.awt.Font("Papyrus", 1, 18)); // NOI18N
        jLabel29.setText("Data Dosen");

        listDosenTabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        listDosenTabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listDosenTabelMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(listDosenTabel);

        listDosenCloseButton.setText("Tutup");
        listDosenCloseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listDosenCloseButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dialogDosenLayout = new javax.swing.GroupLayout(dialogDosen.getContentPane());
        dialogDosen.getContentPane().setLayout(dialogDosenLayout);
        dialogDosenLayout.setHorizontalGroup(
            dialogDosenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogDosenLayout.createSequentialGroup()
                .addGroup(dialogDosenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dialogDosenLayout.createSequentialGroup()
                        .addGap(223, 223, 223)
                        .addComponent(jLabel29))
                    .addGroup(dialogDosenLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(dialogDosenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(listDosenCloseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        dialogDosenLayout.setVerticalGroup(
            dialogDosenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogDosenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(listDosenCloseButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setForeground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        homeButton.setText("Home");
        homeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeButtonActionPerformed(evt);
            }
        });
        jPanel3.add(homeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 80, 40));

        matkulButton.setText("Data Mata Kuliah");
        matkulButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                matkulButtonActionPerformed(evt);
            }
        });
        jPanel3.add(matkulButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 120, 40));

        dosenButton.setText("Data Dosen");
        dosenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dosenButtonActionPerformed(evt);
            }
        });
        jPanel3.add(dosenButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, 100, 40));

        ruangButton.setText("Data Ruang");
        ruangButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ruangButtonActionPerformed(evt);
            }
        });
        jPanel3.add(ruangButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, 100, 40));

        kelasButton.setText("Data Kelas");
        kelasButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kelasButtonActionPerformed(evt);
            }
        });
        jPanel3.add(kelasButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 10, 100, 40));

        penjadwalanButton.setText("Penjadwalan");
        penjadwalanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                penjadwalanButtonActionPerformed(evt);
            }
        });
        jPanel3.add(penjadwalanButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 10, 110, 40));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 940, 60));

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("ID Dosen");
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Nama Dosen");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Status");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, -1, -1));

        idDosenText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idDosenTextActionPerformed(evt);
            }
        });
        jPanel4.add(idDosenText, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 206, -1));
        jPanel4.add(namaDosenText, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, 206, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tetap", "Tidak Tetap" }));
        jPanel4.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 160, 98, -1));

        simpanButton.setText("Simpan");
        simpanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanButtonActionPerformed(evt);
            }
        });
        jPanel4.add(simpanButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, -1, -1));

        jLabel4.setFont(new java.awt.Font("NSimSun", 1, 18)); // NOI18N
        jLabel4.setText("DATA DOSEN");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 42, -1, -1));

        batalButton.setText("Batal");
        batalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batalButtonActionPerformed(evt);
            }
        });
        jPanel4.add(batalButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, 70, -1));

        tabelButton.setText("Tabel");
        tabelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tabelButtonActionPerformed(evt);
            }
        });
        jPanel4.add(tabelButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 230, 60, -1));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 940, 320));

        jPanel5.setBackground(new java.awt.Color(153, 51, 0));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Wide Latin", 1, 19)); // NOI18N
        jLabel6.setText("Pendidikan Guru Sekolah Dasar");
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, -1, -1));

        jLabel7.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        jLabel7.setText("Fakultas Keguruan dan Ilmu Pendidikan - Universitas Sanata Dharma");
        jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, -1, -1));

        jLabel8.setFont(new java.awt.Font("Microsoft Himalaya", 0, 24)); // NOI18N
        jLabel8.setText("Telp (0274) 513301, 515352, Fax. (0274) 562383 ");
        jPanel5.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, -1, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/logo.gif"))); // NOI18N
        jPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, 150));

        jLabel10.setFont(new java.awt.Font("Microsoft Himalaya", 0, 24)); // NOI18N
        jLabel10.setText("Mrican, Tromol Pos 29, Yogyakarta 55002.");
        jPanel5.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, -1, -1));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 940, 150));

        jPanel2.setBackground(new java.awt.Color(153, 51, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 530, 940, 80));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 940, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 610, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeButtonActionPerformed
        Home asd = new Home();
        asd.setVisible(true);
        this.setVisible(false);
}//GEN-LAST:event_homeButtonActionPerformed

    private void matkulButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_matkulButtonActionPerformed
        viewMataKuliah asd = new viewMataKuliah();
        asd.setVisible(true);
        this.setVisible(false);
}//GEN-LAST:event_matkulButtonActionPerformed

    private void dosenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dosenButtonActionPerformed
        viewDosen asd = new viewDosen();
        asd.setVisible(true);
        this.setVisible(false);
}//GEN-LAST:event_dosenButtonActionPerformed

    private void ruangButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ruangButtonActionPerformed
        viewRuang asd = new viewRuang();
        asd.setVisible(true);
        this.setVisible(false);
}//GEN-LAST:event_ruangButtonActionPerformed

    private void kelasButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kelasButtonActionPerformed
        viewKelas asd = new viewKelas();
        asd.setVisible(true);
        this.setVisible(false);
}//GEN-LAST:event_kelasButtonActionPerformed

    private void penjadwalanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_penjadwalanButtonActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_penjadwalanButtonActionPerformed

    private void idDosenTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idDosenTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idDosenTextActionPerformed

    private void listDosenTabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listDosenTabelMouseClicked
        int row1 = listDosenTabel.getSelectedRow();
        String idDosen = listDosenTabel.getValueAt(row1, 0).toString();
        String namaDosen = listDosenTabel.getValueAt(row1, 1).toString();
        idDosenText.setText(idDosen);
        namaDosenText.setText(namaDosen);

        dialogDosen.setVisible(false);
}//GEN-LAST:event_listDosenTabelMouseClicked

    private void listDosenCloseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listDosenCloseButtonActionPerformed
        dialogDosen.setVisible(false);
}//GEN-LAST:event_listDosenCloseButtonActionPerformed

    private void tabelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tabelButtonActionPerformed
        try {
            updateTabelDosen();
        } catch (SQLException ex) {
            Logger.getLogger(viewDosen.class.getName()).log(Level.SEVERE, null, ex);
        }
        dialogDosen.setVisible(true);
    }//GEN-LAST:event_tabelButtonActionPerformed

    private void simpanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanButtonActionPerformed
        String id = idDosenText.getText();
        String nama = namaDosenText.getText();
        String Combo = (String) jComboBox1.getSelectedItem();

        Dosen temp = new Dosen(id, nama, Combo);

        String buttonsimpan = simpanButton.getText();
        try {
            if (buttonsimpan.equals("Update")) {
                DosenKontrol dosenk = DosenKontrol.getKoneksi();
                dosenk.updateDosen(temp);
                JOptionPane.showMessageDialog(null, "Berhasil di update");
                bersihkan();
                idDosenText.requestFocus();
            } else {
                DosenKontrol dosenk = DosenKontrol.getKoneksi();
                dosenk.insertDosen(temp);
                JOptionPane.showMessageDialog(null, "Berhasil di simpan");
                bersihkan();
                idDosenText.requestFocus();
            }
        }
         catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal di simpan");
            bersihkan();
        }
    }//GEN-LAST:event_simpanButtonActionPerformed

    private void batalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalButtonActionPerformed
        bersihkan();
    }//GEN-LAST:event_batalButtonActionPerformed

    private void bersihkan(){
        idDosenText.setText("");
        namaDosenText.setText("");
    }
    
    private void updateTabelDosen() throws SQLException {
        List<Dosen> dtm = DosenKontrol.getKoneksi().tampilDosen();
        Dosen_TM model = new Dosen_TM(dtm);
        listDosenTabel.setModel(model);
    }
    
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            java.awt.EventQueue.invokeLater(new Runnable() {

                @Override
                public void run() {
                    new viewDosen().setVisible(true);
                }
            });
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(viewDosen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(viewDosen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(viewDosen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(viewDosen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton batalButton;
    private javax.swing.JDialog dialogDosen;
    private javax.swing.JButton dosenButton;
    private javax.swing.JButton homeButton;
    private javax.swing.JTextField idDosenText;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JButton kelasButton;
    private javax.swing.JButton listDosenCloseButton;
    private javax.swing.JTable listDosenTabel;
    private javax.swing.JButton matkulButton;
    private javax.swing.JTextField namaDosenText;
    private javax.swing.JButton penjadwalanButton;
    private javax.swing.JButton ruangButton;
    private javax.swing.JButton simpanButton;
    private javax.swing.JButton tabelButton;
    // End of variables declaration//GEN-END:variables
}
