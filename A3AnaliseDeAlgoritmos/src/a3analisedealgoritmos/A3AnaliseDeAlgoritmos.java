package a3analisedealgoritmos;

import java.util.Arrays;

public class A3AnaliseDeAlgoritmos {

    public static void main(String[] args) {
    Metodos met = new Metodos();
    int[] vc = new int[100];
    int[] vm = new int[1000];
    int[] vdm = new int[10000];
    int[] vcm = new int[100000];
    int[] vM = new int[1000000];
    
    vcm = met.numerarInveso(vcm);
    vcm = met.desordenado(vcm);
    System.out.println(Arrays.toString(vcm));
    System.out.println(" ");
    met.quick(vcm, 0, vcm.length - 1);
        System.out.println(Arrays.toString(vcm));
        System.out.println(met.getTrocaQuick());
        System.out.println(met.getTempoQuick());
    }
    
}
