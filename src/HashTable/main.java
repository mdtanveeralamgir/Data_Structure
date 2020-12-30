package HashTable;

import DataStructure.BinarySearchTree;

public class main {

    public static void main(String[] args) {
        Hash_table ht = new Hash_table(10);
        ht.insert("Good");
        ht.insert("hello");
        ht.insert("world");
        ht.insert("world");
        ht.insert("JAVA");
        ht.insert("coding");
        ht.printArray();
        System.out.println(ht.getindexOfWord("JAVA"));
        }
    }
