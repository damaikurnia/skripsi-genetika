/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kelas;

/**
 *
 * @author Adhi
 */
public class Pelanggaran {
    
    public static Kromosom cekRuang(Kromosom x) {
        return null;
    } //aturan 1 - return kromosom

    public static Kromosom cekDosen(Kromosom x) {
        return null;
    } //aturan 2

    public static Kromosom cekMatakuliah(Kromosom x) {
        return null;
    } //aturan 3

    public static Kromosom cekJumlahMatakuliah(Kromosom x) {
        return null;
    } //aturan 4

    public static Kromosom cekDosenMengajar(Kromosom x) {
        return null;
    } //aturan 5

    public static Kromosom eksekusiAturan(Kromosom x) {
        Kromosom parent = Pelanggaran.cekRuang(x);
        parent = Pelanggaran.cekDosen(x);
        parent = Pelanggaran.cekMatakuliah(x);
        parent = Pelanggaran.cekJumlahMatakuliah(x);
        parent = Pelanggaran.cekDosenMengajar(x);
        return parent;
    }
}
