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
    int indexSolusi = 0;
    int[] score = new int[4];

    public void solusiAwalIterasi() {
        for (int i = 0; i < parent.length; i++) {
            parent[i] = new Kromosom().solusiAwal();
        }
        iterasi++;
    }

    public void EvaluasiFitness() {
        for (int i = 0; i < getParent().length; i++) {
            parent[i] = Pelanggaran.eksekusiAturan(parent[i]);
            N_fitness[i] = 0;
            for (int j = 0; j < parent[i].getData().length; j++) {
                N_fitness[i] = N_fitness[i] + parent[i].getData()[j].getNilaiFitness();
            }
//            System.out.println(N_fitness[i]); //tampilkan nilai fitnes kromosom ke i
        }
    }

    public void kriteriaBerhenti() {
        for (int i = 0; i < parent.length; i++) {
            for (int j = 0; j < parent[i].data.length; j++) {
                if (parent[i].data[j].getNilaiFitness() != 0) {
                    score[i] = score[i] + parent[i].data[j].getNilaiFitness();
                } else {
                    score[i] = score[i];
                }
            }
            if (score[i] == 0) {
                indexSolusi = i;
            }
        }
    }

    public void cetak() {
        for (int i = 0; i < parent.length; i++) {
            for (int j = 0; j < parent[i].getData().length; j++) {
                if (j == 110) {
//                    System.out.print(" ||||| " + parent[i].getData()[j].getAllele().getIdKelas() + " ");
                    System.out.print(parent[i].getData()[j].getAllele().getIdKelas() + " ");
                } else {
                    System.out.print(parent[i].getData()[j].getAllele().getIdKelas() + " ");
                }
            }
            System.out.println("");
        }
    }
//    public void cetak() {
//        for (int i = 2; i < 3; i++) {
//            for (int j = 0; j < parent[i].getData().length; j++) {
//                if (j == 110) {
////                    System.out.print(" ||||| " + parent[i].getData()[j].getAllele().getIdKelas() + " ");
//                    System.out.println(parent[i].getData()[j].getAllele().getIdKelas());
//                } else {
//                    System.out.println(parent[i].getData()[j].getAllele().getIdKelas());
//                }
//            }
////            System.out.println("");
//        }
//    }

    public void RouleteWheelSelection() {
        for (int iterasi = 0; iterasi <= score.length - 2; iterasi++) {//selection Sort Method
            int minIndex = iterasi;
            for (int elemen = iterasi + 1; elemen <= score.length - 1; elemen++) {
                if (score[elemen] < score[minIndex]) {
                    minIndex = elemen;
                }
            }
            Kromosom temp = parent[iterasi];
            parent[iterasi] = parent[minIndex];
            parent[minIndex] = temp;

            int temp1 = score[iterasi];
            score[iterasi] = score[minIndex];
            score[minIndex] = temp1;
        }

        for (int i = 0; i < score.length; i++) { //reset score
            score[i] = 0;
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
        EvaluasiFitness();
        kriteriaBerhenti();
//        cetak();
        while (indexSolusi == 0) {
            iterasi++;
//            System.out.println(iterasi);
            RouleteWheelSelection();
            parent = Genetika.crossover(parent);
            parent = Genetika.Mutasi(parent);
            EvaluasiFitness();
            kriteriaBerhenti();
        }
//        for (int i = 0; i < parent.length; i++) {
//            iterasi++;
//            System.out.println(iterasi);
//            RouleteWheelSelection();
//            parent = Genetika.crossover(parent);
//            parent = Genetika.Mutasi(parent);
//            EvaluasiFitness();
//            kriteriaBerhenti();
//        }
//        cetak();
        System.out.println("Solusi : "+indexSolusi);
        System.out.println("Selama : "+iterasi+" iterasi");

//        for (int i = 0; i < parent.length; i++) { // parent.length
            for (int j = 0; j < parent[indexSolusi].getData().length; j++) {
                System.out.println("Gen[" + indexSolusi + "]");
                System.out.println("Index "+j);
                System.out.println("idKelas     : " + parent[indexSolusi].getData()[j].getAllele().getIdKelas());
                System.out.println("kodeMatkul  : " + parent[indexSolusi].getData()[j].getAllele().getIdMK().getIdMK()+" - "+parent[indexSolusi].getData()[j].getAllele().getIdDosen().idDosen);
                System.out.println("kelas       : " + parent[indexSolusi].getData()[j].getAllele().getKelas());
                System.out.println("hari        : " + parent[indexSolusi].getData()[j].getHari());
                System.out.println("ruang       : " + parent[indexSolusi].getData()[j].getRuang().getIdRuang());
                System.out.println("jam ke      : " + parent[indexSolusi].getData()[j].getJam());
                System.out.println("Semester    : " + parent[indexSolusi].getData()[j].getAllele().getIdMK().getSemester());
                System.out.println("FITNES      : " + parent[indexSolusi].getData()[j].getNilaiFitness());
                System.out.println("");

            }
//            System.out.println("------------------------------------------------------------------------------------");
//        }
//        for (int i = 2; i < 3; i++) { // parent.length
//            for (int j = 0; j < parent[i].getData().length; j++) {
//                System.out.println(parent[i].getData()[j].getRuang().getIdRuang());
//            }
//        }
    }

    public static void main(String[] args) {
        Populasi pop = new Populasi();
        pop.prosesGenetika();
    }
}
