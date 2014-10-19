/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabelModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import kelas.tabelPermintaan;

/**
 *
 * @author Adhi
 */
public class TabelPermintaan_TM extends AbstractTableModel {

    private List<tabelPermintaan> kk = new ArrayList<tabelPermintaan>();

    public TabelPermintaan_TM(List<tabelPermintaan> kk) {
        this.kk = kk;
    }

    @Override
    public int getRowCount() {
        return kk.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        tabelPermintaan r = kk.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return r.getIdKelas().getIdKelas();
            case 1:
                return r.getMatakuliah();
            case 2:
                return r.getNamaDosen();
            case 3:
                return r.getIdRuang().getNamaRuang();
            case 4:
                return r.getHari();
            case 5:
                return r.getJam();
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "KODE";
            case 1:
                return "MATAKULIAH";
            case 2:
                return "NAMA DOSEN";
            case 3:
                return "RUANG";
            case 4:
                return "HARI";
            case 5:
                return "JAM";
            default:
                return "";
        }
    }
}
