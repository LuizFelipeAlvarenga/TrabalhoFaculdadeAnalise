package a3analisedealgoritmos;

import java.util.Arrays;

public class A3AnaliseDeAlgoritmos {

    public static void main(String[] args) {
        Metodos met = new Metodos();
        int [] teste = {2,1};
        int[] vc = new int[100];
        int[] vm = new int[1000];
        int[] vdm = new int[10000];
        int[] vcm = new int[100000];
        int[] vM = new int[1000000];


        vc = met.numerarInverso(vc);
        vc = met.desordenado(vc);
        /*
        System.out.println(Arrays.toString(vdm));
        System.out.println(" ");
        met.quick(vdm,0,vdm.length-1);
        met.quickToString(vdm);
        */

        //met.merge(0, vc.length-1,vc);
        met.merge(teste);
        System.out.println("Trocas: "+ met.trocasMerge + "\nComparações: " + met.compMerge);
        System.out.println(Arrays.toString(teste));

    
    
    
    }   
}
