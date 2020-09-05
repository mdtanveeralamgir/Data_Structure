package DataStructure;

public class BinarySearchTree {

    public Node root;

    public void addData(int data)
    {

        Node newNode = new Node(data);
        if(root == null)
        {
            root = newNode;
        } else
        {
            Node node = root;
            while(true)
            {
                if(data < node.getData())
                {
                    if(node.getLeft() != null)
                    {
                        node = node.getLeft();
                    }
                    else
                    {

                        node.setLeft(newNode);
                        return;
                    }
                }
                else
                {
                    if(node.getRight() != null)
                    {
                        node = node.getRight();
                    }
                    else
                    {
                        node.setRight(newNode);
                        return;
                    }
                }
            }
        }
    }

    //Retrieving a data from the bst
    public Node getData(int data)
    {
        Node node = root;

        while(node.getData() != data)
        {
            if(data < node.getData())
            {
                node = node.getLeft();
            }
            else
            {
                node = node.getRight();
            }
            if(node.getLeft() == null && node.getRight() == null && node.getData() != data)
            {
                return null;
            }
        }
        return node;
    }


    //Returns the root
    public Node returnRoot(){
        return this.root;
    }

    //Print all the value in the bst
    public void printBST(Node node)
    {
        if(node != null)
        {

            System.out.print(node.getData() + ", ");
            printBST(node.getLeft());
            printBST(node.getRight());
        }


    }

    //Find the minimum value
    public Node findMin(){
        Node node = root;
        Node min = null;
        while(node != null)
        {
            min = node;
            node = node.getLeft();
        }
        return min;
    }



    //Find the max value
    public Node findMax(){
        Node node = root;
        Node max = null;
        while(node != null)
        {
            max = node;
            node = node.getRight();
        }
        return max;
    }

    //Find the minimum value for delete func
    public Node findMin(Node node){
        Node min = node;
        Node parent = node;
        Node current = node.getRight();
        while(current != null)
        {
            parent = min;
            min = current;
            current = current.getLeft();
        }
        if(min != node.getRight()){
            parent.setLeft(min.getRight());
            parent.setRight(node.getRight());
        }
        return min;
    }

    //Delete a node
    public boolean removeNode(int data){
        //Searching the node to be deleted

        Node currentNode = root;
        Node parentNode = root;
        boolean isLeftChild = false;

        while(currentNode.getData() != data){
            parentNode = currentNode;
            if(data < currentNode.getData()){
                isLeftChild = true;
                currentNode = currentNode.getLeft();
            } else{
                currentNode = currentNode.getRight();
                isLeftChild = false;
            }
            if(currentNode == null){
                return false;
            }
        }

        //If the node to be deleted is a leaf node
        Node nodeToDelete = currentNode;
        if(nodeToDelete.getRight() == null && nodeToDelete.getLeft() == null){
            if(nodeToDelete == root){
                root = null;
            }
            else if(isLeftChild){
                parentNode.setLeft(null);
            } else{
                parentNode.setRight(null);
            }
        }
        //If the node to be deleted has only one child on the left
        else if(nodeToDelete.getRight() == null){
            if(nodeToDelete == root){
                root = nodeToDelete.getLeft();
            }
            else if(isLeftChild){
                parentNode.setLeft(nodeToDelete.getLeft());
            } else{
                parentNode.setRight(nodeToDelete.getLeft());
            }
            //If the node to be deleted has only one child on the right
        } else if(nodeToDelete.getLeft() == null){
            if(nodeToDelete == root){
                root = nodeToDelete.getRight();
            }
            else if(isLeftChild){
                parentNode.setLeft(nodeToDelete.getRight());
            } else{
                parentNode.setRight(nodeToDelete.getRight());
            }
        }
        //If node to delete has 2 children
        else{

            Node successor = this.findMin(nodeToDelete);
            if(nodeToDelete == root){
                root = successor;
            }
            else if(isLeftChild){
                parentNode.setLeft(successor);
            } else{
                parentNode.setRight(successor);
            }
            successor.setLeft(nodeToDelete.getLeft());
        }
        return true;
    }
}
