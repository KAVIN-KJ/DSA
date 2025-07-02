package Graphs;
import java.util.*;
public class Detect_Cycles_Graph {
    public boolean isCycle(int V, int[][] edges) {
        List<Integer> adj[] = new ArrayList[V];
        for(int i=0;i<V;i++){
            adj[i] = new ArrayList<>();
        }
        boolean vis[] = new boolean[V];
        for(int i=0;i<edges.length;i++){
            adj[edges[i][0]].add(edges[i][1]);
            adj[edges[i][1]].add(edges[i][0]);
        }
        for(int i=0;i<V;i++){
            if(!vis[i]){
                if(bfs(i,adj,vis)) return true;
            }
        }
        return false;
    }
    boolean bfs(int V,List<Integer> arr[],boolean vis[]){
        Queue<int[]> q = new LinkedList<>();
        vis[V] = true;
        q.offer(new int[]{V,-1});
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int n = cur[0];
            int parent = cur[1];
            for(int i : arr[n]){
                if(!vis[i]){
                    q.offer(new int[]{i,n});
                    vis[i] = true;
                }
                else if(vis[i] && parent!=i){
                    return true;
                }
            }
        }
        return false;
    }
}
