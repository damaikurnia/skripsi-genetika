/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tabelModel;

import kelas.Ruang;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Mich
 */
public class Ruang_TM extends AbstractTableModel {

    private List<Ruang> rk = new ArrayList<Ruang>();

    public Ruang_TM(List<Ruang> rk) {
        this.rk = rk;
    }

    @Override
    public int getRowCount() {
        return rk.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Ruang r = rk.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return r.getIdRuang();
            case 1:
                return r.getNamaRuang();
            case 2:
                return r.getJenisRuang();
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
                return "NAMA RUANG";
            case 2:
                return "JENIS";
            default:
                return "";
        }
    }

}
