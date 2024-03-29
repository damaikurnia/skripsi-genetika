/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Home.java
 *
 * Created on Mar 21, 2014, 11:53:56 AM
 */
package view;

import java.awt.Image;
import java.text.Normalizer.Form;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author ADIT
 */
public class Home extends javax.swing.JFrame {

    /** Creates new form Home */
    public Home() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
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
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SISTEM PENJADWALAN MATAKULIAH PGSD USD - HOME");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setForeground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        homeButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        homeButton.setText("HOME");
        homeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeButtonActionPerformed(evt);
            }
        });
        jPanel3.add(homeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 80, 40));

        matkulButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        matkulButton.setText("MATAKULIAH");
        matkulButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                matkulButtonActionPerformed(evt);
            }
        });
        jPanel3.add(matkulButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 130, 40));

        dosenButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        dosenButton.setText("DOSEN");
        dosenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dosenButtonActionPerformed(evt);
            }
        });
        jPanel3.add(dosenButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 100, 40));

        ruangButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ruangButton.setText("RUANG");
        ruangButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ruangButtonActionPerformed(evt);
            }
        });
        jPanel3.add(ruangButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, 100, 40));

        kelasButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        kelasButton.setText("BUAT KELAS KULIAH");
        kelasButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kelasButtonActionPerformed(evt);
            }
        });
        jPanel3.add(kelasButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, 200, 40));

        penjadwalanButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        penjadwalanButton.setText("PENJADWALAN");
        penjadwalanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                penjadwalanButtonActionPerformed(evt);
            }
        });
        jPanel3.add(penjadwalanButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 10, 150, 40));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 940, 60));

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Created By : Damai Kurnia Adhi - 105314024");
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 290, 280, 20));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setText("SELAMAT DATANG");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 350, 40));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("SELAMAT MENCOBA APLIKASI PENJADWALAN MATAKULIAH");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 500, 40));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("PROGRAM STUDI PENDIDIKAN GURU DAN SEKOLAH DASAR (PGSD)");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 570, 40));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("UNIVERSITAS SANATA DHARMA");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 280, 40));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("YOGYAKARTA");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 280, 40));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 940, 320));

        jPanel5.setBackground(new java.awt.Color(255, 102, 0));
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

        jPanel2.setBackground(new java.awt.Color(255, 102, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 530, 940, 80));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 610));

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

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        //untuk ganti icon
        Image oldIcon = getIconImage();
        ImageIcon newIcon = createImageIcon("/gambar/dosen.png");
        setIconImage(newIcon.getImage());
    }//GEN-LAST:event_formWindowActivated

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
           java.awt.EventQueue.invokeLater(new Runnable() {

                @Override
               public void run() {
                   new Home().setVisible(true);
               }
           });
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton dosenButton;
    private javax.swing.JButton homeButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JButton kelasButton;
    private javax.swing.JButton matkulButton;
    private javax.swing.JButton penjadwalanButton;
    private javax.swing.JButton ruangButton;
    // End of variables declaration//GEN-END:variables

    protected static ImageIcon createImageIcon(String path) {
        // Ganti IconFrame dengan nama kelas jFrame Anda
        java.net.URL imgURL = Form.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn'’t find file: " + path);
            return null;
        }
    }
}
