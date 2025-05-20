
import java.util.*;

public class KnightsTour {
    static int movex[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
    static int movey[] = { 1, 2, 2, 1, -1, -2, -2, -1 };
    static int n = 0;
    static int grid[][];

    public static boolean solve(int x,int y,int move){
        if(move==n*n) return true;

        for(int i=0;i<8;i++){
            int nx = x+movex[i]; 
            int ny = y+movey[i];
            if(safe(nx,ny)){
                grid[nx][ny] = move;
                if (solve(nx,ny,move+1)) return true;
                grid[nx][ny] = -1;
            }
        }        
        return false;
            
    }

    private static boolean safe(int nx, int ny) {
        return nx>=0 && nx<n && ny>=0 && ny<n && grid[nx][ny]==-1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = -1;
            }
        }
        grid[0][0] = 0;
        solve(0, 0, 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }
        in.close();

    }
}