/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * viewMataKuliah.java
 *
 * Created on Mar 23, 2014, 10:11:04 PM
 */
package view;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author ADIT
 */
public class viewMataKuliah extends javax.swing.JFrame {

    /** Creates new form viewMataKuliah */
    public viewMataKuliah() {
        initComponents();
         setLocationRelativeTo(null);
         
        dialogMataKuliah.setVisible(false);
        dialogMataKuliah.setSize(600, 430);
        dialogMataKuliah.setLocationRelativeTo(null);
        dialogMataKuliah.setTitle("List Mata Kuliah");
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialogMataKuliah = new javax.swing.JDialog();
        jLabel29 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        listMataKuliahTabel = new javax.swing.JTable();
        listMataKuliahCloseButton = new javax.swing.JButton();
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
        idMataKuliahText = new javax.swing.JTextField();
        namaMataKuliahText = new javax.swing.JTextField();
        simpanButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        sksText = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        semesterText = new javax.swing.JTextField();
        jamPelajaranText = new javax.swing.JTextField();
        batalButton = new javax.swing.JButton();
        tabelButton = new javax.swing.JButton();
        jenisText = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();

        jLabel29.setFont(new java.awt.Font("Papyrus", 1, 18)); // NOI18N
        jLabel29.setText("Data Mata Kuliah");

        listMataKuliahTabel.setModel(new javax.swing.table.DefaultTableModel(
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
        listMataKuliahTabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listMataKuliahTabelMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(listMataKuliahTabel);

        listMataKuliahCloseButton.setText("Tutup");
        listMataKuliahCloseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listMataKuliahCloseButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dialogMataKuliahLayout = new javax.swing.GroupLayout(dialogMataKuliah.getContentPane());
        dialogMataKuliah.getContentPane().setLayout(dialogMataKuliahLayout);
        dialogMataKuliahLayout.setHorizontalGroup(
            dialogMataKuliahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogMataKuliahLayout.createSequentialGroup()
                .addGroup(dialogMataKuliahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dialogMataKuliahLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(dialogMataKuliahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(listMataKuliahCloseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(dialogMataKuliahLayout.createSequentialGroup()
                        .addGap(212, 212, 212)
                        .addComponent(jLabel29)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        dialogMataKuliahLayout.setVerticalGroup(
            dialogMataKuliahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogMataKuliahLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(listMataKuliahCloseButton)
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
        jLabel1.setText("ID Mata Kuliah");
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Nama Mata Kuliah");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Sks");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, -1, -1));

        idMataKuliahText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idMataKuliahTextActionPerformed(evt);
            }
        });
        jPanel4.add(idMataKuliahText, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 206, -1));
        jPanel4.add(namaMataKuliahText, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, 206, -1));

        simpanButton.setText("Simpan");
        jPanel4.add(simpanButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, -1, -1));

        jLabel4.setFont(new java.awt.Font("NSimSun", 1, 18)); // NOI18N
        jLabel4.setText("DATA MATA KULIAH");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));
        jPanel4.add(sksText, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 160, 70, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("Semester");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, -1, -1));

        jLabel11.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel11.setText("Jam Pelajaran");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 80, -1, -1));

        jLabel12.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel12.setText("Jenis");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 120, -1, -1));

        semesterText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semesterTextActionPerformed(evt);
            }
        });
        jPanel4.add(semesterText, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 200, 70, -1));

        jamPelajaranText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jamPelajaranTextActionPerformed(evt);
            }
        });
        jPanel4.add(jamPelajaranText, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 80, 100, -1));

        batalButton.setText("Batal");
        jPanel4.add(batalButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, 70, -1));

        tabelButton.setText("Tabel");
        tabelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tabelButtonActionPerformed(evt);
            }
        });
        jPanel4.add(tabelButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 260, -1, -1));

        jenisText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jenisTextActionPerformed(evt);
            }
        });
        jPanel4.add(jenisText, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 120, 100, -1));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 940, 320));

        jPanel5.setBackground(new java.awt.Color(153, 51, 0));
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

        jPanel2.setBackground(new java.awt.Color(153, 51, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 530, 940, 80));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 940, Short.MAX_VALUE)
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

    private void idMataKuliahTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idMataKuliahTextActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_idMataKuliahTextActionPerformed

    private void semesterTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semesterTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_semesterTextActionPerformed

    private void jamPelajaranTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jamPelajaranTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jamPelajaranTextActionPerformed

    private void listMataKuliahTabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listMataKuliahTabelMouseClicked
        int row1 = listMataKuliahTabel.getSelectedRow();
        String idMataKuliah = listMataKuliahTabel.getValueAt(row1, 1).toString();
        String namaMatakuliah = listMataKuliahTabel.getValueAt(row1, 2).toString();
        String sks = listMataKuliahTabel.getValueAt(row1, 3).toString();
        String semester = listMataKuliahTabel.getValueAt(row1, 4).toString();
        String jp = listMataKuliahTabel.getValueAt(row1, 5).toString();
        String jenis = listMataKuliahTabel.getValueAt(row1, 6).toString();
        
        idMataKuliahText.setText(idMataKuliah);
        namaMataKuliahText.setText(namaMatakuliah);
        sksText.setText(sks);
        semesterText.setText(semester);
        jamPelajaranText.setText(jp);
        jenisText.setText(jenis);
        
        dialogMataKuliah.setVisible(false);
}//GEN-LAST:event_listMataKuliahTabelMouseClicked

    private void listMataKuliahCloseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listMataKuliahCloseButtonActionPerformed
        dialogMataKuliah.setVisible(false);
}//GEN-LAST:event_listMataKuliahCloseButtonActionPerformed

    private void tabelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tabelButtonActionPerformed
        dialogMataKuliah.setVisible(true);
    }//GEN-LAST:event_tabelButtonActionPerformed

    private void jenisTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jenisTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jenisTextActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            java.awt.EventQueue.invokeLater(new Runnable() {

                @Override
                public void run() {
                    new viewMataKuliah().setVisible(true);
                }
            });
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(viewMataKuliah.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(viewMataKuliah.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(viewMataKuliah.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(viewMataKuliah.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton batalButton;
    private javax.swing.JDialog dialogMataKuliah;
    private javax.swing.JButton dosenButton;
    private javax.swing.JButton homeButton;
    private javax.swing.JTextField idMataKuliahText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel29;
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
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTextField jamPelajaranText;
    private javax.swing.JTextField jenisText;
    private javax.swing.JButton kelasButton;
    private javax.swing.JButton listMataKuliahCloseButton;
    private javax.swing.JTable listMataKuliahTabel;
    private javax.swing.JButton matkulButton;
    private javax.swing.JTextField namaMataKuliahText;
    private javax.swing.JButton penjadwalanButton;
    private javax.swing.JButton ruangButton;
    private javax.swing.JTextField semesterText;
    private javax.swing.JButton simpanButton;
    private javax.swing.JTextField sksText;
    private javax.swing.JButton tabelButton;
    // End of variables declaration//GEN-END:variables
}
