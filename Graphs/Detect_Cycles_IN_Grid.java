package Graphs;

import java.util.*;

public class Detect_Cycles_IN_Grid {
    boolean vis[][];
    public boolean containsCycle(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        vis = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!vis[i][j]){
                    if(bfs(i,j,grid,vis,m,n,grid[i][j])) return true;
                }
            }
        }
        return false;
    }
    boolean bfs(int x,int y,char[][] grid, boolean[][] vis,int m,int n,char sr){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x,y,-1,-1});
        vis[x][y] = true;
        int dx[] = {0,0,-1,1};
        int dy[] = {-1,1,0,0};
        while(!q.isEmpty()){
            int[] arr = q.poll();
            int i = arr[0];
            int j = arr[1];
            int pi = arr[2];
            int pj = arr[3];
            for(int t=0;t<4;t++){
                int nx = i+dx[t];
                int ny = j+dy[t];
                if(nx>=0 && nx<m && ny>=0 && ny<n && grid[nx][ny]==sr){

                    if(!vis[nx][ny]){
                        q.offer(new int[]{nx,ny,i,j});
                        vis[nx][ny] = true;
                    }
                    else if (vis[nx][ny] && nx!=pi && ny!=pj) {
                        return true;
                    }
                }
            }
        }
        return false;
    } 
}
