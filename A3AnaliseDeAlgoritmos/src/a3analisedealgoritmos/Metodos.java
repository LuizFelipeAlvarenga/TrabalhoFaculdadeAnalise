package a3analisedealgoritmos;
import java.util.Arrays;
import java.util.Random;

public class Metodos {
    long trocasQuick = 0;
    long trocasMerge = 0;
    long compQuick = 0;
    long compMerge = 0;
    long inicioQuick, fimQuick, inicioMerge, fimMerge;
        
    public int[] numerar(int tamanho){
        int[] vetor = new int[tamanho];
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = i+1;           
        }        
        return vetor;
    }
    
    public int[] numerarInverso(int tamanho){
        int[] vetor = new int[tamanho];

        for (int i = 0; i < vetor.length; i++) {
            int x = vetor.length - i;
            vetor[i] = x;            
        }
        return vetor;
    }
    
    public int[] desordenar(int... vetor){
        Random rdm = new Random();
        for (int i = vetor.length-1; i > 0; i--) {
            int j = rdm.nextInt(i+1);
            int temp = vetor[i];
            vetor[i] = vetor [j];
            vetor[j] = temp;            
        }
        return vetor;
    }
    
    public void bubble(int... vetor){
        long trocas = 0;
        long comp = 0;
        long inicio = System.nanoTime();
        for (int j = 0; j < vetor.length; j++) {
            for(int i = 0; i<vetor.length-1;i++){
                comp++;
                if((vetor[i]>vetor[i+1])&&(i+1<vetor.length)){
                    int temp = vetor[i+1];
                    vetor[i+1] = vetor[i];
                    vetor[i] = temp;              
                    trocas++;
                }
            }                         
        }
        //System.out.println(Arrays.toString(vetor));
        long fim = System.nanoTime();
        long tempo = (fim - inicio);
        System.out.println("Trocas: " + trocas);
        System.out.println("Comparações: " + comp);
        System.out.println("Tempo: " + tempo + "ns");
    }
    
    public void selection(int... vetor){
       int temp;
       long trocas = 0;
       long comp = 0;
       long inicio = System.nanoTime();
       for (int i = 0; i <vetor.length; i++){
            int j = i;
            for (int x = i; x <vetor.length; x++){
                comp++;
                if (vetor[x] < vetor[j]){
                   j = x;
                }
           }
           temp = vetor[i];
           vetor[i] = vetor[j];
           vetor[j] = temp;
           trocas++;
       }
       //System.out.println(Arrays.toString(vetor));
       long fim = System.nanoTime();
       long tempo = (fim - inicio);
       System.out.println("Trocas: " + trocas);
       System.out.println("Comparações: " + comp);
       System.out.println("Tempo: " + tempo + "ns");
       
    }

    public void insertion(int... vetor) {
        long inicio = System.nanoTime();
        long trocas = 0;
        long comp = 0;
        for (int i = 1; i < vetor.length; i++) {
            int j = i;
            int b = vetor[i];
            comp++;
            while (j > 0 && vetor[j - 1] > b) {
                vetor[j] = vetor[j - 1];
                j--;
                trocas++;
            }
            vetor[j] = b;
        }
        //System.out.println(Arrays.toString(vetor));
        long fim = System.nanoTime();
        long tempo = (fim - inicio);
        System.out.println("Trocas: " + trocas);
        System.out.println("Comparações: " + comp);
        System.out.println("Tempo: " + tempo + "ns");
    }

    public void quick(int[] vetor, int esq, int dir){
        if(trocasQuick==0){
         inicioQuick = System.nanoTime();
        }
        if (esq < dir){            
            int pivo = particao(vetor, esq, dir);            
            quick(vetor, esq, pivo);            
            quick(vetor, pivo+1, dir); 
            
        }
        fimQuick = System.nanoTime();
    }

    public int particao(int [] vetor, int esq, int dir){
        int pivo = vetor[(esq+dir)/2];
        int aux;
        int i = esq - 1;
        int j = dir + 1;        

        while(true){
            do{
                i++;
                this.compQuick++;
            }while(vetor[i] < pivo);
            do{
                j--;
                this.compQuick++;
            }while(vetor[j] > pivo);
            if(i >= j){
                return j; 
            }
            aux = vetor[i];
            vetor[i] = vetor[j];
            vetor[j] = aux;
            this.trocasQuick++;
        }        
    }
    
    public void quickToString(){
        //System.out.println(Arrays.toString(vetor));
        System.out.println("Trocas: " + trocasQuick);
        System.out.println("Comparações: " + compQuick);
        System.out.println("Tempo: " + (fimQuick - inicioQuick) + "ns");
    }

    public void merge(int[] vetor){
        if(trocasMerge==0){
            inicioMerge = System.nanoTime();
        }

        int tamanho = vetor.length;
        int meio = tamanho/2;
        int[] esquerda = new int[meio];
        int[] direita = new int[tamanho - meio];

        if(tamanho < 2){
            return;
        }

        // Populando as duas metades
        System.arraycopy(vetor, 0, esquerda, 0, meio);
        if (tamanho - meio >= 0) System.arraycopy(vetor, meio, direita, 0, tamanho - meio);

        merge(esquerda);
        merge(direita);
        intercalar(vetor, esquerda, direita);
        fimMerge = System.nanoTime();
    }

    private void intercalar (int[] vetor, int[] esquerda, int[] direita){
        int tamEsq = esquerda.length;
        int tamDir = direita.length;
        int i = 0, j = 0, k = 0;

        while(i < tamEsq && j < tamDir){
            if(esquerda[i] <= direita[j]){
                vetor[k] = esquerda[i];
                i++;
                trocasMerge++;
            }
            else{
                vetor[k] = direita[j];
                j++;
            }
            compMerge++;
            k++;
        }
        while(i < tamEsq){
            vetor[k] = esquerda[i];
            trocasMerge++;
            i++;
            k++;
        }
        while(j < tamDir){
            vetor[k] = direita[j];
            trocasMerge++;
            j++;
            k++;
        }
    }

    public void mergeToString(){
        //System.out.println(Arrays.toString(vetor));
        System.out.println("Trocas: " + trocasMerge);
        System.out.println("Comparações: " + compMerge);
        System.out.println("Tempo: " + (fimMerge - inicioMerge) + "ns");
    }

    private void resetTroComp(){
        trocasQuick = 0;
        compQuick = 0;
        trocasMerge = 0;
        compMerge = 0;
    }

    public void testarSort(int metodo, int[] vetor){
        int[] array = vetor.clone();
        System.out.println("[ Vetor tamanho " + array.length + " ]");

        switch (metodo){
            case 0:
                bubble(array);
                break;
            case 1:
                selection(array);
                break;
            case 2:
                insertion(array);
                break;
            case 3:
                quick(array, 0, array.length-1);
                quickToString();
                break;
            case 4:
                merge(array);
                mergeToString();
                break;
            default:
                System.out.println("Método Inválido.");
                break;
        }
        resetTroComp();
    }

}
