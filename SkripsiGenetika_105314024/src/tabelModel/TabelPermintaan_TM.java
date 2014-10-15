/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabelModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import kelas.KelasKuliah;

/**
 *
 * @author Mich
 */
public class TabelPermintaan_TM extends AbstractTableModel {

    private List<KelasKuliah> kk = new ArrayList<KelasKuliah>();

    public TabelPermintaan_TM(List<KelasKuliah> kk) {
        this.kk = kk;
    }

    @Override
    public int getRowCount() {
        return kk.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        KelasKuliah r = kk.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return r.getIdKelas();
            case 1:
                return r.getIdMK().getIdMK();
            case 2:
                return r.getIdDosen().getIdDosen();
            case 3:
                return r.getKelas();
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "No";
            case 1:
                return "Kode Matakuliah";
            case 2:
                return "Dosen Pengampu";
            case 3:
                return "Kelas";
            default:
                return "";
        }
    }
}
