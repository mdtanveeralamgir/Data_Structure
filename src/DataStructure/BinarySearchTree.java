package DataStructure;

public class BinarySearchTree {

    public Node root;

    public BinarySearchTree(int data)
    {
        root = new Node(data);
    }

    public void addData(int data)
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
                    Node newNode = new Node(data);
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
                    Node newNode = new Node(data);
                    node.setRight(newNode);
                    return;
                }
            }
        }
    }

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


    public Node returnRoot(){
        return this.root;
    }
    public void printBST(Node node)
    {
        if(node != null)
        {

            System.out.print(node.getData() + ", ");
            printBST(node.getLeft());
            printBST(node.getRight());
        }


    }
}
