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
public class Populasi {

    private Kromosom[] parent = new Kromosom[1];//satu populasi terdiri dari 10 kromosom
    private int iterasi = 0;

    public void solusiAwalIterasi() {
        for (int i = 0; i < parent.length; i++) {
            parent[i] = new Kromosom().solusiAwal();
        }
        iterasi++;
    }

    public void HitungFitness() {
        for (int i = 0; i < getParent().length; i++) {
            parent[i] = Pelanggaran.eksekusiAturan(parent[i]);
        }
    }

    public void Crossover() {
    }

    public void Mutasi() {
    }

    /**
     * @return the parent
     */
    public Kromosom[] getParent() {
        return parent;
    }

    /**
     * @param parent the parent to set
     */
    public void setParent(Kromosom[] parent) {
        this.parent = parent;
    }

    /**
     * @return the iterasi
     */
    public int getIterasi() {
        return iterasi;
    }

    /**
     * @param iterasi the iterasi to set
     */
    public void setIterasi(int iterasi) {
        this.iterasi = iterasi;
    }

    public void cetakSolusi() {
        solusiAwalIterasi();
        HitungFitness();
        
        for (int i = 0; i < parent.length; i++) {
            for (int j = 0; j < parent[i].getData().length; j++) {
//            for (int j = 0; j < 1; j++) {
                System.out.println("Gen[" + i + "]");
                System.out.println("Index "+j);
                System.out.println("idKelas     : " + parent[i].getData()[j].getTimeSlot().getIdKelas());
                System.out.println("kodeMatkul  : " + parent[i].getData()[j].getTimeSlot().getIdMK().getIdMK()+" - "+parent[i].getData()[j].getTimeSlot().getIdDosen().idDosen);
                System.out.println("kelas       : " + parent[i].getData()[j].getTimeSlot().getKelas());
                System.out.println("hari        : " + parent[i].getData()[j].getHari());
                System.out.println("ruang       : " + parent[i].getData()[j].getRuang().getIdRuang());
                System.out.println("jam ke      : " + parent[i].getData()[j].getJam());
                System.out.println("Semester    : " + parent[i].getData()[j].getTimeSlot().getIdMK().getSemester());
                System.out.println("FITNES      : " + parent[i].getData()[j].getNilaiFitness());
                System.out.println("");

            }
            System.out.println("------------------------------------------------------------------------------------");
        }
    }
    public static void main(String[] args) {
        Populasi pop = new Populasi();
        pop.cetakSolusi();
    }
}
