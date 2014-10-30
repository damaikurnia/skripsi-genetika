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

import java.awt.Color;
import java.io.File;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import jxl.Sheet;
import jxl.Workbook;
import kelas.Ruang;
import kontrol.RuangKontrol;
import tabelModel.Ruang_TM;
import tabelModel.renderWarnaWarni;

/**
 *
 * @author Adhi
 */
public class viewRuang extends javax.swing.JFrame {

    /**
     * Creates new form viewRuang
     */
    public viewRuang() {
        try {
            initComponents();
            setLocationRelativeTo(null);
            updateTabelRuang();
            
            uploadData.setFileSelectionMode(JFileChooser.FILES_ONLY);
            uploadData.setMultiSelectionEnabled(false);
            FileNameExtensionFilter JExcelFilter = new FileNameExtensionFilter("Excel File 2003 .xls", "xls");
            uploadData.setFileFilter(JExcelFilter);
            uploadData.setAcceptAllFileFilterUsed(false);
        } catch (SQLException ex) {
            Logger.getLogger(viewRuang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void updateTabelRuang() throws SQLException {
        List<Ruang> rtm = RuangKontrol.getKoneksi().tampilRuang();
        Ruang_TM model = new Ruang_TM(rtm);
        tabelRuang.setModel(model);
        
        tabelRuang.getColumnModel().getColumn(0).setMinWidth(70);
        tabelRuang.getColumnModel().getColumn(0).setMaxWidth(70);
        tabelRuang.getColumnModel().getColumn(1).setMinWidth(200);
        tabelRuang.getColumnModel().getColumn(1).setMaxWidth(200);
        
        tabelRuang.setDefaultRenderer(Object.class, new renderWarnaWarni(Color.gray, Color.white));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        uploadData = new javax.swing.JFileChooser();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelRuang = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        hapusButton = new javax.swing.JButton();
        ubahButton = new javax.swing.JButton();
        jenisComboBox = new javax.swing.JComboBox();
        button_upload = new javax.swing.JButton();
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

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14));
        jLabel1.setText("Kode");
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14));
        jLabel2.setText("Jenis Ruang");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, -1));

        idRuangText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idRuangTextActionPerformed(evt);
            }
        });
        jPanel4.add(idRuangText, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 206, -1));
        jPanel4.add(namaRuangText, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, 206, -1));

        simpanButton.setText("Simpan");
        simpanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanButtonActionPerformed(evt);
            }
        });
        jPanel4.add(simpanButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, -1, -1));

        jLabel4.setFont(new java.awt.Font("NSimSun", 1, 18));
        jLabel4.setText("TABEL RUANG");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 40, -1, -1));

        batalButton.setText("Batal");
        batalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batalButtonActionPerformed(evt);
            }
        });
        jPanel4.add(batalButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 230, 70, -1));

        tabelRuang.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelRuang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelRuangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelRuang);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 80, 400, 190));

        jLabel5.setFont(new java.awt.Font("NSimSun", 1, 18));
        jLabel5.setText("DATA RUANG");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14));
        jLabel3.setText("Nama Ruang");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, -1));

        hapusButton.setText("Hapus");
        hapusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusButtonActionPerformed(evt);
            }
        });
        jPanel4.add(hapusButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 230, 70, -1));

        ubahButton.setText("Ubah");
        ubahButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubahButtonActionPerformed(evt);
            }
        });
        jPanel4.add(ubahButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, 70, -1));

        jenisComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Teori", "Praktikum", "Teori Praktikum" }));
        jPanel4.add(jenisComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 160, -1, -1));

        button_upload.setText("UPLOAD");
        button_upload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_uploadActionPerformed(evt);
            }
        });
        jPanel4.add(button_upload, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 100, -1));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 940, 320));

        jPanel5.setBackground(new java.awt.Color(0, 51, 204));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Wide Latin", 1, 19));
        jLabel6.setText("Pendidikan Guru Sekolah Dasar");
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, -1, -1));

        jLabel7.setFont(new java.awt.Font("Bodoni MT", 0, 18));
        jLabel7.setText("Fakultas Keguruan dan Ilmu Pendidikan - Universitas Sanata Dharma");
        jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, -1, -1));

        jLabel8.setFont(new java.awt.Font("Microsoft Himalaya", 0, 24));
        jLabel8.setText("Telp (0274) 513301, 515352, Fax. (0274) 562383 ");
        jPanel5.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, -1, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/logo.gif"))); // NOI18N
        jPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, 150));

        jLabel10.setFont(new java.awt.Font("Microsoft Himalaya", 0, 24));
        jLabel10.setText("Mrican, Tromol Pos 29, Yogyakarta 55002.");
        jPanel5.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, -1, -1));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 940, 150));

        jPanel2.setBackground(new java.awt.Color(0, 51, 204));
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

    private void simpanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanButtonActionPerformed
        Ruang ruang = new Ruang(idRuangText.getText().toUpperCase(), namaRuangText.getText().toUpperCase(), jenisComboBox.getSelectedItem().toString().toUpperCase());
        try {
            RuangKontrol.getKoneksi().insertRuang(ruang);
            JOptionPane.showMessageDialog(rootPane, "Ruang "+ruang.getIdRuang()+" - "+ruang.getNamaRuang()+" berhasil ditambahkan");
            updateTabelRuang();
        } catch (SQLException ex) {
            Logger.getLogger(viewRuang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_simpanButtonActionPerformed

    private void batalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalButtonActionPerformed
        idRuangText.setText("");
        namaRuangText.setText("");
        jenisComboBox.setSelectedIndex(1);
        idRuangText.setEditable(true);
        simpanButton.setEnabled(true);
    }//GEN-LAST:event_batalButtonActionPerformed

    private void tabelRuangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelRuangMouseClicked
        simpanButton.setEnabled(false);
        int row1 = tabelRuang.getSelectedRow();
        String idRuang = tabelRuang.getValueAt(row1, 0).toString();
        String namaRuang = tabelRuang.getValueAt(row1, 1).toString();
//        String jenisRuang = tabelRuang.getValueAt(row1, 2).toString();

        idRuangText.setText(idRuang);
        namaRuangText.setText(namaRuang);
//        jenisComboBox.setSelectedItem(jenisRuang);
        idRuangText.setEditable(false);
    }//GEN-LAST:event_tabelRuangMouseClicked

    private void hapusButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusButtonActionPerformed
        Ruang ruang = new Ruang(idRuangText.getText().toUpperCase(), namaRuangText.getText().toUpperCase(), jenisComboBox.getSelectedItem().toString().toUpperCase());
        try {
            RuangKontrol.getKoneksi().deleteRuang(ruang);
            JOptionPane.showMessageDialog(rootPane, "Ruang "+ruang.getIdRuang()+" - "+ruang.getNamaRuang()+" berhasil dihapus");
            updateTabelRuang();
        } catch (SQLException ex) {
            Logger.getLogger(viewRuang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_hapusButtonActionPerformed

    private void ubahButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubahButtonActionPerformed
        Ruang ruang = new Ruang(idRuangText.getText().toUpperCase(), namaRuangText.getText().toUpperCase(), jenisComboBox.getSelectedItem().toString().toUpperCase());
        try {
            RuangKontrol.getKoneksi().updateRuang(ruang);
            JOptionPane.showMessageDialog(rootPane, "Ruang "+ruang.getIdRuang()+" - "+ruang.getNamaRuang()+" berhasil dirubah");
            updateTabelRuang();
        } catch (SQLException ex) {
            Logger.getLogger(viewRuang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ubahButtonActionPerformed

    private void button_uploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_uploadActionPerformed
        int jes = uploadData.showOpenDialog(this);

        if (jes == uploadData.APPROVE_OPTION) {
//            File f = uploadData.getSelectedFile();
//           jLabel1.setText(f.getPath());
//           JOptionPane.showMessageDialog(null, f.getPath());

            File excelFile = uploadData.getSelectedFile();

            // buat model untuk file excel
            if (excelFile.exists()) {
                try {
                    Workbook workbook = Workbook.getWorkbook(excelFile);
                    Sheet sheet = workbook.getSheets()[0];

                    TableModel model = new DefaultTableModel(sheet.getRows(), sheet.getColumns());
                    for (int row = 1; row < sheet.getRows(); row++) {
                        String content = "";
                        for (int column = 0; column < sheet.getColumns(); column++) {
                            content = content + sheet.getCell(column, row).getContents() + "-";
                        }
                        Ruang rng = new Ruang(content.split("-")[0], content.split("-")[1], content.split("-")[2]);
                        boolean result = RuangKontrol.getKoneksi().cekRuang(rng.getIdRuang());
                        if (result == true) {
                            RuangKontrol.getKoneksi().updateRuang(rng);
                        } else {
                            RuangKontrol.getKoneksi().insertRuang(rng);
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Data Berhasil Dimasukkan Ke dalam Database");
                    updateTabelRuang();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error: Format Dokumen tidak sesuai dengan database Dosen");
                }

            } else {
                JOptionPane.showMessageDialog(null, "File does not exist");
            }
        }
    }//GEN-LAST:event_button_uploadActionPerformed

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
    private javax.swing.JButton button_upload;
    private javax.swing.JButton dosenButton;
    private javax.swing.JButton hapusButton;
    private javax.swing.JButton homeButton;
    private javax.swing.JTextField idRuangText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JComboBox jenisComboBox;
    private javax.swing.JButton kelasButton;
    private javax.swing.JButton matkulButton;
    private javax.swing.JTextField namaRuangText;
    private javax.swing.JButton penjadwalanButton;
    private javax.swing.JButton ruangButton;
    private javax.swing.JButton simpanButton;
    private javax.swing.JTable tabelRuang;
    private javax.swing.JButton ubahButton;
    private javax.swing.JFileChooser uploadData;
    // End of variables declaration//GEN-END:variables
}
