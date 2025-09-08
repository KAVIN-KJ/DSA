package ZohoPractice;
import java.util.*;
public class RatInMaze {
    class Solution {
    // Function to find all possible paths
    int n = 0;
    public ArrayList<String> ratInMaze(int[][] maze) {
        // code here
        n = maze.length;
        if(maze[0][0]==0||maze[n-1][n-1]==0) return new ArrayList<>();
        ArrayList<String> al = new ArrayList<>();
        solve(0,0,"",new int[n][n],al,maze);
        return al;
    }
    private void solve(int x,int y,String s,int[][] vis,ArrayList<String> al,int[][] arr){
        if(x==n-1 && y==n-1){
            al.add(s);
            return;
        }
        vis[x][y] = 1;
        if(safe(x+1,y,vis,arr)){
            solve(x+1,y,s+"D",vis,al,arr);
        }
        if(safe(x,y-1,vis,arr)){
            solve(x,y-1,s+"L",vis,al,arr);
        }
        if(safe(x,y+1,vis,arr)){
            solve(x,y+1,s+"R",vis,al,arr);
        }
        if(safe(x-1,y,vis,arr)){
            solve(x-1,y,s+"U",vis,al,arr);
        }
        vis[x][y] = 0;
    }
    private boolean safe(int x,int y,int vis[][],int arr[][]){
        return (x>=0&&x<n&&y>=0&&y<n&&vis[x][y]==0&&arr[x][y]==1);
    }
}
}
