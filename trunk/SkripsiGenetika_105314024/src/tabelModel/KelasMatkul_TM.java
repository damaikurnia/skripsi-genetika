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
public class KelasMatkul_TM extends AbstractTableModel {

    private List<KelasKuliah> kk = new ArrayList<KelasKuliah>();

    public KelasMatkul_TM(List<KelasKuliah> kk) {
        this.kk = kk;
    }

    @Override
    public int getRowCount() {
        return kk.size();
    }

    @Override
    public int getColumnCount() {
        return 8;
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
                return r.getIdMK().getNamaMK();
            case 3:
                return r.getKelas();
            case 4:
                return r.getIdMK().getSks();
            case 5:
                return r.getIdMK().getSemester();
            case 6:
                return r.getIdMK().getJP();
            case 7:
                return r.getIdDosen().getNamaDosen();
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "NO";
            case 1:
                return "KODE MK";
            case 2:
                return "NAMA MK";
            case 3:
                return "KELAS";
            case 4:
                return "SKS";
            case 5:
                return "SEMESTER";
            case 6:
                return "JP";
            case 7:
                return "DOSEN PENGAMPU";
            default:
                return "";
        }
    }
}
