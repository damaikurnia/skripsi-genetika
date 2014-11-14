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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.Normalizer.Form;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import kelas.Dosen;
import kelas.KelasKuliah;
import kelas.MataKuliah;
import kelas.Populasi;
import kelas.Ruang;
import kelas.tabelPermintaan;
import kontrol.DosenKontrol;
import kontrol.KelasMatkulKontrol;
import kontrol.MataKuliahKontrol;
import kontrol.PenjadwalanKontrol;
import kontrol.RuangKontrol;
import tabelModel.Dosen_TM;
import tabelModel.KelasMatkulPenjadwalan_TM;
import tabelModel.KelasMatkul_TM;
import tabelModel.MataKuliah_TM;
import tabelModel.TabelPermintaan_TM;
import tabelModel.renderWarnaWarni;

/**
 *
 * @author ADHI
 */
public class viewPenjadwalan extends javax.swing.JFrame {

    private Timer timer;
    private int jam = 0, menit = 0, detik = 0;
    private SwingWorker<String, String> Genetic_Proses;

    /**
     * Creates new form viewKelas
     */
    public viewPenjadwalan() {
        initComponents();
        setLocationRelativeTo(null);

        dialog_dosen.setVisible(false);
        dialog_dosen.setSize(777, 480);
        dialog_dosen.setLocationRelativeTo(null);
        dialog_dosen.setTitle("DATA DOSEN");

        dialog_matkul.setVisible(false);
        dialog_matkul.setSize(777, 480);
        dialog_matkul.setLocationRelativeTo(null);
        dialog_matkul.setTitle("DATA MATAKULIAH");

        dialog_pleasewait.setVisible(false);
        dialog_pleasewait.setSize(700, 178);
        dialog_pleasewait.setLocationRelativeTo(null);
        dialog_pleasewait.setTitle("PEMBUATAN JADWAL...");

        dialog_solusiJadwal.setVisible(false);
        dialog_solusiJadwal.setSize(1033, 470);
        dialog_solusiJadwal.setLocationRelativeTo(null);
        dialog_solusiJadwal.setTitle("JADWAL");

        dialog_penjadwalanAll.setVisible(false);
        dialog_penjadwalanAll.setSize(685, 450);
        dialog_penjadwalanAll.setLocationRelativeTo(null);

        dialog_matkulAll.setVisible(false);
        dialog_matkulAll.setSize(777, 480);
        dialog_matkulAll.setLocationRelativeTo(null);
        dialog_matkulAll.setTitle("DATA MATAKULIAH");

        try {
            updateTabelPermintaan();
            updateTabelDosen();
            isiComboRuang();
        } catch (SQLException ex) {
            Logger.getLogger(viewPenjadwalan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void updateTabelMataKuliah() throws SQLException {
        String kodeDosen = text_dosen.getText().split("-")[0];
        List<KelasKuliah> mktm = KelasMatkulKontrol.getKoneksi().tampilMakulDosen(kodeDosen);//masih kosong
        KelasMatkulPenjadwalan_TM model = new KelasMatkulPenjadwalan_TM(mktm);
        tabel_kelasmatakuliah.setModel(model);
    }

    private void updateTabelMataKuliah2() throws SQLException {
        List<MataKuliah> mktm = MataKuliahKontrol.getKoneksi().tampilMataKuliah();
        MataKuliah_TM model = new MataKuliah_TM(mktm);
        tabel_MatakuliahAll.setModel(model);

        tabel_MatakuliahAll.getColumnModel().getColumn(1).setMinWidth(400);
        tabel_MatakuliahAll.getColumnModel().getColumn(1).setMaxWidth(400);

        tabel_MatakuliahAll.setDefaultRenderer(Object.class, new renderWarnaWarni(Color.lightGray, Color.white));
    }

    private void updateTabelDosen() throws SQLException {
        List<Dosen> mktm = DosenKontrol.getKoneksi().tampilDosen();
        Dosen_TM model = new Dosen_TM(mktm);
        Tabel_Dosen.setModel(model);
        Tabel_Dosen.setDefaultRenderer(Object.class, new renderWarnaWarni(Color.lightGray, Color.white));
    }

    private void updateTabelPermintaan() throws SQLException {
        List<tabelPermintaan> mktm = PenjadwalanKontrol.getKoneksi().tampilTabelPermintaan();
        TabelPermintaan_TM model = new TabelPermintaan_TM(mktm);
        Tabel_Permintaan.setModel(model);
        Tabel_Permintaan.getColumnModel().getColumn(0).setMaxWidth(0);
        Tabel_Permintaan.getColumnModel().getColumn(1).setMinWidth(200);
        Tabel_Permintaan.setDefaultRenderer(Object.class, new renderWarnaWarni(Color.lightGray, Color.white));
    }

    private void updateTabelJadwal() throws SQLException {
        List<tabelPermintaan> mktm = PenjadwalanKontrol.getKoneksi().tampilTabelJadwal();
        TabelPermintaan_TM model = new TabelPermintaan_TM(mktm);
        Tabel_Solusi.setModel(model);
    }

    private void isiComboRuang() throws SQLException {
        List<Ruang> ruang = RuangKontrol.getKoneksi().tampilRuangTeori();
        for (Ruang k : ruang) {
            combo_ruang.addItem(k.getIdRuang() + "-" + k.getNamaRuang());
            combo_ruangAll.addItem(k.getIdRuang() + "-" + k.getNamaRuang());
        }
    }

    private void kosongkan() {
        text_dosen.setText("");
        text_matkul.setText("");
        text_klsMatkul.setText("");
        labelKelas.setText("");
        combo_hari.setSelectedIndex(0);
        combo_jam.setSelectedIndex(0);
        combo_ruang.setSelectedIndex(0);
        tombol_cariMatkul.setEnabled(false);
        try {
            updateTabelMataKuliah();
        } catch (SQLException ex) {
            Logger.getLogger(viewPenjadwalan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void kosongkan2() {
        textMatkulAll.setText("");
        comboHari_all.setSelectedIndex(0);
        combo_jamAll.setSelectedIndex(0);
        combo_ruangAll.setSelectedIndex(0);
        tabel_seluruhMatkul.removeAll();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialog_dosen = new javax.swing.JDialog();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tabel_Dosen = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        tomboldialog_dosen = new javax.swing.JButton();
        dialog_matkul = new javax.swing.JDialog();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabel_kelasmatakuliah = new javax.swing.JTable();
        labeldos = new javax.swing.JLabel();
        text_matkul = new javax.swing.JTextField();
        tomboldialog_matkul = new javax.swing.JButton();
        klikKanan = new javax.swing.JPopupMenu();
        HAPUS = new javax.swing.JMenuItem();
        dialog_pleasewait = new javax.swing.JDialog();
        jPanel12 = new javax.swing.JPanel();
        progres_barnya = new javax.swing.JProgressBar();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        label_waktu = new javax.swing.JLabel();
        dialog_solusiJadwal = new javax.swing.JDialog();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        Tabel_Solusi = new javax.swing.JTable();
        tomboldialog_dosen1 = new javax.swing.JButton();
        dialog_penjadwalanAll = new javax.swing.JDialog();
        jPanel16 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        textMatkulAll = new javax.swing.JTextField();
        buttonCariMatkul = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        comboHari_all = new javax.swing.JComboBox();
        combo_jamAll = new javax.swing.JComboBox();
        combo_ruangAll = new javax.swing.JComboBox();
        jScrollPane5 = new javax.swing.JScrollPane();
        tabel_seluruhMatkul = new javax.swing.JTable();
        button_tambahPermintaanAll = new javax.swing.JButton();
        dialog_matkulAll = new javax.swing.JDialog();
        jPanel19 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tabel_MatakuliahAll = new javax.swing.JTable();
        tomboldialog_matkul1 = new javax.swing.JButton();
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
        tombol_cariMatkul = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jadwalButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        text_dosen = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        text_klsMatkul = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        tombol_cariDosen = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabel_Permintaan = new javax.swing.JTable();
        combo_jam = new javax.swing.JComboBox();
        combo_hari = new javax.swing.JComboBox();
        combo_ruang = new javax.swing.JComboBox();
        tombol_tambahPermintaan = new javax.swing.JButton();
        button_batal = new javax.swing.JButton();
        labelKelas = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        tombolKhusus = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();

        dialog_dosen.setTitle("PENCARIAN DOSEN");
        dialog_dosen.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                dialog_dosenWindowActivated(evt);
            }
        });
        dialog_dosen.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(255, 102, 0));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel2.setText("PENCARIAN DOSEN");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 740, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        Tabel_Dosen.setModel(new javax.swing.table.DefaultTableModel(
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
        Tabel_Dosen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tabel_DosenMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Tabel_Dosen);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("NAMA DOSEN");

        tomboldialog_dosen.setText("BATAL");
        tomboldialog_dosen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tomboldialog_dosenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 740, Short.MAX_VALUE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 201, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(344, 344, 344)
                .addComponent(tomboldialog_dosen)
                .addContainerGap(353, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(tomboldialog_dosen)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        dialog_dosen.getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        dialog_matkul.setTitle("DATA MATAKULIAH");
        dialog_matkul.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                dialog_matkulWindowActivated(evt);
            }
        });
        dialog_matkul.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel10.setBackground(new java.awt.Color(255, 102, 0));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel14.setText("PENCARIAN MATAKULIAH");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 740, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        tabel_kelasmatakuliah.setModel(new javax.swing.table.DefaultTableModel(
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
        tabel_kelasmatakuliah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_kelasmatakuliahMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabel_kelasmatakuliah);

        labeldos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labeldos.setText("MATA KULIAH DOSEN PENGAMPU");

        text_matkul.setEditable(false);

        tomboldialog_matkul.setText("BATAL");
        tomboldialog_matkul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tomboldialog_matkulActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 740, Short.MAX_VALUE)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(labeldos, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(text_matkul, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 159, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(344, 344, 344)
                .addComponent(tomboldialog_matkul)
                .addContainerGap(353, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labeldos, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(text_matkul, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(tomboldialog_matkul)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        dialog_matkul.getContentPane().add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        HAPUS.setText("HAPUS");
        HAPUS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HAPUSActionPerformed(evt);
            }
        });
        klikKanan.add(HAPUS);

        dialog_pleasewait.setTitle("PROSES PEMBUATAN JADWAL");
        dialog_pleasewait.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                dialog_pleasewaitWindowActivated(evt);
            }
        });
        dialog_pleasewait.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel12.setBackground(new java.awt.Color(255, 102, 0));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("PEMBUATAN JADWAL");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("PEMBUATAN JADWAL SEDANG DALAM PROSES. SILAHKAN MENUNGGU....");

        label_waktu.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        label_waktu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(progres_barnya, javax.swing.GroupLayout.DEFAULT_SIZE, 670, Short.MAX_VALUE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 670, Short.MAX_VALUE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 670, Short.MAX_VALUE)
                    .addComponent(label_waktu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 670, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(label_waktu, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(progres_barnya, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        dialog_pleasewait.getContentPane().add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 140));

        dialog_solusiJadwal.setTitle("HASIL JADWAL KULIAH");
        dialog_solusiJadwal.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                dialog_solusiJadwalWindowActivated(evt);
            }
        });
        dialog_solusiJadwal.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel14.setBackground(new java.awt.Color(255, 102, 0));

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel19.setText("JADWAL YANG DIHASILKAN");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, 1010, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        Tabel_Solusi.setModel(new javax.swing.table.DefaultTableModel(
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
        Tabel_Solusi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tabel_SolusiMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(Tabel_Solusi);

        tomboldialog_dosen1.setText("BATAL");
        tomboldialog_dosen1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tomboldialog_dosen1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE))
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(454, 454, 454)
                .addComponent(tomboldialog_dosen1)
                .addGap(0, 493, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tomboldialog_dosen1)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        dialog_solusiJadwal.getContentPane().add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, -1));

        dialog_penjadwalanAll.setTitle("PERMINTAAN KHUSUS");
        dialog_penjadwalanAll.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                dialog_penjadwalanAllWindowActivated(evt);
            }
        });
        dialog_penjadwalanAll.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel17.setBackground(new java.awt.Color(255, 102, 0));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel20.setText("PERMINTAAN KHUSUS");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(360, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel16.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 70));

        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setText("MATKUL");
        jPanel18.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 73, 29));

        textMatkulAll.setEditable(false);
        jPanel18.add(textMatkulAll, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 16, 425, -1));

        buttonCariMatkul.setText("CARI");
        buttonCariMatkul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCariMatkulActionPerformed(evt);
            }
        });
        jPanel18.add(buttonCariMatkul, new org.netbeans.lib.awtextra.AbsoluteConstraints(544, 15, -1, -1));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel22.setText("HARI");
        jPanel18.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 73, 30));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel23.setText("JAM");
        jPanel18.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, 30, 30));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel24.setText("RUANG");
        jPanel18.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 50, 50, 29));

        comboHari_all.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-", "Senin", "Selasa", "Rabu", "Kamis", "Jumat" }));
        jPanel18.add(comboHari_all, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 109, 30));

        combo_jamAll.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-", "07:00-09:59", "10:00-12:59", "13:00-15:59", "16:00-18:59" }));
        jPanel18.add(combo_jamAll, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, 122, 29));

        combo_ruangAll.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-" }));
        jPanel18.add(combo_ruangAll, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 50, 122, 29));

        tabel_seluruhMatkul.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane5.setViewportView(tabel_seluruhMatkul);

        jPanel18.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 650, 170));

        button_tambahPermintaanAll.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        button_tambahPermintaanAll.setText("TAMBAH PERMINTAAN");
        button_tambahPermintaanAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_tambahPermintaanAllActionPerformed(evt);
            }
        });
        jPanel18.add(button_tambahPermintaanAll, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 280, 410, 40));

        jPanel16.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 670, 330));

        dialog_penjadwalanAll.getContentPane().add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 400));

        dialog_matkulAll.setTitle("DATA MATAKULIAH");
        dialog_matkulAll.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                dialog_matkulAllWindowActivated(evt);
            }
        });
        dialog_matkulAll.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel20.setBackground(new java.awt.Color(255, 102, 0));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel15.setText("PENCARIAN MATAKULIAH");

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 740, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        tabel_MatakuliahAll.setModel(new javax.swing.table.DefaultTableModel(
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
        tabel_MatakuliahAll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_MatakuliahAllMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tabel_MatakuliahAll);

        tomboldialog_matkul1.setText("BATAL");
        tomboldialog_matkul1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tomboldialog_matkul1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGap(344, 344, 344)
                        .addComponent(tomboldialog_matkul1))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 740, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(tomboldialog_matkul1)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        dialog_matkulAll.getContentPane().add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SISTEM PENJADWALAN MATAKULIAH PGSD USD - INFORMASI PERMINTAAN KELAS");
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

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("RUANG");
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 100, 50, -1));

        tombol_cariMatkul.setText("CARI");
        tombol_cariMatkul.setEnabled(false);
        tombol_cariMatkul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombol_cariMatkulActionPerformed(evt);
            }
        });
        jPanel4.add(tombol_cariMatkul, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 70, -1, -1));

        jLabel4.setFont(new java.awt.Font("NSimSun", 1, 18)); // NOI18N
        jLabel4.setText("TABEL PERMINTAAN");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, -1, -1));

        jadwalButton.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jadwalButton.setForeground(new java.awt.Color(204, 0, 0));
        jadwalButton.setText("BUAT JADWAL");
        jadwalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jadwalButtonActionPerformed(evt);
            }
        });
        jPanel4.add(jadwalButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 270, 440, 50));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("DOSEN");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        text_dosen.setEditable(false);
        text_dosen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_dosenActionPerformed(evt);
            }
        });
        jPanel4.add(text_dosen, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 320, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("MATKUL");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        text_klsMatkul.setEditable(false);
        text_klsMatkul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_klsMatkulActionPerformed(evt);
            }
        });
        jPanel4.add(text_klsMatkul, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 240, -1));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11.setText("HARI");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 40, -1));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel12.setText("JAM");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 100, 50, -1));

        tombol_cariDosen.setText("CARI");
        tombol_cariDosen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombol_cariDosenActionPerformed(evt);
            }
        });
        jPanel4.add(tombol_cariDosen, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 40, -1, -1));

        Tabel_Permintaan.setModel(new javax.swing.table.DefaultTableModel(
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
        Tabel_Permintaan.setSelectionForeground(new java.awt.Color(255, 51, 0));
        Tabel_Permintaan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                Tabel_PermintaanMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(Tabel_Permintaan);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 870, 120));

        combo_jam.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-", "07:00-09:59", "10:00-12:59", "13:00-15:59", "16:00-18:59" }));
        jPanel4.add(combo_jam, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 100, 130, -1));

        combo_hari.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-", "Senin", "Selasa", "Rabu", "Kamis", "Jumat" }));
        jPanel4.add(combo_hari, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 130, -1));

        combo_ruang.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-" }));
        jPanel4.add(combo_ruang, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 100, 120, -1));

        tombol_tambahPermintaan.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tombol_tambahPermintaan.setText("TAMBAH PERMINTAAN");
        tombol_tambahPermintaan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombol_tambahPermintaanActionPerformed(evt);
            }
        });
        jPanel4.add(tombol_tambahPermintaan, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 30, 240, 40));

        button_batal.setText("BATAL");
        button_batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_batalActionPerformed(evt);
            }
        });
        jPanel4.add(button_batal, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 40, -1, -1));

        labelKelas.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jPanel4.add(labelKelas, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 70, 30, 20));

        jLabel16.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel16.setText("KELAS");
        jPanel4.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 70, -1, 20));

        tombolKhusus.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tombolKhusus.setForeground(new java.awt.Color(204, 102, 0));
        tombolKhusus.setText("PERMINTAAN KHUSUS");
        tombolKhusus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolKhususActionPerformed(evt);
            }
        });
        jPanel4.add(tombolKhusus, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 80, 240, 40));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 940, 330));

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
        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 540, 940, 70));

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

    private void text_dosenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_dosenActionPerformed
        if (text_dosen.getText().equals("")) {
            tombol_cariMatkul.setEnabled(false);
        } else {
            tombol_cariMatkul.setEnabled(true);
        }
    }//GEN-LAST:event_text_dosenActionPerformed

    private void text_klsMatkulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_klsMatkulActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_klsMatkulActionPerformed

    private void tombol_cariDosenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombol_cariDosenActionPerformed
        dialog_dosen.setVisible(true);
    }//GEN-LAST:event_tombol_cariDosenActionPerformed

    private void tombol_cariMatkulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombol_cariMatkulActionPerformed
        dialog_matkul.setVisible(true);
    }//GEN-LAST:event_tombol_cariMatkulActionPerformed

    private void tomboldialog_dosenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tomboldialog_dosenActionPerformed
        dialog_dosen.setVisible(false);
    }//GEN-LAST:event_tomboldialog_dosenActionPerformed

    private void tomboldialog_matkulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tomboldialog_matkulActionPerformed
        dialog_matkul.setVisible(false);
    }//GEN-LAST:event_tomboldialog_matkulActionPerformed

    private void Tabel_DosenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabel_DosenMouseClicked
        int row1 = Tabel_Dosen.getSelectedRow();
        String namaDosen = Tabel_Dosen.getValueAt(row1, 0).toString() + "-" + Tabel_Dosen.getValueAt(row1, 1).toString();
        text_dosen.setText(namaDosen);
        dialog_dosen.setVisible(false);
        text_matkul.setText(namaDosen.split("-")[1]);
        try {
            updateTabelMataKuliah();
        } catch (SQLException ex) {
            Logger.getLogger(viewPenjadwalan.class.getName()).log(Level.SEVERE, null, ex);
        }
        tombol_cariMatkul.setEnabled(true);
    }//GEN-LAST:event_Tabel_DosenMouseClicked

    private void tabel_kelasmatakuliahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_kelasmatakuliahMouseClicked
        int row1 = tabel_kelasmatakuliah.getSelectedRow();
        String namaMatkul = tabel_kelasmatakuliah.getValueAt(row1, 0).toString() + "-"
                + tabel_kelasmatakuliah.getValueAt(row1, 1).toString();
        labelKelas.setText(tabel_kelasmatakuliah.getValueAt(row1, 2).toString());
        text_klsMatkul.setText(namaMatkul);
        dialog_matkul.setVisible(false);
    }//GEN-LAST:event_tabel_kelasmatakuliahMouseClicked

    private void button_batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_batalActionPerformed
        kosongkan();
    }//GEN-LAST:event_button_batalActionPerformed

    private void tombol_tambahPermintaanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombol_tambahPermintaanActionPerformed
        if (text_dosen.getText().equals("")&&text_klsMatkul.getText().equals("")) {
            JOptionPane.showMessageDialog(null,"Silahkan Pilih Dosen dan Matakuliah terlebih dahulu!");
        } else {
            try {
                int noRule = PenjadwalanKontrol.getKoneksi().cariNoRule();
                if (noRule == 0) {
                    noRule = 1;
                } else {
                    noRule++;
                }
                int idKelas = Integer.parseInt(text_klsMatkul.getText().split("-")[0]);
                String ruang;
                if (combo_ruang.getSelectedItem().toString().equals("-")) {
                    ruang = combo_ruang.getSelectedItem().toString();
                } else {
                    ruang = combo_ruang.getSelectedItem().toString().split("-")[0];
                }
                String hari = combo_hari.getSelectedItem().toString();
                String jam = combo_jam.getSelectedItem().toString();
                boolean cek = PenjadwalanKontrol.getKoneksi().cekRuang(ruang, hari, jam);
                if (cek == true) {
                    tabelPermintaan tab = new tabelPermintaan(noRule, idKelas, ruang, hari, jam);
                    PenjadwalanKontrol.getKoneksi().insertTabelPermintaan(tab);
                    JOptionPane.showMessageDialog(null, "DATA PERMINTAAN" + "\n"
                            + "MATAKULIAH         : " + idKelas + "\n"
                            + "KELAS              : " + labelKelas.getText() + "\n"
                            + "DOSEN PENGAMPU     : " + text_dosen.getText().split("-")[1] + "\n"
                            + "JADWAL PERMINTAAN  : " + "HARI " + hari + " RUANG " + ruang + "\n"
                            + "JAM                : " + jam + "\n"
                            + "BERHASIL DITAMBAHKAN");
                    updateTabelPermintaan();
                    kosongkan();
                } else {
                    JOptionPane.showMessageDialog(null, "RUANG " + ruang + " HARI " + hari + " JAM " + jam + " "
                            + "Telah dipakai oleh matakuliah lain. \n"
                            + "Silahkan pilih Ruang/Hari/Jam lain untuk matakuliah ini.");
                }
            } catch (SQLException ex) {
                Logger.getLogger(viewPenjadwalan.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_tombol_tambahPermintaanActionPerformed

    private void Tabel_PermintaanMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabel_PermintaanMouseReleased
        if (evt.isPopupTrigger()) {
            klikKanan.show(this, evt.getX(), evt.getYOnScreen());
        }
    }//GEN-LAST:event_Tabel_PermintaanMouseReleased

    private void HAPUSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HAPUSActionPerformed
        int row1 = Tabel_Permintaan.getSelectedRow();
        if (row1 == -1) {
            JOptionPane.showMessageDialog(null, "Silahkan pilih Matakuliah yang hendak di EDIT / HAPUS");
        } else {
            String idKelas = Tabel_Permintaan.getValueAt(row1, 0).toString();
            int data = JOptionPane.showConfirmDialog(null, "Apakah Mau menghapus?", "MENGHAPUS DATA " + idKelas, 1);
            if (data == 0) {
                try {
                    PenjadwalanKontrol.getKoneksi().deleteTabelPermintaan(idKelas);
                    updateTabelPermintaan();
                    JOptionPane.showMessageDialog(null, "Data Permintaan kode " + idKelas + " berhasil dihapus");
                } catch (SQLException ex) {
                    Logger.getLogger(viewPenjadwalan.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
            }
        }
    }//GEN-LAST:event_HAPUSActionPerformed

    private void busy(boolean b) {
        jadwalButton.setEnabled(!b);
    }

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

    public class TimerHandler implements ActionListener {

        private String buff;

        private void write() {
            buff = String.format(" %s%3d:%3d:%3d", "Time", jam, menit, detik);
            label_waktu.setText(buff);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            detik++;
            if (detik == 60) {
                detik = 0;
                menit++;
            }
            if (menit == 60) {
                menit = 0;
                jam++;
            }
            if (jam == 24) {
                jam = 0;
            }
            this.write();
        }
    }

    public void buatJadwal() {
        Genetic_Proses = new SwingWorker<String, String>() {

            @Override
            protected String doInBackground() throws Exception {
                busy(true);
                timer = new Timer(1000, new TimerHandler());
                timer.start();
                new Populasi().prosesGenetika();
                return "Proses Pembuatan Jadwal selesai !!!";
            }

            @Override
            protected void done() {
                try {
                    //Cek apakah proses pembuatan jadwal selesai?
                    timer.stop();
                    progres_barnya.setValue(0);
                    String pesan = get();
                    JOptionPane.showMessageDialog(null, pesan);
                    JOptionPane.showMessageDialog(null, "Waktu Penyelesaian Jadwal : " + label_waktu.getText());
                    updateTabelJadwal();
                    tutup();

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Proses tidak selesai. Alasan:\n" + ex.getMessage());
//                    Logger.getLogger(viewPenjadwalan.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    busy(false);
                }
            }
        };
        Genetic_Proses.execute();
    }

    public void tutup() {
        dialog_pleasewait.setVisible(false);
        dialog_solusiJadwal.setVisible(true);
    }

    private void jadwalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jadwalButtonActionPerformed
        dialog_pleasewait.setVisible(true);
        buatJadwal();
    }//GEN-LAST:event_jadwalButtonActionPerformed

    private void Tabel_SolusiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabel_SolusiMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Tabel_SolusiMouseClicked

    private void tomboldialog_dosen1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tomboldialog_dosen1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tomboldialog_dosen1ActionPerformed

    private void dialog_dosenWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_dialog_dosenWindowActivated
        Image oldIcon = getIconImage();
        ImageIcon newIcon = createImageIcon("/gambar/dosen.png");
        dialog_dosen.setIconImage(newIcon.getImage());
    }//GEN-LAST:event_dialog_dosenWindowActivated

    private void dialog_matkulWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_dialog_matkulWindowActivated
        Image oldIcon = getIconImage();
        ImageIcon newIcon = createImageIcon("/gambar/dosen.png");
        dialog_matkul.setIconImage(newIcon.getImage());
    }//GEN-LAST:event_dialog_matkulWindowActivated

    private void dialog_pleasewaitWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_dialog_pleasewaitWindowActivated
        Image oldIcon = getIconImage();
        ImageIcon newIcon = createImageIcon("/gambar/dosen.png");
        dialog_pleasewait.setIconImage(newIcon.getImage());
    }//GEN-LAST:event_dialog_pleasewaitWindowActivated

    private void dialog_solusiJadwalWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_dialog_solusiJadwalWindowActivated
        Image oldIcon = getIconImage();
        ImageIcon newIcon = createImageIcon("/gambar/dosen.png");
        dialog_solusiJadwal.setIconImage(newIcon.getImage());
    }//GEN-LAST:event_dialog_solusiJadwalWindowActivated

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        //untuk ganti icon
        Image oldIcon = getIconImage();
        ImageIcon newIcon = createImageIcon("/gambar/dosen.png");
        setIconImage(newIcon.getImage());
    }//GEN-LAST:event_formWindowActivated

    private void tombolKhususActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolKhususActionPerformed
        dialog_penjadwalanAll.setVisible(true);
    }//GEN-LAST:event_tombolKhususActionPerformed

    private void dialog_penjadwalanAllWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_dialog_penjadwalanAllWindowActivated
        Image oldIcon = getIconImage();
        ImageIcon newIcon = createImageIcon("/gambar/dosen.png");
        dialog_penjadwalanAll.setIconImage(newIcon.getImage());
    }//GEN-LAST:event_dialog_penjadwalanAllWindowActivated

    private void buttonCariMatkulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCariMatkulActionPerformed
        try {
            updateTabelMataKuliah2();
            dialog_matkulAll.setVisible(true);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_buttonCariMatkulActionPerformed

    private void tabel_MatakuliahAllMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_MatakuliahAllMouseClicked
        try {
            int row1 = tabel_MatakuliahAll.getSelectedRow();
            String idMatkul = tabel_MatakuliahAll.getValueAt(row1, 0).toString();
            String namaMatkul = tabel_MatakuliahAll.getValueAt(row1, 1).toString();
            textMatkulAll.setText(idMatkul + "-" + namaMatkul);
            List<KelasKuliah> data = KelasMatkulKontrol.getKoneksi().cariKelasKuliah2(idMatkul);
            KelasMatkul_TM model = new KelasMatkul_TM(data);
            tabel_seluruhMatkul.setModel(model);

            tabel_seluruhMatkul.getColumnModel().getColumn(0).setMinWidth(25);
            tabel_seluruhMatkul.getColumnModel().getColumn(0).setMaxWidth(25);
            tabel_seluruhMatkul.getColumnModel().getColumn(1).setMinWidth(70);
            tabel_seluruhMatkul.getColumnModel().getColumn(1).setMaxWidth(70);
            tabel_seluruhMatkul.getColumnModel().getColumn(2).setMinWidth(200);
            tabel_seluruhMatkul.getColumnModel().getColumn(2).setMaxWidth(200);
            tabel_seluruhMatkul.getColumnModel().getColumn(3).setMinWidth(40);
            tabel_seluruhMatkul.getColumnModel().getColumn(3).setMaxWidth(40);
            tabel_seluruhMatkul.getColumnModel().getColumn(4).setMinWidth(40);
            tabel_seluruhMatkul.getColumnModel().getColumn(4).setMaxWidth(40);
            tabel_seluruhMatkul.getColumnModel().getColumn(5).setMinWidth(65);
            tabel_seluruhMatkul.getColumnModel().getColumn(5).setMaxWidth(65);
            tabel_seluruhMatkul.getColumnModel().getColumn(6).setMinWidth(40);
            tabel_seluruhMatkul.getColumnModel().getColumn(6).setMaxWidth(40);

            tabel_seluruhMatkul.setDefaultRenderer(Object.class, new renderWarnaWarni(Color.lightGray, Color.white));

            dialog_matkulAll.setVisible(false);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_tabel_MatakuliahAllMouseClicked

    private void tomboldialog_matkul1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tomboldialog_matkul1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tomboldialog_matkul1ActionPerformed

    private void dialog_matkulAllWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_dialog_matkulAllWindowActivated
        Image oldIcon = getIconImage();
        ImageIcon newIcon = createImageIcon("/gambar/dosen.png");
        dialog_matkulAll.setIconImage(newIcon.getImage());
    }//GEN-LAST:event_dialog_matkulAllWindowActivated

    private void button_tambahPermintaanAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_tambahPermintaanAllActionPerformed
        if (textMatkulAll.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Silahkan Pilih Matakuliah");
        } else {
            int data = JOptionPane.showConfirmDialog(null, "Dengan Mengklik tombol ini anda menerapkan Permintaan Hari/Ruang/Waktu yang sama untuk SEMUA KELAS MATAKULIAH "
                    + textMatkulAll.getText() + "?", "MEMBUAT PERMINTAAN", 1);
            if (data == 0) {
                try {
                    String idMatkul = textMatkulAll.getText().toString().split("-")[0];
                    List<KelasKuliah> kp = KelasMatkulKontrol.getKoneksi().cariKelasKuliah2(idMatkul);
                    for (int i = 0; i < kp.size(); i++) {
                        int noRule = PenjadwalanKontrol.getKoneksi().cariNoRule();
                        if (noRule == 0) {
                            noRule = 1;
                        } else {
                            noRule++;
                        }
                        int idKelas = kp.get(i).getIdKelas();
                        String ruang;
                        if (combo_ruangAll.getSelectedItem().toString().equals("-")) {
                            ruang = combo_ruangAll.getSelectedItem().toString();
                        } else {
                            ruang = combo_ruangAll.getSelectedItem().toString().split("-")[0];
                        }
                        String hari = comboHari_all.getSelectedItem().toString();
                        String jam = combo_jamAll.getSelectedItem().toString();
                        if (!ruang.equals("-") && !hari.equals("-") && !jam.equals("-")) {
                            boolean cek = PenjadwalanKontrol.getKoneksi().cekRuang(ruang, hari, jam);
                            if (cek == true) {
                                tabelPermintaan tab = new tabelPermintaan(noRule, idKelas, ruang, hari, jam);
                                PenjadwalanKontrol.getKoneksi().insertTabelPermintaan(tab);
                            } else {
                                JOptionPane.showMessageDialog(null, "RUANG " + ruang + " HARI " + hari + " JAM " + jam + " "
                                        + "Telah dipakai oleh matakuliah lain. \n"
                                        + "Silahkan pilih Ruang/Hari/Jam lain untuk matakuliah ini.");
                            }
                        } else {
                            tabelPermintaan tab = new tabelPermintaan(noRule, idKelas, ruang, hari, jam);
                            PenjadwalanKontrol.getKoneksi().insertTabelPermintaan(tab);
                        }
                    }
                    kosongkan2();
                    dialog_penjadwalanAll.setVisible(false);
                    updateTabelPermintaan();
                } catch (SQLException ex) {
                    Logger.getLogger(viewRuang.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
            }
        }
    }//GEN-LAST:event_button_tambahPermintaanAllActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            java.awt.EventQueue.invokeLater(new Runnable() {

                @Override
                public void run() {
                    new viewPenjadwalan().setVisible(true);
                }
            });
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(viewPenjadwalan.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(viewPenjadwalan.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(viewPenjadwalan.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(viewPenjadwalan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem HAPUS;
    private javax.swing.JTable Tabel_Dosen;
    private javax.swing.JTable Tabel_Permintaan;
    private javax.swing.JTable Tabel_Solusi;
    private javax.swing.JButton buttonCariMatkul;
    private javax.swing.JButton button_batal;
    private javax.swing.JButton button_tambahPermintaanAll;
    private javax.swing.JComboBox comboHari_all;
    private javax.swing.JComboBox combo_hari;
    private javax.swing.JComboBox combo_jam;
    private javax.swing.JComboBox combo_jamAll;
    private javax.swing.JComboBox combo_ruang;
    private javax.swing.JComboBox combo_ruangAll;
    private javax.swing.JDialog dialog_dosen;
    private javax.swing.JDialog dialog_matkul;
    private javax.swing.JDialog dialog_matkulAll;
    private javax.swing.JDialog dialog_penjadwalanAll;
    private javax.swing.JDialog dialog_pleasewait;
    private javax.swing.JDialog dialog_solusiJadwal;
    private javax.swing.JButton dosenButton;
    private javax.swing.JButton homeButton;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
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
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
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
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton jadwalButton;
    private javax.swing.JButton kelasButton;
    private javax.swing.JPopupMenu klikKanan;
    private javax.swing.JLabel labelKelas;
    private javax.swing.JLabel label_waktu;
    private javax.swing.JLabel labeldos;
    private javax.swing.JButton matkulButton;
    private javax.swing.JButton penjadwalanButton;
    public static javax.swing.JProgressBar progres_barnya;
    private javax.swing.JButton ruangButton;
    private javax.swing.JTable tabel_MatakuliahAll;
    private javax.swing.JTable tabel_kelasmatakuliah;
    private javax.swing.JTable tabel_seluruhMatkul;
    private javax.swing.JTextField textMatkulAll;
    private javax.swing.JTextField text_dosen;
    private javax.swing.JTextField text_klsMatkul;
    private javax.swing.JTextField text_matkul;
    private javax.swing.JButton tombolKhusus;
    private javax.swing.JButton tombol_cariDosen;
    private javax.swing.JButton tombol_cariMatkul;
    private javax.swing.JButton tombol_tambahPermintaan;
    private javax.swing.JButton tomboldialog_dosen;
    private javax.swing.JButton tomboldialog_dosen1;
    private javax.swing.JButton tomboldialog_matkul;
    private javax.swing.JButton tomboldialog_matkul1;
    // End of variables declaration//GEN-END:variables
}
