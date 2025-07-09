package Graphs;
import java.util.*;

public class MaxArea_Of_An_Island {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    ans = Math.max(ans,bfs(grid,i,j,m,n));
                }
            }
        }
        return ans;
    }
    
    public int bfs(int grid[][],int x,int y,int m,int n){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x,y});
        grid[x][y] = 0;
        int dx[] = {0,0,-1,1};
        int dy[] = {-1,1,0,0};
        int area = 1;
        while(!q.isEmpty()){
            int i = q.peek()[0];
            int j = q.peek()[1];
            q.poll();
            for(int k=0;k<4;k++){
                int nx = i+dx[k];
                int ny = j+dy[k];
                if(nx>=0 && nx<m && ny>=0 && ny<n && grid[nx][ny]!=0){
                    q.offer(new int[]{nx,ny});
                    grid[nx][ny] = 0;
                    area++;
                }
            }
        }
        return area;
    }
}
