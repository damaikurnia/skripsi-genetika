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
public class Genetika {
//        public void routleWheelSelection() {
////        for (int i = 0; i < parent.length; i++) {
////            Kromosom kromosom = parent[i];
////            
////        }
//
//        for (int i = 1; i < N_fitness.length; i++) { //sorting routel wheel selection
//            for (int j = 0; j < (N_fitness.length - i); j++) {
//                if (N_fitness[j] > N_fitness[j + 1]) {
//                    Kromosom temp = parent[j];
//                    int temp_n = N_fitness[j];
//                    parent[j] = parent[j + 1];
//                    N_fitness[j] = N_fitness[j + 1];
//                    parent[j + 1] = temp;
//                    N_fitness[j + 1] = temp_n;
//                }
//
//            }
//        }
//    }

    public static Kromosom[] crossover(Kromosom parent1, Kromosom parent2) {
//        routleWheelSelection();
        Kromosom[] child = new Kromosom[2];
        child[0] = parent1;
        child[1] = parent2;
        Gen[] temp1;

        int point = parent1.getData().length / 2;
        int count = parent1.getData().length;

        for (int j = 0; j < child.length; j++) {
            for (int i = 0; i < count; i++) { //one point crossover
                if (i == 110) {
                    System.out.print("___" + child[j].data[i].getAllele().getIdKelas() + "  ");
                } else {
                    System.out.print(child[j].data[i].getAllele().getIdKelas() + "  ");
                }
            }
            System.out.println("");
        }
        for (int i = 0; i < child.length; i++) {
            temp1 = child[i].data;
            for (int j = 0; j < count; j++) { //one point crossover
                if (i == 0) {
                    if (j >= point) {
                        temp1[j] = parent2.data[j];
                    } else {
                        temp1[j] = temp1[j];
                    }
                } else {
                    if (j >= point) {
                        temp1[j] = parent1.data[j];
                    } else {
                        temp1[j] = temp1[j];
                    }
                }
//                child[i].getData()[j].setNilaiFitness(0);
            }
            child[i].setData(temp1);
        }

        for (int j = 0; j < child.length; j++) {
            for (int i = 0; i < count; i++) { //one point crossover
                if (i == 110) {
                    System.out.print("___" + child[j].data[i].getAllele().getIdKelas() + "  ");
                } else {
                    System.out.print(child[j].data[i].getAllele().getIdKelas() + "  ");
                }
            }
            System.out.println("");
        }
//        N_fitness[parent.length - 2] = 0;
//        N_fitness[parent.length - 1] = 0;
        return child;
    }

    public void Mutasi() {
    }

}
