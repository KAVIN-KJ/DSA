package Graphs;
import java.util.*;

public class Count_Provinces {
    public int findCircleNum(int[][] arr) {
        int n = arr.length;
        boolean vis[] = new boolean[n];
        int ans = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]==1 && !vis[i]){
                    ans++;
                    bfs(i,n,arr,vis);
                }
            }
        }
        return ans;
    }
    void bfs(int i, int n, int arr[][],boolean vis[]){
        Queue<Integer> q = new LinkedList<>();
        q.offer(i);
        while(!q.isEmpty()){
            int nd = q.poll();
            vis[nd] = true;
            for(int j=0;j<n;j++){
                if(arr[nd][j]==1 && !vis[j]){
                    q.offer(j);
                }
            }
        }
    }
}
