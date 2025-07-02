package Graphs;

import java.util.*;

public class Flood_Fill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        bfs(image,sr,sc,color,image[sr][sc]);
        return image;
    }
    void bfs(int img[][],int xx,int yy,int col,int cur){
        Queue<int[]> q = new LinkedList<>();
        img[xx][yy] = col;
        int m = img.length;
        int n = img[0].length;
        q.offer(new int[] {xx,yy});
        int dx[] = {0,0,-1,1};
        int dy[] = {1,-1,0,0};
        while(!q.isEmpty()){
            int x = q.peek()[0];
            int y = q.peek()[1];
            q.poll();
            for(int i=0;i<4;i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(nx>=0 && nx<m && ny>=0 && ny<n && img[nx][ny]==cur && img[nx][ny]!=col){
                    img[nx][ny] = col;
                    q.offer(new int[] {nx,ny});
                }
            }
        }
        return;
    }
}
