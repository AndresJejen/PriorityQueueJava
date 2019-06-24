

/*
1
5 0
1 1 9 1 1
*/


package priotityqueueapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author gjejen
 */
public class PriotityQueueApp  {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        // TODO code application logic here
        System.out.println(" Consultado el valor máximo");
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        int n, m;
        
        System.out.println("Valor de T " + T);
        
        for (int i  = 0; i<T;i++){
            
           String line = br.readLine();
           String[] palabras=line.split(" ");
           n=Integer.parseInt(palabras[0].trim());
           m=Integer.parseInt(palabras[1].trim());
           
           String num = br.readLine();
           String[] numeros=num.split(" ");
           
           MaxHeap maxHeap = new MaxHeap(n);
             
           System.out.println("insert ");
            for (int cont = 0; cont < n; cont++){
                
                int value = Integer.parseInt(numeros[cont].trim());
                System.out.println(value);
                maxHeap.insert(new Archivo(cont,value));
            }
            System.out.println("-------------------");
            
            System.out.println("Arbol");
            maxHeap.print();
            System.out.println("-----------");
            
            maxHeap.maxheap();
           
            Archivo[] ordenado = new Archivo[n];
            
            for(int w = 0; w<n;w++){
                
                System.out.println("- - - - - - - - - Sacar - - - - - - - - -");             
                ordenado[w] = maxHeap.remove();
                System.out.println("Retirado Prioridad " + ordenado[w].prioridad + " Entrada " + ordenado[w].ordenLlegada);
                System.out.println("Arbol");
                maxHeap.print();
                System.out.println("-----------------------------------------");
                //maxHeap.maxheap();
            }
            System.out.println("---------------------");
            
            for(int w = 0; w<n;w++){
                if(ordenado[w].ordenLlegada == m ){
                    System.out.println("Resultado ");
                    System.out.println(w+1);
                    break;
                }
            }
            
            
            
        }
    }
}
