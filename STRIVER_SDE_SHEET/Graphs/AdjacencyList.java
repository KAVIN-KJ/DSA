package Graphs;
import java.util.*;


public class AdjacencyList {
    int V;
    List<List<Integer>> adj;
    AdjacencyList(int v){
        this.V = v;
        adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
    }

    void addEdge(int src,int dest){
        adj.get(src).add(dest);
        adj.get(dest).add(src);
    }

    void display(){
        for(List<Integer> i : adj){
            for(int j : i){
                System.out.print(j+"->");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Scanner in = new Scanner(System.in);
        AdjacencyList grph = new AdjacencyList(5);
        grph.addEdge(0,1);
        grph.addEdge(2,4);
        grph.addEdge(3,1);
        grph.addEdge(0,2);
        grph.addEdge(2,3);
        grph.addEdge(4,1);
        grph.display();

    }
}