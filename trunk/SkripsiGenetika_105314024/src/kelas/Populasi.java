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

    Kromosom[] parent = new Kromosom[4];//satu populasi terdiri dari 4 kromosom
    int[] N_fitness = new int[4];
    int iterasi = 0;

    public void solusiAwalIterasi() {
        for (int i = 0; i < parent.length; i++) {
            parent[i] = new Kromosom().solusiAwal();
        }
        iterasi++;
    }

    public void HitungFitness() {
        for (int i = 0; i < getParent().length; i++) {
            parent[i] = Pelanggaran.eksekusiAturan(parent[i]);
            N_fitness[i] = 0;
            for (int j = 0; j < parent[i].getData().length; j++) {
                N_fitness[i] = N_fitness[i] + parent[i].getData()[j].getNilaiFitness();
            }
//            System.out.println(N_fitness[i]); //tampilkan nilai fitnes kromosom ke i
        }
    }

    public void cetak() {
        for (int i = 0; i < parent.length; i++) {
            for (int j = 0; j < parent[i].getData().length; j++) {
                if (j == 110) {
                    System.out.print(" ||||| " + parent[i].getData()[j].getAllele().getIdKelas() + "    ");
                } else {
                    System.out.print(parent[i].getData()[j].getAllele().getIdKelas() + "    ");
                }
            }
            System.out.println("");
        }
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

    public void prosesGenetika() {
        solusiAwalIterasi();
        HitungFitness();
//        cetak();
        parent = Genetika.crossover(parent);
        System.out.println("");
        cetak();
        System.out.println("MUTASI");
        parent = Genetika.Mutasi(parent);
//        cetak();
//        System.out.println("------");
//        routleWheelSelection();

//        for (int i = 0; i < parent.length; i++) { // parent.length
//            for (int j = 110; j < parent[i].getData().length; j++) {
////            for (int j = 0; j < 1; j++) {
//                System.out.println("Gen[" + i + "]");
//                System.out.println("Index "+j);
//                System.out.println("idKelas     : " + parent[i].getData()[j].getAllele().getIdKelas());
//                System.out.println("kodeMatkul  : " + parent[i].getData()[j].getAllele().getIdMK().getIdMK()+" - "+parent[i].getData()[j].getAllele().getIdDosen().idDosen);
//                System.out.println("kelas       : " + parent[i].getData()[j].getAllele().getKelas());
//                System.out.println("hari        : " + parent[i].getData()[j].getHari());
//                System.out.println("ruang       : " + parent[i].getData()[j].getRuang().getIdRuang());
//                System.out.println("jam ke      : " + parent[i].getData()[j].getJam());
//                System.out.println("Semester    : " + parent[i].getData()[j].getAllele().getIdMK().getSemester());
//                System.out.println("FITNES      : " + parent[i].getData()[j].getNilaiFitness());
//                System.out.println("");
//
//            }
//            System.out.println("------------------------------------------------------------------------------------");
//        }
    }

    public static void main(String[] args) {
        Populasi pop = new Populasi();
        pop.prosesGenetika();
    }
}
