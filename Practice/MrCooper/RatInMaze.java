import java.util.Scanner;

public class RatInMaze {
    static int ans[][];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // int n = in.nextInt();
        // int grid[][] = new int[n][n];
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < n; j++) {
        //         grid[i][j] = in.nextInt();
        //     }
        // }
        ans = new int[4][4];
        int[][] maze = { { 1, 0, 0, 0 },
                { 1, 1, 0, 1 },
                { 1, 1, 0, 0 },
                { 0, 1, 1, 1 } };
        // ans = new int[n][n];
        ratInMaze(0, 0, maze);
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                System.out.print(ans[i][j]);
            }
            System.out.println();
        }
    }

    private static boolean ratInMaze(int i, int j, int grid[][]) {
        int n = grid.length;
        if (i == n - 1 && j == n - 1) {
            ans[i][j] = 1;
            return true;
        }
        if (safe(i, j, grid)) {
            ans[i][j] = 1;
            if (ratInMaze(i + 1, j, grid)) {
                return true;
            }
            if (ratInMaze(i, j + 1, grid)) {
                return true;
            }
            ans[i][j] = 0;
        }
        return false;
    }

    private static boolean safe(int i, int j, int grid[][]) {
        int n = grid.length;
        return i >= 0 && i < n && j >= 0 && j < n && grid[i][j] == 1;
    }
}
