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
        Heap[0] = null;
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
        if(pos >= (size/2) && pos <= size) return true;
        return false;
    }
    
    private void swap(int fpos, int spos){
        Archivo tmp;
        tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }
    
    private void maxHeapify(int pos){
        if(!isLeaf(pos)){
            if(Heap[pos].prioridad < Heap[leftChild(pos)].prioridad || Heap[pos].prioridad < Heap[rightChild(pos)].prioridad){
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
        Heap[++size] = Element;
        int current = size;
        
        while(Heap[current].prioridad > Heap[parent(current)].prioridad){
            swap(current,parent(current));
            current = parent(current);
        }
    }
    
    public void print(){
        for(int i = 1; i<= size/2; i++){
            System.out.print(" Valor padre: " + Heap[i] + " Hijo izquierdo: " + Heap[2*i] + " Hijo Derecho: "+ Heap[2*1+1]);
            System.out.println();
        }
    }
    
    public void maxheap(){
        for(int pos = (size/2); pos >= 1; pos--){
            maxHeapify(pos);
        }
    }
    
    public Archivo remove(){
        Archivo popped = Heap[FRONT];
        Heap[FRONT] = Heap[size--];
        maxHeapify(FRONT);
        return popped;
    }
    
    
}
