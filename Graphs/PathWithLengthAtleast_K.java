package Graphs;

public class PathWithLengthAtleast_K {
    boolean pathMoreThanK(int v, int e, int k, int[] A) {
        int[][] grid = new int[v][v];
        int z = 0;

        for (int i = 0; i < e; i++) {
            int x = A[z++];
            int y = A[z++];
            int w = A[z++];
            grid[x][y] = Math.max(grid[x][y], w);
            grid[y][x] = Math.max(grid[y][x], w);
        }
        boolean vis[] = new boolean[v];

        return dfs(0, grid, vis, 0, k);
    }

    public static boolean dfs(int nd, int[][] grid, boolean[] vis, int cur, int k) {

        if (vis[nd])
            return false;
        if (cur >= k)
            return true;

        vis[nd] = true;

        for (int nbr = 0; nbr < grid.length; nbr++) {
            if (grid[nd][nbr] != 0 && !vis[nbr]) {
                if (dfs(nbr, grid, vis, cur + grid[nd][nbr], k))
                    return true;
            }
        }

        vis[nd] = false;
        return false;
    }
}