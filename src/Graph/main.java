package Graph;

public class main {
    public static void main(String [] args){
        Graph_Class myGraph = new Graph_Class(5);
        myGraph.addEdge(0,1);
        myGraph.addEdge(0,2);
        myGraph.addEdge(0,3);
        myGraph.addEdge(1,2);
        myGraph.addEdge(1,4);
        myGraph.addEdge(2,3);
        myGraph.addEdge(3,1);
        myGraph.addEdge(4,0);
        myGraph.addEdge(4,3);
        myGraph.showEdges(4);
    }
}
