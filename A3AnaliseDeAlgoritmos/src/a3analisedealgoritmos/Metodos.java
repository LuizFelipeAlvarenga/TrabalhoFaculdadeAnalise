package a3analisedealgoritmos;
import java.util.Arrays;
import java.util.Random;

public class Metodos {
    static int trocaQuick = 0;
    static long inicioQuick;
    static long fimQuick;
    

    public static int getTrocaQuick() {
        return trocaQuick;
    }
    
    public static long getTempoQuick() {
        return fimQuick - inicioQuick;
    }
    
    public static  int[] numerar(int... vetor){        
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = i+1;           
        }        
        return vetor;
    }
    
    public static  int[] numerarInveso(int... vetor){
        for (int i = 0; i < vetor.length; i++) {
            int x = vetor.length - i;
            vetor[i] = x;            
        }
        return vetor;
    }
    
    public static  int[] desordenado(int... vetor){
        Random rdm = new Random();
        for (int i = vetor.length-1; i > 0; i--) {
            int j = rdm.nextInt(i+1);
            int temp = vetor[i];
            vetor[i] = vetor [j];
            vetor[j] = temp;            
        }
        return vetor;
    }
    
    public static  void bubble(int... vetor){
        int trocas = 0;
        long inicio = System.nanoTime();
                for (int j = 0; j < vetor.length; j++) {
            for(int i = 0; i<vetor.length-1;i++){
                if(vetor[i]>vetor[i+1]){
                    int temp = vetor[i+1];
                    vetor[i+1] = vetor[i];
                    vetor[i] = temp;              
                    trocas++;
                }
            }                         
    }
                System.out.println(Arrays.toString(vetor)); 
                long fim = System.nanoTime();
                long tempo = (fim - inicio);
                System.out.println("O numero de trocas foi " + trocas);
                System.out.println("Tempo: " + tempo + "ns");
  }
    
    public static  void selection(int... vetor){        
       int temp;
       int trocas = 0;
       long inicio = System.nanoTime();
       for (int i = 0; i <vetor.length; i++){
            int j = i;
            for (int x = i; x <vetor.length; x++){
                if (vetor[x] < vetor[j]){
                   j = x;
                }
           }
           temp = vetor[i];
           vetor[i] = vetor[j];
           vetor[j] = temp;
           trocas++;
       }
       System.out.println(Arrays.toString(vetor));
       long fim = System.nanoTime();
       long tempo = (fim - inicio);
       System.out.println("O numero de trocas foi " + trocas);
       System.out.println("Tempo: " + tempo + "ns");
       
    }

    public static void insertion(int... vetor) {
        long inicio = System.nanoTime();
        int trocas = 0;
        for (int i = 1; i < vetor.length; i++) {
            int j = i;
            int b = vetor[i];
            while (j > 0 && vetor[j - 1] > b) {
                vetor[j] = vetor[j - 1];
                j--;
                trocas++;
            }
            vetor[j] = b;
        }
        System.out.println(Arrays.toString(vetor));
        long fim = System.nanoTime();
        long tempo = (fim - inicio);
        System.out.println("O número de trocas foi " + trocas);
        System.out.println("Tempo: " + tempo + "ns");
    }


    public static void quick(int[] vetor, int esq, int dir){        
        if(trocaQuick==0){
         inicioQuick = System.nanoTime();
        }
        if (esq < dir){            
            int pivo = particao(vetor, esq, dir);            
            quick(vetor, esq, pivo);            
            quick(vetor, pivo+1, dir); 
            
        }
        fimQuick = System.nanoTime();
        
    }

    public static int particao(int [] vetor, int esq, int dir){
        int pivo = vetor[(esq+dir)/2];
        int aux;
        int i = esq - 1;
        int j = dir + 1;        

        while(true){
            do{
                i++;   
            }while(vetor[i] < pivo);
            do{
                j--;    
            }while(vetor[j] > pivo);
            if(i >= j){
                return j; 
            }
            aux = vetor[i];
            vetor[i] = vetor[j];
            vetor[j] = aux;
            trocaQuick++;             
        }        
    }

    public static void merge(int inicio, int tamanho, int[] vetor) {
        int[] info = new int [2];
        
        if (inicio < tamanho - 1) {
            int meio = (inicio + tamanho) / 2;
            merge(inicio, meio, vetor);
            merge(meio, tamanho, vetor);
            intercalar(inicio, meio, tamanho, vetor);
        }
    }
 
    private static void intercalar(int inicio, int meio, int tamanho, int[] vetor) {
        int i, j, k;
        int[] auxiliar = new int[tamanho - inicio];
        i = inicio;
        j = meio;
        k = 0;
        while (i < meio && j < tamanho) {
            if (vetor[i] <= vetor[j]) { 
                auxiliar[k] = vetor[i];
                k++; i++;
            } else {
                auxiliar[k] = vetor[j];
                k++; j++;
            }
        }
        while (i < meio) {
            auxiliar[k] = vetor[i];
            k++; i++;
        }
        while (j < tamanho) {
            auxiliar[k] = vetor[j];
            k++; j++;
        }
        for (i = inicio; i < tamanho; i++) {
            vetor[i] = auxiliar[i - inicio];
        }
    }

}
