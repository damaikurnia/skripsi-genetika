/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * viewKelas.java
 *
 * Created on Mar 23, 2014, 10:41:48 PM
 */
package view;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import kelas.Dosen;
import kelas.KelasKuliah;
import kelas.MataKuliah;
import kontrol.DosenKontrol;
import kontrol.KelasMatkulKontrol;
import kontrol.MataKuliahKontrol;
import tabelModel.KelasMatkul_TM;
import tabelModel.MataKuliah_TM;

/**
 *
 * @author ADIT
 */
public class viewKelas extends javax.swing.JFrame {

    /**
     * Creates new form viewKelas
     */
    public viewKelas() {
        try {
            initComponents();
            setLocationRelativeTo(null);
            updateTabelKelas();

            List<MataKuliah> matkul = MataKuliahKontrol.getKoneksi().tampilMataKuliah();
            for (MataKuliah k : matkul) {
                MatakuliahComboBox.addItem(k.getIdMK() + " - " + k.getNamaMK());
            }

            List<Dosen> dosen = DosenKontrol.getKoneksi().tampilDosen();
            for (Dosen k : dosen) {
                DosenComboBox.addItem(k.getIdDosen() + " - " + k.getNamaDosen());
            }
        } catch (SQLException ex) {
            Logger.getLogger(viewKelas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void updateTabelKelas() throws SQLException {
        List<KelasKuliah> mktm = KelasMatkulKontrol.getKoneksi().tampilKelasMataKuliah();
        KelasMatkul_TM model = new KelasMatkul_TM(mktm);
        tabelKelasMatakuliah.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        idKelasText = new javax.swing.JTextField();
        simpanButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        batalButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        KelasText = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelKelasMatakuliah = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        DosenComboBox = new javax.swing.JComboBox();
        KelasComboBox = new javax.swing.JComboBox();
        MatakuliahComboBox = new javax.swing.JComboBox();
        batalButton1 = new javax.swing.JButton();
        batalButton2 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();

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
        jLabel1.setText("No Kelas");
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Matakuliah");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Dosen Pengampu");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        idKelasText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idKelasTextActionPerformed(evt);
            }
        });
        jPanel4.add(idKelasText, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 60, -1));

        simpanButton.setText("Simpan");
        simpanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanButtonActionPerformed(evt);
            }
        });
        jPanel4.add(simpanButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, -1, -1));

        jLabel4.setFont(new java.awt.Font("NSimSun", 1, 18)); // NOI18N
        jLabel4.setText("TABEL MATAKULIAH");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 30, -1, -1));

        batalButton.setText("Hapus");
        batalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batalButtonActionPerformed(evt);
            }
        });
        jPanel4.add(batalButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 260, 70, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("Kelas");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        KelasText.setEditable(false);
        KelasText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KelasTextActionPerformed(evt);
            }
        });
        jPanel4.add(KelasText, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 170, 80, -1));

        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseClicked(evt);
            }
        });

        tabelKelasMatakuliah.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelKelasMatakuliah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelKelasMatakuliahMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelKelasMatakuliah);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 70, 420, 210));

        jLabel12.setFont(new java.awt.Font("NSimSun", 1, 18)); // NOI18N
        jLabel12.setText("DATA KELAS MATAKULIAH");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, -1, -1));

        DosenComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-" }));
        jPanel4.add(DosenComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 210, -1));

        KelasComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "A", "B", "C", "D", "E", "F", "Lainya" }));
        KelasComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KelasComboBoxActionPerformed(evt);
            }
        });
        jPanel4.add(KelasComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, -1, -1));

        MatakuliahComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-" }));
        jPanel4.add(MatakuliahComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 210, -1));

        batalButton1.setText("Batal");
        jPanel4.add(batalButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 260, 70, -1));

        batalButton2.setText("Ubah");
        batalButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batalButton2ActionPerformed(evt);
            }
        });
        jPanel4.add(batalButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, 70, -1));

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

    private void idKelasTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idKelasTextActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_idKelasTextActionPerformed

    private void KelasTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KelasTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_KelasTextActionPerformed

    private void KelasComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KelasComboBoxActionPerformed
        if (KelasComboBox.getSelectedItem().toString().equals("Lainya")) {
            KelasText.setEditable(true);
        } else {
            KelasText.setEditable(false);
        }
    }//GEN-LAST:event_KelasComboBoxActionPerformed

    private void batalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_batalButtonActionPerformed

    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked

    }//GEN-LAST:event_jScrollPane1MouseClicked

    private void tabelKelasMatakuliahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelKelasMatakuliahMouseClicked
        int row1 = tabelKelasMatakuliah.getSelectedRow();
        String noKelas = tabelKelasMatakuliah.getValueAt(row1, 0).toString();
        String namaMatakuliah = tabelKelasMatakuliah.getValueAt(row1, 1).toString();
        String namaDosen = tabelKelasMatakuliah.getValueAt(row1, 2).toString();
        String kelas = tabelKelasMatakuliah.getValueAt(row1, 3).toString();
        try {
            MataKuliah mk = KelasMatkulKontrol.getKoneksi().tampilMatakuliah(namaMatakuliah);
            Dosen dsn = KelasMatkulKontrol.getKoneksi().tampilDosen(namaDosen);
            idKelasText.setText(noKelas);
            MatakuliahComboBox.setSelectedItem(mk.getIdMK() + " - " + mk.getNamaMK());
            DosenComboBox.setSelectedItem(dsn.getIdDosen() + " - " + dsn.getNamaDosen());
            KelasComboBox.setSelectedItem(kelas); //BELUM SELESAI UNTUK YG "LAINNYA"
            idKelasText.setEditable(false);
        } catch (SQLException ex) {
            Logger.getLogger(viewKelas.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_tabelKelasMatakuliahMouseClicked

    private void simpanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanButtonActionPerformed
        int nomor = Integer.parseInt(idKelasText.getText());
        String idMatkul = MatakuliahComboBox.getSelectedItem().toString().substring(0, 8);
        String idDosen = DosenComboBox.getSelectedItem().toString().substring(0, 5);
        String kelas = KelasComboBox.getSelectedItem().toString();
        KelasKuliah kk = new KelasKuliah(nomor, new MataKuliah(idMatkul), kelas, new Dosen(idDosen));

        try {
            KelasMatkulKontrol.getKoneksi().insertKelasMataKuliah(kk);
            JOptionPane.showMessageDialog(rootPane, "Matakuliah berhasil ditambahkan");
            updateTabelKelas();
        } catch (SQLException ex) {
            Logger.getLogger(viewRuang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_simpanButtonActionPerformed

    private void batalButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_batalButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            java.awt.EventQueue.invokeLater(new Runnable() {

                @Override
                public void run() {
                    new viewKelas().setVisible(true);
                }
            });
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(viewKelas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(viewKelas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(viewKelas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(viewKelas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox DosenComboBox;
    private javax.swing.JComboBox KelasComboBox;
    private javax.swing.JTextField KelasText;
    private javax.swing.JComboBox MatakuliahComboBox;
    private javax.swing.JButton batalButton;
    private javax.swing.JButton batalButton1;
    private javax.swing.JButton batalButton2;
    private javax.swing.JButton dosenButton;
    private javax.swing.JButton homeButton;
    private javax.swing.JTextField idKelasText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton kelasButton;
    private javax.swing.JButton matkulButton;
    private javax.swing.JButton penjadwalanButton;
    private javax.swing.JButton ruangButton;
    private javax.swing.JButton simpanButton;
    private javax.swing.JTable tabelKelasMatakuliah;
    // End of variables declaration//GEN-END:variables
}
