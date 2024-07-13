import java.util.ArrayList;

class Node{
    char data;
    Node(char dat){
        this.data = dat;
    }
}


class Graph{
    static ArrayList<ArrayList<Node>> nodes;
    Graph(){
        nodes = new ArrayList<>();
    }
    public void addNode(char dat){
        ArrayList<Node> curr = new ArrayList<>();
        curr.add(new Node(dat));
        nodes.add(curr);
    }
    public void addEdge(int src,int dest){
        nodes.get(src).add(nodes.get(dest).get(0));
    }

    public void printGraph(){
        for(int i=0;i<nodes.size();i++){
            for(int j=0;j<nodes.get(i).size();j++){
                System.out.print(nodes.get(i).get(j).data);
                if(j<nodes.get(i).size()-1){
                    System.out.print(" -> ");
                }
            }
            System.out.println();
        }
    }

}


public class Graph_AdjacencyList {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addNode('A');
        graph.addNode('B');
        graph.addNode('C');
        graph.addNode('D');
        graph.addNode('E');
        graph.addEdge(0,1);
        graph.addEdge(0,3);
        graph.addEdge(0,4);
        graph.addEdge(1,2);
        graph.addEdge(1,3);
        graph.addEdge(1,4);
        graph.addEdge(2,4);
        graph.addEdge(3,0);
        graph.addEdge(3,1);
        graph.addEdge(3,4);
        graph.addEdge(4,3);
        graph.printGraph();
    }
   
}
