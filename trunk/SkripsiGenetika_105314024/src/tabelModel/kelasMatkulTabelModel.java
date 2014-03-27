/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tabelModel;

import clas.kelas_matkul;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ADIT
 */
public class kelasMatkulTabelModel extends AbstractTableModel {

    private List<kelas_matkul> kelasmk = new ArrayList<kelas_matkul>();

    public kelasMatkulTabelModel(List<kelas_matkul> kelasmk) {
        this.kelasmk = kelasmk;
    }

    @Override
    public int getRowCount() {
        return kelasmk.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        kelas_matkul k = kelasmk.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return k.getIdKelas();
            case 1:
                return k.getNamaKelas();
            case 2:
                return k.getJumlahMahasiswa();
            case 3:
                return k.getIdDosen();
            case 4:
                return k.getIdRuang();
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID Kelas";
            case 1:
                return "Nama Kelas";
            case 2:
                return "Jumlah Mahasiswa";
            case 3:
                return "ID Dosen";
            case 4:
                return "ID Ruang";
            default:
                return "";
        }
    }
}
