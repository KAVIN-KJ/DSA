package ZohoPractice;

import java.util.*;

public class NQueens {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int grid[][] = new int[n][n];
        List<List<String>> al = new ArrayList<>();
        solve(0,grid,al);
        for(List<String> i : al){
            for(String s : i){
                System.out.println(s);
            }
            System.out.println("_________________");
        }
    }

    private static boolean solve(int r, int[][] grid) {
        int n = grid.length;
        if(r==n){
            return true;
        }
        for(int c=0;c<n;c++){
            if(safe(r,c,grid)){
                grid[r][c] = 1;
                if(solve(r+1, grid)) return true;
                grid[r][c] = 0;
            }
        }
        return false;
    }

    private static void solve(int r, int[][] grid, List<List<String>> al) {
        int n = grid.length;
        if(r==n){
            List<String> sol = new ArrayList<>();
            for(int[] i : grid){
                StringBuilder sb = new StringBuilder();
                for(int j : i){
                    sb.append(j==1 ? "Q" : ".").append(" ");
                }
                sol.add(sb.toString());
            }
            al.add(sol);
            return;
        }
        for(int c=0;c<n;c++){
            if(safe(r,c,grid)){
                grid[r][c] = 1;
                solve(r+1, grid,al); 
                grid[r][c] = 0;
            }
        }
        return;
    }

    private static boolean safe(int r, int c, int[][] grid) {
        for(int i=0;i<grid.length;i++)
            if(grid[r][i]==1) return false;
        
        for(int i=0;i<grid.length-1;i++){
            if(grid[i][c]==1) return false;
        }

        for(int i=r,j=c;i>=0&&j>=0;i--,j--)
            if(grid[i][j]==1) return false;

        for(int i=r,j=c;i>=0&&j<grid.length;i--,j++)
            if(grid[i][j]==1) return false;
        return true;
    }
}
