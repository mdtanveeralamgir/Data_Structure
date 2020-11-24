package Heap;

public class MaxHeap {
    private Node[] heapArray;
    private int maxSize;
    private int currentSize;

    public MaxHeap(int sizeOfHeap){
        this.maxSize = sizeOfHeap;
        this.currentSize = 0;
        heapArray = new Node[this.maxSize];
    }

    public int getSize(){
        return this.currentSize;
    }

    public boolean isEmpty(){
        return this.currentSize == 0;
    }

    public boolean insert(int data){
        if(this.currentSize == this.maxSize)
            return false;
        Node newNode = new Node(data);
        heapArray[this.currentSize] = newNode;
        this.trickleUp(this.currentSize);
        this.currentSize++;
        return true;
    }

    public void trickleUp(int currentSize){
        if(currentSize == 0)
            return;
        double parentDataIndex =  (2 * currentSize);
        parentDataIndex = Math.floor(parentDataIndex/2);

    }




}
