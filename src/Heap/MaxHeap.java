package Heap;
import java.util.Arrays;

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

    //insert a new node
    public boolean insert(int data){
        if(this.currentSize == this.maxSize)
            return false;
        Node newNode = new Node(data);
        heapArray[this.currentSize] = newNode;
        this.trickleUp(this.currentSize);
        this.currentSize++;
        return true;
    }

    //remove a node
    public boolean remove(int data){
        boolean result = false;
        for(int i = 0; i < this.currentSize; i++){
            if(data == heapArray[i].getData()){
                heapArray[i].setData(heapArray[this.currentSize - 1].getData());
                this.currentSize--;
                this.trickleDown(i);
                result = true;
            }
        }
        return result;
    }

    public void trickleDown(int currIndex){
        if(currIndex >= this.currentSize)
            return;
        int dataToCompare = this.heapArray[currIndex].getData();
        if((2 * currIndex + 1) <= this.currentSize){
            int leftChild = this.heapArray[2 * currIndex + 1].getData();
            if((2 * currIndex + 2) <= this.currentSize){
               int rightChild = this.heapArray[2 * currIndex + 2].getData();
               if(rightChild > leftChild && dataToCompare < rightChild){
                    this.heapArray[currIndex].setData(rightChild);
                    this.heapArray[2 * currIndex + 2].setData(dataToCompare);
                    this.trickleDown(2 * currIndex + 2);
               }
            }
            if(dataToCompare < leftChild){
                this.heapArray[currIndex].setData(leftChild);
                this.heapArray[2 * currIndex + 2].setData(dataToCompare);
                this.trickleDown(2 * currIndex + 1);
            }
        }

//        int smallerChild = leftChild < rightChild ? leftChild : rightChild;
    }
    public void trickleUp(int currSize){
        if(currSize == 0)
            return;
        int parentDataIndex =  (currSize - 1);
        parentDataIndex = (int)(parentDataIndex/2);
//        System.out.println(parentDataIndex);
        if(heapArray[parentDataIndex].getData() < heapArray[currSize].getData()){
            int temp = heapArray[parentDataIndex].getData();
            heapArray[parentDataIndex].setData(heapArray[currSize].getData());
            heapArray[currSize].setData(temp);
            this.trickleUp(parentDataIndex);
        }
    }

    public void printFinalResult(){
//        for(Node x : heapArray){
//            System.out.print(x.getData());
//            System.out.print(',' + ' ');
//        }
        for(int i = 0; i < this.currentSize; i++){
            System.out.println(heapArray[i].getData());
//            System.out.print(',' + ' ');
        }
    }




}
