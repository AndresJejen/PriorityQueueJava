/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package priotityqueueapp;

import java.util.Scanner;

/**
 *
 * @author gjejen
 */
public class PriotityQueueApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // TODO code application logic here
        System.out.println(" Consultado el valor máximo");
        
        Scanner inp = new Scanner(System.in);
        
        int T = inp.nextInt();
        
        for (int i  = 0; i<T;i++){
            String[] nmx = inp.nextLine().split(" ");

            int n = Integer.parseInt(nmx[0].trim());

            int m = Integer.parseInt(nmx[1].trim());

            MaxHeap maxHeap = new MaxHeap(n);
            
            String[] datos = inp.nextLine().split(" ");
            
            for (int j = 0; j < n; j++){
                maxHeap.insert(new Archivo(j,Integer.parseInt(nmx[j].trim())));
            }
            
            maxHeap.maxheap();
            
            //maxHeap.print();
            
            Archivo[] ordenado = new Archivo[n];
            
            for(int w = 0; w<n;w++){
                ordenado[w] = maxHeap.remove();
            }
        
            for(int w = 0; w<n;w++){
                if(ordenado[w].ordenLlegada == m ){
                    System.out.println(w+1);
                    break;
                }
            }
            
            
            
        }
    }
}
