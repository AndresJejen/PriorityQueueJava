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
public class MaxHeap {
    
    private Archivo[] Heap;
    private int size;
    private int maxsize;
    
    private static final int FRONT = 1;
    
    public MaxHeap(int maxsize){
        this.maxsize = maxsize;
        this.size = 0;
        Heap = new Archivo[this.maxsize + 1];
        Heap[0] = new Archivo(-1,Integer.MAX_VALUE);
    }
    
    private int parent(int pos){
        return pos/2;
    }
    
    private int leftChild(int pos){
        return (2*pos);
    }
    
    private int rightChild(int pos){
           return (2*pos)+1;
    }
    
    private boolean isLeaf(int pos){
        if(pos > (size/2) && pos <= size) return true;
        return false;
    }
    
    private void swap(int fpos, int spos){
        Archivo tmp;
        tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }
    
    private void maxHeapify(int pos){
        
        //System.out.println("Padre Prioridad " + Heap[pos].prioridad + " entrada " + Heap[pos].ordenLlegada);
        //System.out.println("left Prioridad " + Heap[leftChild(pos)].prioridad + " entrada " + Heap[leftChild(pos)].ordenLlegada);
        //System.out.println("right Prioridad " + Heap[rightChild(pos)].prioridad + " entrada " + Heap[rightChild(pos)].ordenLlegada);
        
        
        System.out.println("Arbol en maxheapify");
        print();
        System.out.println("-----------");
        
        
        if(!isLeaf(pos)){
            if(Heap[pos].prioridad < Heap[leftChild(pos)].prioridad || Heap[pos].prioridad < Heap[rightChild(pos)].prioridad){
                
                System.out.println(" - Imprimiendo Heapify - ");
                System.out.println("Padre: " + Heap[pos].prioridad);
                System.out.println("Left:  " + Heap[leftChild(pos)].prioridad);
                System.out.println("Right: " + Heap[rightChild(pos)].prioridad);
                System.out.println(" -      Fin Heapify    - ");
                
                if(Heap[leftChild(pos)].prioridad > Heap[rightChild(pos)].prioridad){
                    swap(pos,leftChild(pos));
                    maxHeapify(leftChild(pos));
                }
                else{
                    swap(pos,rightChild(pos));
                    maxHeapify(rightChild(pos));
                }
            }
        }
    }
    
    public void insert(Archivo Element){
        
        System.out.println("El Archivo tiene prioridad " + Element.prioridad + " entrada: " + Element.ordenLlegada);
        
        // System.out.println("Antes " + size);
        Heap[++size] = Element;
        // System.out.println("Despues " + size);
        
        int current = size;
        
        while(Heap[current].prioridad > Heap[parent(current)].prioridad){
            swap(current,parent(current));
            current = parent(current);
        }
    }
    
    public void print(){
        for(int i = 1; i<= size/2; i++){
            System.out.println(" Valor padre: " + Heap[i].prioridad + " entrada: " + Heap[i].ordenLlegada );
            System.out.println(" Hijo izquierdo: " + Heap[2*i].prioridad + " entrada: " + Heap[2*i].ordenLlegada);
            System.out.println(" Hijo Derecho: "+ Heap[2*i+1].prioridad + " entrada: " + Heap[2*i+1].ordenLlegada);
            System.out.println();
        }
    }
    
    public void maxheap(){
        for(int pos = (size/2); pos >= 1; pos--){
            maxHeapify(pos);
        }
    }
    
    public Archivo remove(){
        Archivo popped = new Archivo(Heap[FRONT].ordenLlegada,Heap[FRONT].prioridad);
        
        
        System.out.println("Último - Size: " + size);
        System.out.println("Prioridad: " + Heap[size].prioridad + " Entrada: " + Heap[size].ordenLlegada + "\n - - - \n");
              
        
        Heap[FRONT].ordenLlegada = Heap[size].ordenLlegada;
        Heap[FRONT].prioridad = Heap[size].prioridad;
        Heap[size].prioridad = Integer.MIN_VALUE;
        size--;
        maxHeapify(FRONT);
        return popped;
    }
    
    
}
