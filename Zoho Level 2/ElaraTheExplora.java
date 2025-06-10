import java.util.*;

public class ElaraTheExplora {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int grid[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = in.nextInt();
            }
        }
        in.close();
        int visited[][] = new int[m][n];
        int sol = traverse(grid, visited, 0, 0);
        System.out.println(sol>=(int)1e9 ? "-1" : sol);
    }

    static boolean safe(int grid[][], int visited[][], int i, int j) {
        return (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 0 && visited[i][j]==0);
    }

    static int traverse(int grid[][], int[][] visited, int i, int j) {
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            if (grid[i][j] == 1)
                return (int) 1e9;
            else
                return 0;
        }
        visited[i][j]=1;
        int top = (int) 1e9, right = (int) 1e9, down = (int) 1e9, left = (int) 1e9;
        if (safe(grid, visited, i - 1, j))
            top = traverse(grid, visited, i - 1, j);
        if (safe(grid, visited, i + 1, j))
            down = traverse(grid, visited, i + 1, j);
        if (safe(grid, visited, i, j + 1))
            right = traverse(grid, visited, i, j + 1);
        if (safe(grid, visited, i, j - 1))
            left = traverse(grid, visited, i, j - 1);
        visited[i][j] = 0;
        return Math.min(top, Math.min(right, Math.min(down, left))) + 1;
    }

}

/*
 * 0 0 0 0
 * 0 0 0 0
 * 0 0 1 0
 * 
 * 1 = wall
 * 0 = path
 * 
 */
