package Heap;

import DataStructure.BinarySearchTree;

public class main {

    public static void main(String[] args) {
        MaxHeap mh = new MaxHeap(10);
        mh.insert(5);
        mh.insert(6);
        mh.insert(7);
        mh.insert(4);
        mh.insert(9);
        mh.insert(10);
        mh.insert(3);
        mh.remove(10);
        mh.printFinalResult();
        }
    }
