/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package priotityqueueapp;

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
        
        MaxHeap maxHeap = new MaxHeap(15);
        
        maxHeap.insert(15);
        maxHeap.insert(36);
        maxHeap.insert(17);
        maxHeap.insert(18);
        maxHeap.insert(84);
        maxHeap.insert(79);
        maxHeap.insert(65);
        maxHeap.insert(92);
        maxHeap.insert(19);
        
        maxHeap.maxheap();
        
        maxHeap.print();
        
        System.out.println("El valor máximo es " + Integer.toString(maxHeap.remove()) );
        
        
        
    }
    
}
