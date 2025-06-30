package Graphs;

import java.util.LinkedList;
import java.util.Queue;

class pair{
    int i,j,t;
    pair(int i,int j,int t){
        this.i = i;
        this.j = j;
        this.t = t;
    }
}

public class Rotting_Oranges {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;
        Queue<pair> q = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.offer(new pair(i,j,0));
                }
                else if(grid[i][j]==1){
                    fresh++;
                }

            }
        }
        if(fresh==0) return 0;
        int t = 0;
        int dx[] = {0,0,1,-1};
        int dy[] = {-1,1,0,0};
        while(!q.isEmpty()){
            pair p = q.poll();
            int x = p.i;
            int y = p.j;
            t = p.t;
            for(int i=0;i<4;i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(nx>=0 && nx<m && ny>=0 && ny<n && grid[nx][ny]==1){
                    grid[nx][ny] = 2;
                    q.offer(new pair(nx,ny,t+1));
                    fresh--;
                }
            }
        }
        return fresh==0 ? t : -1;
    }
}
