package Graphs;

public class AdjacencyMatrix {
    int V;
    int adj[][];

    AdjacencyMatrix(int v) {
        this.V = v;
        adj = new int[V][V];
    }

    void addEdge(int src, int dest) {
        adj[src][dest] = 1;
        adj[dest][src] = 1;
    }

    void display() {
        for (int[] i : adj) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Scanner in = new Scanner(System.in);
        AdjacencyMatrix grph = new AdjacencyMatrix(5);
        grph.addEdge(0, 1);
        grph.addEdge(2, 4);
        grph.addEdge(3, 1);
        grph.addEdge(0, 2);
        grph.addEdge(2, 3);
        grph.addEdge(4, 1);
        grph.display();
    }
}
