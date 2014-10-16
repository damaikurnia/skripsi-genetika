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
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        tabelPermintaan r = kk.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return r.getNoRule();
            case 1:
                return r.getIdKelas();
            case 2:
                return r.getIdRuang();
            case 3:
                return r.getHari();
            case 4:
                return r.getJam();
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
                return "NAMA KELAS-DOSEN PENGAMPU";
            case 2:
                return "RUANG";
            case 3:
                return "HARI";
            case 4:
                return "JAM";
            default:
                return "";
        }
    }
}
