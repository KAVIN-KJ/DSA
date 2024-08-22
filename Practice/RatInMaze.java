package Practice;

import java.util.*;
public class RatInMaze {


    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Grid Size");
        int n = in.nextInt();
        int arr[][] = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j] = in.nextInt();
            }
        }
        solve(arr);

    }

    public static boolean safe(int x, int y, int[][] grid, int[][] visited,int n){
        return(x>=0&&x<n&&y>=0&&y<n&&grid[x][y]==1&&visited[x][y]==0);
    }

    public static void findPaths(int x, int y, int[][] grid, String s, ArrayList<String> sol,int[][] visited,int n){
        if(x==n-1&&y==n-1){
            sol.add(s);
            return;
        }
        visited[x][y] = 1;
        if(safe(x, y-1, grid, visited, n)){
            findPaths(x, y-1, grid, s+"L", sol, visited, n);
        }
        if(safe(x-1,y,grid,visited,n)){
            findPaths(x-1, y, grid, s+"U", sol, visited, n);
        }
        if(safe(x, y+1, grid, visited, n)){
            findPaths(x, y+1, grid, s+"R", sol, visited, n);
        }
        if(safe(x+1, y, grid, visited, n)){
            findPaths(x+1, y, grid, s+"D", sol, visited, n);
        }
        visited[x][y] = 0;
    }   

    public static void solve(int[][] grid){
        ArrayList<String> solution = new ArrayList<>();
        int n = grid.length;
        int[][] visited = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                visited[i][j] = 0;
            }
        }
        findPaths(0, 0, grid, "", solution, visited,n);
        for(String i : solution){
            System.out.println(i);
        }
    }
}