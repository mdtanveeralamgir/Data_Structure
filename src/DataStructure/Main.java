package DataStructure;

public class Main {

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree(50);
        int arr[] = {20, 30, 200, 45, 70, 10};
        for (int value : arr) {
            bst.addData(value);
        }
/*
        Node n = bst.getData(50);
        if(n != null)
        {
            System.out.println(n.getData());
        }
        else
        {
            System.out.println("Not Found");
        }


    */
    bst.printBST(bst.returnRoot());
    }
}
