package a3analisedealgoritmos;

import java.util.Arrays;

public class A3AnaliseDeAlgoritmos {

    public static void main(String[] args) {
        Metodos met = new Metodos();
        int[][][] listas = new int[3][5][];
        String[] nomes = {"ordenadas: crescente", "ordenadas: decrescente", "desordenadas"};
        String[] nomeMetodo = {"Bubble", "Selection", "Insertion", "Quick", "Merge"};

        for (int i = 2; i < 7; i++) {
            listas[0][i - 2] = met.numerar((int) Math.pow(10, i));
            listas[1][i - 2] = met.numerarInverso((int) Math.pow(10, i));
            listas[2][i - 2] = met.numerar((int) Math.pow(10, i));
            listas[2][i - 2] = met.desordenar(listas[2][i - 2]);
        }


        for (int x = 0; x < 5; x++) {
            System.out.println("\n<< " + nomeMetodo[x] + " Sort >>\n");
            for (int i = 0; i < 3; i++) {
                System.out.println("\n-- Listas "+nomes[i]+" --\n");
                for (int j = 0; j < 5; j++) {
                    met.testarSort(x, listas[i][j]);
                    System.out.println();
                }
            }
        }


    }
}
