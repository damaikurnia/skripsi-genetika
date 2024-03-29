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

import java.awt.Color;
import java.awt.Image;
import java.sql.SQLException;
import java.text.Normalizer.Form;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import kelas.Dosen;
import kelas.KelasKuliah;
import kelas.MataKuliah;
import kontrol.DosenKontrol;
import kontrol.KelasMatkulKontrol;
import tabelModel.Dosen_TM;
import tabelModel.KelasMatkul_TM;
import tabelModel.renderWarnaWarni;

/**
 *
 * @author Adhi
 */
public class viewKelas extends javax.swing.JFrame {

    /**
     * Creates new form viewKelas
     */
    public viewKelas() {
        try {
            initComponents();
            setLocationRelativeTo(null);
            String[] Semester = {"1", "3", "5", "7"};
            comboSemester.removeAllItems();
            for (String k : Semester) {
                comboSemester.addItem(k);
            }

            List<KelasKuliah> kk = KelasMatkulKontrol.getKoneksi().tampilKelasMataKuliah();
            jLabel13.setText("TOTAL MATAKULIAH : " + kk.size());
        } catch (SQLException ex) {
            Logger.getLogger(viewKelas.class.getName()).log(Level.SEVERE, null, ex);
        }

        cariDosen.setVisible(false);
        cariDosen.setSize(515, 400);
        cariDosen.setLocationRelativeTo(null);
        tambahDosen.setVisible(false);
        tambahDosen.setSize(640, 400);
        tambahDosen.setLocationRelativeTo(null);
        buatKelas.setVisible(false);
        buatKelas.setSize(700, 430);
        buatKelas.setLocationRelativeTo(null);
        tampilSesuatu.setVisible(false);
        tampilSesuatu.setSize(945, 460);
        tampilSesuatu.setLocationRelativeTo(null);
        smstr.setVisible(false);
    }

    private void updateTabelKelas(String key) throws SQLException {
        List<KelasKuliah> mktm = KelasMatkulKontrol.getKoneksi().cariKelasKuliah(key);
        KelasMatkul_TM model = new KelasMatkul_TM(mktm);
        Tabelnya_KelasMatkul.setModel(model);

        Tabelnya_KelasMatkul.getColumnModel().getColumn(0).setMaxWidth(0);
        Tabelnya_KelasMatkul.getColumnModel().getColumn(1).setMaxWidth(70);
        Tabelnya_KelasMatkul.getColumnModel().getColumn(2).setMinWidth(200);
        Tabelnya_KelasMatkul.getColumnModel().getColumn(3).setMaxWidth(65);
        Tabelnya_KelasMatkul.getColumnModel().getColumn(4).setMaxWidth(65);
        Tabelnya_KelasMatkul.getColumnModel().getColumn(5).setMaxWidth(65);
        Tabelnya_KelasMatkul.getColumnModel().getColumn(6).setMaxWidth(65);

        Tabelnya_KelasMatkul.setDefaultRenderer(Object.class, new renderWarnaWarni(Color.lightGray, Color.white));
    }

    private void updateTabelKelasSemester(int Semester) throws SQLException {
        List<KelasKuliah> mktm = KelasMatkulKontrol.getKoneksi().tampilKelasMataKuliahPerSemester(Semester);
        KelasMatkul_TM model = new KelasMatkul_TM(mktm);
        tabelKelasMatakuliah.setModel(model);
        sisaMatkul.setText(Integer.toString(mktm.size()));

        tabelKelasMatakuliah.getColumnModel().getColumn(0).setMaxWidth(0);
        tabelKelasMatakuliah.getColumnModel().getColumn(1).setMaxWidth(70);
        tabelKelasMatakuliah.getColumnModel().getColumn(2).setMinWidth(200);
        tabelKelasMatakuliah.getColumnModel().getColumn(3).setMaxWidth(65);
        tabelKelasMatakuliah.getColumnModel().getColumn(4).setMaxWidth(65);
        tabelKelasMatakuliah.getColumnModel().getColumn(5).setMaxWidth(65);
        tabelKelasMatakuliah.getColumnModel().getColumn(6).setMaxWidth(65);

        tabelKelasMatakuliah.setDefaultRenderer(Object.class, new renderWarnaWarni(Color.lightGray, Color.white));
    }

    private void updateTabelDosen() throws SQLException {
        List<Dosen> dtm = DosenKontrol.getKoneksi().tampilDosen();
        Dosen_TM model = new Dosen_TM(dtm);
        Tabelnya.setModel(model);
        Tabelnya.getColumnModel().getColumn(0).setMinWidth(70);
        Tabelnya.getColumnModel().getColumn(0).setMaxWidth(70);
        Tabelnya.getColumnModel().getColumn(1).setMinWidth(220);
        Tabelnya.getColumnModel().getColumn(1).setMaxWidth(220);
        Tabelnya.setDefaultRenderer(Object.class, new renderWarnaWarni(Color.lightGray, Color.white));
    }

    private void cariDosen(String key) throws SQLException {
        List<Dosen> dtm = DosenKontrol.getKoneksi().cariDosen(key);
        Dosen_TM model = new Dosen_TM(dtm);
        Tabelnya.setModel(model);
        Tabelnya.getColumnModel().getColumn(0).setMinWidth(70);
        Tabelnya.getColumnModel().getColumn(0).setMaxWidth(70);
        Tabelnya.getColumnModel().getColumn(1).setMinWidth(220);
        Tabelnya.getColumnModel().getColumn(1).setMaxWidth(220);
        Tabelnya.setDefaultRenderer(Object.class, new renderWarnaWarni(Color.lightGray, Color.white));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cariDosen = new javax.swing.JDialog();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        Labelnya = new javax.swing.JLabel();
        isiannya = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tabelnya = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        tambahDosen = new javax.swing.JDialog();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        Labelnya1 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        dsn_button = new javax.swing.JButton();
        isianSKS = new javax.swing.JLabel();
        HapusButton = new javax.swing.JButton();
        lbl_kelas = new javax.swing.JLabel();
        lbl_matkul = new javax.swing.JLabel();
        RubahButton = new javax.swing.JButton();
        lbl_idKelas = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        smstr = new javax.swing.JLabel();
        isianDosen = new javax.swing.JLabel();
        buatKelas = new javax.swing.JDialog();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        radioGanjil = new javax.swing.JRadioButton();
        radioGenap = new javax.swing.JRadioButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        button_buatKelas = new javax.swing.JButton();
        sem8 = new javax.swing.JComboBox();
        sem1 = new javax.swing.JComboBox();
        sem3 = new javax.swing.JComboBox();
        sem5 = new javax.swing.JComboBox();
        sem7 = new javax.swing.JComboBox();
        sem2 = new javax.swing.JComboBox();
        sem4 = new javax.swing.JComboBox();
        sem6 = new javax.swing.JComboBox();
        radioGrup = new javax.swing.ButtonGroup();
        tampilSesuatu = new javax.swing.JDialog();
        jPanel17 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        Labelnya2 = new javax.swing.JLabel();
        isiannya1 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        Tabelnya_KelasMatkul = new javax.swing.JTable();
        jLabel36 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        homeButton = new javax.swing.JButton();
        matkulButton = new javax.swing.JButton();
        dosenButton = new javax.swing.JButton();
        ruangButton = new javax.swing.JButton();
        kelasButton = new javax.swing.JButton();
        penjadwalanButton = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelKelasMatakuliah = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        sisaMatkul = new javax.swing.JLabel();
        pilihSemester = new javax.swing.JComboBox();
        comboSemester = new javax.swing.JComboBox();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        buttonLihatJadwal = new javax.swing.JButton();
        buttonBuatJadwal = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();

        cariDosen.setTitle("CARI DOSEN");
        cariDosen.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                cariDosenWindowActivated(evt);
            }
        });
        cariDosen.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jPanel7.setBackground(new java.awt.Color(255, 102, 0));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        jPanel8.setBackground(new java.awt.Color(255, 102, 0));

        Labelnya.setFont(new java.awt.Font("Wide Latin", 1, 18)); // NOI18N
        Labelnya.setText("CARI");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Labelnya, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Labelnya, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        isiannya.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                isiannyaKeyReleased(evt);
            }
        });

        Tabelnya.setModel(new javax.swing.table.DefaultTableModel(
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
        Tabelnya.setSelectionForeground(new java.awt.Color(0, 0, 0));
        Tabelnya.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelnyaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Tabelnya);

        jLabel11.setText("Masukkan :");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(isiannya, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 167, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(isiannya, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        cariDosen.getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 360));

        tambahDosen.setTitle("PENAMBAHAN DOSEN");
        tambahDosen.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                tambahDosenWindowActivated(evt);
            }
        });
        tambahDosen.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        jPanel10.setBackground(new java.awt.Color(255, 102, 0));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 639, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        jPanel11.setBackground(new java.awt.Color(255, 102, 0));

        Labelnya1.setFont(new java.awt.Font("Wide Latin", 1, 18)); // NOI18N
        Labelnya1.setText("TAMBAH");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Labelnya1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(441, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Labelnya1, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("NSimSun", 1, 18)); // NOI18N
        jLabel12.setText("DATA KELAS MATAKULIAH");
        jPanel12.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("No Kelas");
        jPanel12.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 38, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Matakuliah");
        jPanel12.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 66, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Dosen Pengampu");
        jPanel12.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 92, -1, 30));

        dsn_button.setText("Cari");
        dsn_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dsn_buttonActionPerformed(evt);
            }
        });
        jPanel12.add(dsn_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(546, 90, -1, -1));

        isianSKS.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        isianSKS.setForeground(new java.awt.Color(255, 0, 0));
        jPanel12.add(isianSKS, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 120, 40, 20));

        HapusButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        HapusButton.setText("HAPUS");
        HapusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HapusButtonActionPerformed(evt);
            }
        });
        jPanel12.add(HapusButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 170, 141, 48));

        lbl_kelas.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel12.add(lbl_kelas, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 48, 20));

        lbl_matkul.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel12.add(lbl_matkul, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 61, 480, 22));

        RubahButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        RubahButton.setText("UBAH");
        RubahButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RubahButtonActionPerformed(evt);
            }
        });
        jPanel12.add(RubahButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 141, 48));

        lbl_idKelas.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel12.add(lbl_idKelas, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 38, 71, 17));

        jLabel37.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel37.setText("Kelas");
        jPanel12.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        jLabel38.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 0, 0));
        jLabel38.setText("SKS Dosen saat ini = ");
        jPanel12.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 140, 20));

        smstr.setText("jLabel5");
        smstr.setEnabled(false);
        jPanel12.add(smstr, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        isianDosen.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        isianDosen.setText("-");
        jPanel12.add(isianDosen, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 400, 30));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        tambahDosen.getContentPane().add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 360));

        buatKelas.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        buatKelas.setTitle("PEMBUATAN KELAS MATAKULIAH BARU");
        buatKelas.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                buatKelasWindowActivated(evt);
            }
        });
        buatKelas.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));

        jPanel14.setBackground(new java.awt.Color(255, 102, 0));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel14.setText("BUAT KELAS MATAKULIAH");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(342, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel15.setBackground(new java.awt.Color(255, 102, 0));

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 690, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 67, Short.MAX_VALUE)
        );

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        radioGanjil.setSelected(true);
        radioGanjil.setText("GANJIL");
        radioGanjil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioGanjilActionPerformed(evt);
            }
        });
        jPanel16.add(radioGanjil, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, -1, -1));

        radioGenap.setText("GENAP");
        radioGenap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioGenapActionPerformed(evt);
            }
        });
        jPanel16.add(radioGenap, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, -1, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("Sem 7");
        jPanel16.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 50, 20));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setText("SEMESTER");
        jPanel16.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 70, 20));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText("JUMLAH KELAS");
        jPanel16.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 100, 20));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setText("Kelas");
        jPanel16.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 130, 40, 20));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setText("Sem 3");
        jPanel16.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 50, 20));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setText("Sem 5");
        jPanel16.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 50, 20));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setText("Sem 2");
        jPanel16.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 40, 50, 20));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel22.setText("Sem 4");
        jPanel16.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 70, 50, 20));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel23.setText("Sem 6");
        jPanel16.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 100, 50, 20));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel24.setText("Sem 8");
        jPanel16.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 130, 50, 20));

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel25.setText("Sem 1");
        jPanel16.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 50, 20));

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel26.setText("Kelas");
        jPanel16.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, 40, 20));

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel27.setText("Kelas");
        jPanel16.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 70, 40, 20));

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel28.setText("Kelas");
        jPanel16.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, 40, 20));

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel29.setText("Kelas");
        jPanel16.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, 40, 20));

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel30.setText("Kelas");
        jPanel16.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 40, 40, 20));

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel31.setText("Kelas");
        jPanel16.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 70, 40, 20));

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel32.setText("Kelas");
        jPanel16.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 100, 40, 20));

        button_buatKelas.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        button_buatKelas.setText("BUAT KELAS KULIAH");
        button_buatKelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_buatKelasActionPerformed(evt);
            }
        });
        jPanel16.add(button_buatKelas, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 450, 70));

        sem8.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7" }));
        sem8.setEnabled(false);
        jPanel16.add(sem8, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 130, 40, -1));

        sem1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7" }));
        jPanel16.add(sem1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, 40, -1));

        sem3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7" }));
        jPanel16.add(sem3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 40, -1));

        sem5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7" }));
        jPanel16.add(sem5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, 40, -1));

        sem7.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7" }));
        jPanel16.add(sem7, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, 40, -1));

        sem2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7" }));
        sem2.setEnabled(false);
        jPanel16.add(sem2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 40, 40, -1));

        sem4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7" }));
        sem4.setEnabled(false);
        jPanel16.add(sem4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 70, 40, -1));

        sem6.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7" }));
        sem6.setEnabled(false);
        jPanel16.add(sem6, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 100, 40, -1));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        buatKelas.getContentPane().add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 390));

        radioGrup.add(radioGanjil);
        radioGrup.add(radioGenap);

        tampilSesuatu.setTitle("DAFTAR SELURUH MATKUL");
        tampilSesuatu.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                tampilSesuatuWindowActivated(evt);
            }
        });
        tampilSesuatu.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));

        jPanel18.setBackground(new java.awt.Color(255, 102, 0));

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 930, Short.MAX_VALUE)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        jPanel19.setBackground(new java.awt.Color(255, 102, 0));

        Labelnya2.setFont(new java.awt.Font("Wide Latin", 1, 18)); // NOI18N
        Labelnya2.setText("TAMPIL SELURUH MATKUL");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Labelnya2, javax.swing.GroupLayout.DEFAULT_SIZE, 910, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Labelnya2, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        isiannya1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                isiannya1KeyReleased(evt);
            }
        });

        Tabelnya_KelasMatkul.setModel(new javax.swing.table.DefaultTableModel(
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
        Tabelnya_KelasMatkul.setSelectionForeground(new java.awt.Color(0, 0, 0));
        Tabelnya_KelasMatkul.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tabelnya_KelasMatkulMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(Tabelnya_KelasMatkul);

        jLabel36.setText("Masukkan :");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 910, Short.MAX_VALUE)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jLabel36)
                        .addGap(18, 18, 18)
                        .addComponent(isiannya1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(isiannya1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        tampilSesuatu.getContentPane().add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 930, 430));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SISTEM PENJADWALAN MATAKULIAH PGSD USD - PEMBUATAN KELAS KULIAH");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

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
        jPanel3.add(homeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 80, 40));

        matkulButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        matkulButton.setText("MATAKULIAH");
        matkulButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                matkulButtonActionPerformed(evt);
            }
        });
        jPanel3.add(matkulButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 130, 40));

        dosenButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        dosenButton.setText("DOSEN");
        dosenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dosenButtonActionPerformed(evt);
            }
        });
        jPanel3.add(dosenButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 100, 40));

        ruangButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ruangButton.setText("RUANG");
        ruangButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ruangButtonActionPerformed(evt);
            }
        });
        jPanel3.add(ruangButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 100, 40));

        kelasButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        kelasButton.setText("BUAT KELAS KULIAH");
        kelasButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kelasButtonActionPerformed(evt);
            }
        });
        jPanel3.add(kelasButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, 190, 40));

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

        jLabel4.setFont(new java.awt.Font("NSimSun", 1, 18)); // NOI18N
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 70, 40, 30));

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
        tabelKelasMatakuliah.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tabelKelasMatakuliah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelKelasMatakuliahMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelKelasMatakuliah);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 910, 150));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("TOTAL MATAKULIAH : ");
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 270, 300, 40));

        sisaMatkul.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel4.add(sisaMatkul, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 20, 50, 30));

        pilihSemester.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pilihSemester.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "GANJIL", "GENAP" }));
        pilihSemester.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pilihSemesterActionPerformed(evt);
            }
        });
        jPanel4.add(pilihSemester, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 80, 30));

        comboSemester.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        comboSemester.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSemesterActionPerformed(evt);
            }
        });
        jPanel4.add(comboSemester, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, 60, 30));

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel34.setText("SEMESTER");
        jPanel4.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 100, 30));

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel35.setText("KELAS MATKUL TERSISA : ");
        jPanel4.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 20, 240, 30));

        jLabel33.setFont(new java.awt.Font("NSimSun", 1, 18)); // NOI18N
        jLabel33.setText("TABEL MATAKULIAH SEMESTER ");
        jPanel4.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, 270, 30));

        buttonLihatJadwal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        buttonLihatJadwal.setText("LIHAT JADWAL");
        buttonLihatJadwal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLihatJadwalActionPerformed(evt);
            }
        });
        jPanel4.add(buttonLihatJadwal, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 270, 190, 40));

        buttonBuatJadwal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        buttonBuatJadwal.setText("BUAT JADWAL BARU");
        buttonBuatJadwal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBuatJadwalActionPerformed(evt);
            }
        });
        jPanel4.add(buttonBuatJadwal, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 190, 40));

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

    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked
    }//GEN-LAST:event_jScrollPane1MouseClicked

    private void dsn_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dsn_buttonActionPerformed
        try {
            cariDosen.setVisible(true);
            isiannya.setText("");
            updateTabelDosen();
        } catch (SQLException ex) {
            Logger.getLogger(viewKelas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_dsn_buttonActionPerformed

    private void isiannyaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_isiannyaKeyReleased
        try {
            String cari = isiannya.getText();
            cariDosen(cari);
        } catch (SQLException ex) {
            Logger.getLogger(viewKelas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_isiannyaKeyReleased

    private void TabelnyaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelnyaMouseClicked
        int row1 = Tabelnya.getSelectedRow();
        String idDosen = Tabelnya.getValueAt(row1, 0).toString();
        String namaDosen = Tabelnya.getValueAt(row1, 1).toString();
        try {
            isianSKS.setText(Integer.toString(KelasMatkulKontrol.getKoneksi().cekSKSDosen(namaDosen)));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        isianDosen.setText(idDosen + "-" + namaDosen);
        cariDosen.setVisible(false);
    }//GEN-LAST:event_TabelnyaMouseClicked

    private void radioGanjilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioGanjilActionPerformed
        sem1.setEnabled(true);
        sem2.setEnabled(false);
        sem2.setSelectedIndex(0);
        sem3.setEnabled(true);
        sem4.setEnabled(false);
        sem4.setSelectedIndex(0);
        sem5.setEnabled(true);
        sem6.setEnabled(false);
        sem6.setSelectedIndex(0);
        sem7.setEnabled(true);
        sem8.setEnabled(false);
        sem8.setSelectedIndex(0);
    }//GEN-LAST:event_radioGanjilActionPerformed

    private void radioGenapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioGenapActionPerformed
        sem1.setEnabled(false);
        sem1.setSelectedIndex(0);
        sem2.setEnabled(true);
        sem3.setEnabled(false);
        sem3.setSelectedIndex(0);
        sem4.setEnabled(true);
        sem5.setEnabled(false);
        sem5.setSelectedIndex(0);
        sem6.setEnabled(true);
        sem7.setEnabled(false);
        sem7.setSelectedIndex(0);
        sem8.setEnabled(true);
    }//GEN-LAST:event_radioGenapActionPerformed

    private void button_buatKelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_buatKelasActionPerformed
        int data = JOptionPane.showConfirmDialog(null, "Apakah anda yakin membuat jadwal yang baru? "
                + "\nDengan ini SEMUA kelas matakuliah yang lama akan terhapus secara otomatis", "MEMBUAT KELAS KULIAH", 1);
        if (data == 0) {//kalo setuju
            if (radioGanjil.isSelected()) {
                try {
                    KelasMatkulKontrol.getKoneksi().deleteAllKelasMatkul();
                } catch (SQLException ex) {
                    Logger.getLogger(viewKelas.class.getName()).log(Level.SEVERE, null, ex);
                }
//                JOptionPane.showMessageDialog(null, "Ganjil");
                int[] jumlah = {Integer.parseInt(sem1.getSelectedItem().toString()),
                    Integer.parseInt(sem3.getSelectedItem().toString()),
                    Integer.parseInt(sem5.getSelectedItem().toString()),
                    Integer.parseInt(sem7.getSelectedItem().toString())};

                int idkelas = 1;
                int indSem = 0;
                String[] Kelas = {"A", "B", "C", "D", "E", "F", "G"};

                for (int semester = 1; semester <= 7; semester += 2) {
                    List<MataKuliah> matkul = null;
                    try {
                        matkul = KelasMatkulKontrol.getKoneksi().tampilMatakuliahPerSemester(semester);
                    } catch (SQLException ex) {
                        Logger.getLogger(viewKelas.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    for (int i = 0; i < matkul.size(); i++) {//looping matkul
                        for (int j = 0; j < jumlah[indSem]; j++) {//looping jumlah matkul
                            KelasKuliah kk = new KelasKuliah();
                            kk.setIdKelas(idkelas);
                            kk.setIdMK(new MataKuliah(matkul.get(i).getIdMK()));
                            kk.setIdDosen(new Dosen("-"));
                            kk.setKelas(Kelas[j]);
                            try {
                                KelasMatkulKontrol.getKoneksi().insertKelasMataKuliah(kk);
                            } catch (SQLException ex) {
                                Logger.getLogger(viewKelas.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            idkelas++;
                        }
                    }
                    indSem++;
                }

                this.setVisible(true);
                buatKelas.setVisible(false);
                try {
                    updateTabelKelasSemester(Integer.parseInt(comboSemester.getSelectedItem().toString()));
                } catch (SQLException ex) {
                    Logger.getLogger(viewKelas.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
//                JOptionPane.showMessageDialog(null, "Genap");
            }
        } else {
        }
    }//GEN-LAST:event_button_buatKelasActionPerformed

    private void tabelKelasMatakuliahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelKelasMatakuliahMouseClicked
        int row1 = tabelKelasMatakuliah.getSelectedRow();
        lbl_idKelas.setText(tabelKelasMatakuliah.getValueAt(row1, 0).toString());
        lbl_matkul.setText(tabelKelasMatakuliah.getValueAt(row1, 1).toString() + "-" + tabelKelasMatakuliah.getValueAt(row1, 2).toString());
        lbl_kelas.setText(tabelKelasMatakuliah.getValueAt(row1, 3).toString());
        smstr.setText(tabelKelasMatakuliah.getValueAt(row1, 4).toString());
        isianDosen.setText("-");
        isianSKS.setText("-");
        tambahDosen.setVisible(true);
    }//GEN-LAST:event_tabelKelasMatakuliahMouseClicked

    private void RubahButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RubahButtonActionPerformed
        if (isianDosen.getText().equals("-")) {
            JOptionPane.showMessageDialog(null, "Silahkan Pilih dosen pengampu");
        } else {
            int jumlahMengajar = Integer.parseInt(isianSKS.getText().toString()) + Integer.parseInt(smstr.getText().toString());
            if (jumlahMengajar > 30) {//jumlah mengajar dosen lebih dari 20sks
                JOptionPane.showMessageDialog(null, "Jumlah mengajar dosen melebihi batas maks 20 SKS. Silahkan memilih dosen pengampu lain");
            } else {
                KelasKuliah temp = new KelasKuliah();
                temp.setIdKelas(Integer.parseInt(lbl_idKelas.getText()));
                temp.setIdDosen(new Dosen(isianDosen.getText().split("-")[0]));
                try {
                    KelasMatkulKontrol.getKoneksi().updateKelasMataKuliah(temp);
                    JOptionPane.showMessageDialog(null, "Berhasil Dirubah");
                    updateTabelKelasSemester(Integer.parseInt(comboSemester.getSelectedItem().toString()));
                    tambahDosen.setVisible(false);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }//GEN-LAST:event_RubahButtonActionPerformed

    private void HapusButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HapusButtonActionPerformed
        int data = JOptionPane.showConfirmDialog(null, "Apakah anda yakin Menghapus kelas matakuliah :"
                + "\nMATKUL     : " + lbl_matkul.getText()
                + "\nKELAS      : " + lbl_kelas.getText(), "MENGHAPUS KELAS", 1);
        if (data == 0) {//kalo setuju
            KelasKuliah kk = new KelasKuliah(Integer.parseInt(lbl_idKelas.getText()));
            try {
                KelasMatkulKontrol.getKoneksi().deleteKelasMataKuliah(kk);
                updateTabelKelasSemester(Integer.parseInt(comboSemester.getSelectedItem().toString()));
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_HapusButtonActionPerformed

    private void pilihSemesterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pilihSemesterActionPerformed
        if (pilihSemester.getSelectedItem().toString().equals("GANJIL")) {
            String[] Semester = {"1", "3", "5", "7"};
            String[] SemesterRemove = {"2", "4", "6", "8"};
            for (int i = 0; i < Semester.length; i++) {
                comboSemester.addItem(Semester[i]);
                comboSemester.removeItem(SemesterRemove[i]);
            }
        } else {
            String[] Semester = {"2", "4", "6", "8"};
            String[] SemesterRemove = {"1", "3", "5", "7"};
            for (int i = 0; i < Semester.length; i++) {
                comboSemester.addItem(Semester[i]);
                comboSemester.removeItem(SemesterRemove[i]);
            }
        }

    }//GEN-LAST:event_pilihSemesterActionPerformed

    private void comboSemesterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSemesterActionPerformed
        String Semester = comboSemester.getSelectedItem().toString();
//        if (!Semester.matches("[0-9]*")) {
//            JOptionPane.showMessageDialog(null, "Masukkan harus angka..!!");
//        } else {
        try {
            updateTabelKelasSemester(Integer.parseInt(Semester));
            jLabel4.setText(Semester);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
//        }
    }//GEN-LAST:event_comboSemesterActionPerformed

    private void buttonBuatJadwalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBuatJadwalActionPerformed
        viewKelas a = new viewKelas();
        a.buatKelas.setVisible(true);
    }//GEN-LAST:event_buttonBuatJadwalActionPerformed

    private void buttonLihatJadwalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLihatJadwalActionPerformed
        tampilSesuatu.setVisible(true);
        try {
            updateTabelKelas("");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_buttonLihatJadwalActionPerformed

    private void isiannya1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_isiannya1KeyReleased
        try {
            String cari = isiannya1.getText();
            updateTabelKelas(cari);
        } catch (SQLException ex) {
            Logger.getLogger(viewKelas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_isiannya1KeyReleased

    private void Tabelnya_KelasMatkulMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabelnya_KelasMatkulMouseClicked
        int row1 = Tabelnya_KelasMatkul.getSelectedRow();
        lbl_idKelas.setText(Tabelnya_KelasMatkul.getValueAt(row1, 0).toString());
        lbl_matkul.setText(Tabelnya_KelasMatkul.getValueAt(row1, 1).toString() + "-" + Tabelnya_KelasMatkul.getValueAt(row1, 2).toString());
        lbl_kelas.setText(Tabelnya_KelasMatkul.getValueAt(row1, 3).toString());
        smstr.setText(Tabelnya_KelasMatkul.getValueAt(row1, 4).toString());
        Dosen dos = null;
        try {
            dos = KelasMatkulKontrol.getKoneksi().tampilDosen(Tabelnya_KelasMatkul.getValueAt(row1, 7).toString());
            isianSKS.setText(Integer.toString(KelasMatkulKontrol.getKoneksi().cekSKSDosen(dos.getNamaDosen())));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        isianDosen.setText(dos.getIdDosen() + "-" + dos.getNamaDosen());
        tambahDosen.setVisible(true);
    }//GEN-LAST:event_Tabelnya_KelasMatkulMouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        //untuk ganti icon
        Image oldIcon = getIconImage();
        ImageIcon newIcon = createImageIcon("/gambar/dosen.png");
        setIconImage(newIcon.getImage());
    }//GEN-LAST:event_formWindowActivated

    private void cariDosenWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_cariDosenWindowActivated
        Image oldIcon = getIconImage();
        ImageIcon newIcon = createImageIcon("/gambar/dosen.png");
        cariDosen.setIconImage(newIcon.getImage());
    }//GEN-LAST:event_cariDosenWindowActivated

    private void tambahDosenWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_tambahDosenWindowActivated
        Image oldIcon = getIconImage();
        ImageIcon newIcon = createImageIcon("/gambar/dosen.png");
        tambahDosen.setIconImage(newIcon.getImage());
    }//GEN-LAST:event_tambahDosenWindowActivated

    private void buatKelasWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_buatKelasWindowActivated
        Image oldIcon = getIconImage();
        ImageIcon newIcon = createImageIcon("/gambar/dosen.png");
        buatKelas.setIconImage(newIcon.getImage());
    }//GEN-LAST:event_buatKelasWindowActivated

    private void tampilSesuatuWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_tampilSesuatuWindowActivated
        Image oldIcon = getIconImage();
        ImageIcon newIcon = createImageIcon("/gambar/dosen.png");
        tampilSesuatu.setIconImage(newIcon.getImage());
    }//GEN-LAST:event_tampilSesuatuWindowActivated

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
    private javax.swing.JButton HapusButton;
    private javax.swing.JLabel Labelnya;
    private javax.swing.JLabel Labelnya1;
    private javax.swing.JLabel Labelnya2;
    private javax.swing.JButton RubahButton;
    private javax.swing.JTable Tabelnya;
    private javax.swing.JTable Tabelnya_KelasMatkul;
    private javax.swing.JDialog buatKelas;
    private javax.swing.JButton buttonBuatJadwal;
    private javax.swing.JButton buttonLihatJadwal;
    private javax.swing.JButton button_buatKelas;
    private javax.swing.JDialog cariDosen;
    private javax.swing.JComboBox comboSemester;
    private javax.swing.JButton dosenButton;
    private javax.swing.JButton dsn_button;
    private javax.swing.JButton homeButton;
    private javax.swing.JLabel isianDosen;
    private javax.swing.JLabel isianSKS;
    private javax.swing.JTextField isiannya;
    private javax.swing.JTextField isiannya1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton kelasButton;
    private javax.swing.JLabel lbl_idKelas;
    private javax.swing.JLabel lbl_kelas;
    private javax.swing.JLabel lbl_matkul;
    private javax.swing.JButton matkulButton;
    private javax.swing.JButton penjadwalanButton;
    private javax.swing.JComboBox pilihSemester;
    private javax.swing.JRadioButton radioGanjil;
    private javax.swing.JRadioButton radioGenap;
    private javax.swing.ButtonGroup radioGrup;
    private javax.swing.JButton ruangButton;
    private javax.swing.JComboBox sem1;
    private javax.swing.JComboBox sem2;
    private javax.swing.JComboBox sem3;
    private javax.swing.JComboBox sem4;
    private javax.swing.JComboBox sem5;
    private javax.swing.JComboBox sem6;
    private javax.swing.JComboBox sem7;
    private javax.swing.JComboBox sem8;
    private javax.swing.JLabel sisaMatkul;
    private javax.swing.JLabel smstr;
    private javax.swing.JTable tabelKelasMatakuliah;
    private javax.swing.JDialog tambahDosen;
    private javax.swing.JDialog tampilSesuatu;
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
