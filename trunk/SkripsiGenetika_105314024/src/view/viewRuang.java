/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * viewRuang.java
 *
 * Created on Mar 23, 2014, 10:28:59 PM
 */
package view;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import kelas.Ruang;
import kontrol.RuangKontrol;
import tabelModel.Ruang_TM;

/**
 *
 * @author Mich
 */
public class viewRuang extends javax.swing.JFrame {

    /**
     * Creates new form viewRuang
     */
    public viewRuang() {
        initComponents();
        setLocationRelativeTo(null);

        dialogRuangKelas.setVisible(false);
        dialogRuangKelas.setSize(600, 430);
        dialogRuangKelas.setLocationRelativeTo(null);
        dialogRuangKelas.setTitle("List Ruang Kelas");
    }
    
    private void updateTabelRuang() throws SQLException {
        List<Ruang> rtm = RuangKontrol.getKoneksi().tampilRuang();
        Ruang_TM model = new Ruang_TM(rtm);
        listRuangKelasTabel.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialogRuangKelas = new javax.swing.JDialog();
        jLabel29 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        listRuangKelasTabel = new javax.swing.JTable();
        listRuangKelasCloseButton = new javax.swing.JButton();
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
        idRuangText = new javax.swing.JTextField();
        namaRuangText = new javax.swing.JTextField();
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
        jLabel29.setText("Data Ruang Kelas");

        listRuangKelasTabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID Ruang", "Nama Ruang"
            }
        ));
        listRuangKelasTabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listRuangKelasTabelMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(listRuangKelasTabel);

        listRuangKelasCloseButton.setText("Tutup");
        listRuangKelasCloseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listRuangKelasCloseButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dialogRuangKelasLayout = new javax.swing.GroupLayout(dialogRuangKelas.getContentPane());
        dialogRuangKelas.getContentPane().setLayout(dialogRuangKelasLayout);
        dialogRuangKelasLayout.setHorizontalGroup(
            dialogRuangKelasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogRuangKelasLayout.createSequentialGroup()
                .addGroup(dialogRuangKelasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dialogRuangKelasLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(dialogRuangKelasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(listRuangKelasCloseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(dialogRuangKelasLayout.createSequentialGroup()
                        .addGap(212, 212, 212)
                        .addComponent(jLabel29)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        dialogRuangKelasLayout.setVerticalGroup(
            dialogRuangKelasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogRuangKelasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(listRuangKelasCloseButton)
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
        jLabel1.setText("ID Ruang");
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Nama Ruang");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, -1, -1));

        idRuangText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idRuangTextActionPerformed(evt);
            }
        });
        jPanel4.add(idRuangText, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 206, -1));
        jPanel4.add(namaRuangText, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, 206, -1));

        simpanButton.setText("Simpan");
        simpanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanButtonActionPerformed(evt);
            }
        });
        jPanel4.add(simpanButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, -1, -1));

        jLabel4.setFont(new java.awt.Font("NSimSun", 1, 18)); // NOI18N
        jLabel4.setText("DATA RUANG");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

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
        jPanel4.add(tabelButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 230, 70, -1));

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
        viewPenjadwalan asd = new viewPenjadwalan();
        asd.setVisible(true);
        this.setVisible(false);
}//GEN-LAST:event_penjadwalanButtonActionPerformed

    private void idRuangTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idRuangTextActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_idRuangTextActionPerformed

    private void listRuangKelasTabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listRuangKelasTabelMouseClicked
        int row1 = listRuangKelasTabel.getSelectedRow();
        String idRuang = listRuangKelasTabel.getValueAt(row1, 0).toString();
        String namaRuang = listRuangKelasTabel.getValueAt(row1, 1).toString();

        idRuangText.setText(idRuang);
        namaRuangText.setText(namaRuang);

        dialogRuangKelas.setVisible(false);
        idRuangText.setEditable(false);
}//GEN-LAST:event_listRuangKelasTabelMouseClicked

    private void listRuangKelasCloseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listRuangKelasCloseButtonActionPerformed
        dialogRuangKelas.setVisible(false);
}//GEN-LAST:event_listRuangKelasCloseButtonActionPerformed

    private void tabelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tabelButtonActionPerformed
        dialogRuangKelas.setVisible(true);
        try {
            updateTabelRuang();
        } catch (SQLException ex) {
            Logger.getLogger(viewRuang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tabelButtonActionPerformed

    private void simpanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanButtonActionPerformed
        Ruang ruang = new Ruang(idRuangText.getText().toUpperCase(), namaRuangText.getText().toUpperCase());
        try {
            RuangKontrol.getKoneksi().insertRuang(ruang);
            JOptionPane.showMessageDialog(rootPane, "Ruang "+ruang.getIdRuang()+" - "+ruang.getNamaRuang()+" berhasil ditambahkan");
        } catch (SQLException ex) {
            Logger.getLogger(viewRuang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_simpanButtonActionPerformed

    private void batalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalButtonActionPerformed
        idRuangText.setText("");
        namaRuangText.setText("");
        idRuangText.setEditable(true);
    }//GEN-LAST:event_batalButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            java.awt.EventQueue.invokeLater(new Runnable() {

                @Override
                public void run() {
                    new viewRuang().setVisible(true);
                }
            });
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(viewRuang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(viewRuang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(viewRuang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(viewRuang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton batalButton;
    private javax.swing.JDialog dialogRuangKelas;
    private javax.swing.JButton dosenButton;
    private javax.swing.JButton homeButton;
    private javax.swing.JTextField idRuangText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel29;
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
    private javax.swing.JButton listRuangKelasCloseButton;
    private javax.swing.JTable listRuangKelasTabel;
    private javax.swing.JButton matkulButton;
    private javax.swing.JTextField namaRuangText;
    private javax.swing.JButton penjadwalanButton;
    private javax.swing.JButton ruangButton;
    private javax.swing.JButton simpanButton;
    private javax.swing.JButton tabelButton;
    // End of variables declaration//GEN-END:variables
}
