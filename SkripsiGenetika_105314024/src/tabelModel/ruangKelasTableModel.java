/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tabelModel;

import clas.ruang_kelas;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ADIT
 */
public class ruangKelasTableModel extends AbstractTableModel {

    private List<ruang_kelas> rk = new ArrayList<ruang_kelas>();

    public ruangKelasTableModel(List<ruang_kelas> rk) {
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
        ruang_kelas r = rk.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return r.getIdRuang();
            case 1:
                return r.getNamaRuang();
            case 2:
                return r.getKapasitas();
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID Ruang";
            case 1:
                return "Nama Ruang";
            case 2:
                return "Kapasitas";
            default:
                return "";
        }
    }
    
}