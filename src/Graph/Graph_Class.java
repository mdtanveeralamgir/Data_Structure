package Graph;

import java.util.ArrayList;

public class Graph_Class {
    private int vCount;
    private int eCount;
    private ArrayList[] vertasys;

    public Graph_Class(int vValue){
        this.vCount = vValue;
        this.eCount = 0;
        this.vertasys = new ArrayList[vValue];

        for(int i = 0; i < this.vCount; i++){
            this.vertasys[i] = new ArrayList<Integer>();
        }
    }

    public void addEdge(int vIndex, int eIndex){
        if(vIndex < this.vCount && eIndex < this.vCount){
            this.vertasys[vIndex].add(eIndex);
            this.eCount++;
        }
    }

    public void showEdges(int vIndex){
        if(vIndex < this.vCount){
            ArrayList temp = this.vertasys[vIndex];
            for(int x = 0; x < temp.size(); x++){
                System.out.println(temp.get(x));
            }
        }
    }
}
