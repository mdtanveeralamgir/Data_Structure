package DataStructure;

public class Main {

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        int arr[] = {20, 30, 200, 45, 200, 20, 50};
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
    if(bst.removeNode(60)){
        bst.printBST(bst.returnRoot());
    }
//        System.out.println(bst.findMin().getData());
//        System.out.println(bst.findMax().getData());
    }
}
