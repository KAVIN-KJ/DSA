package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class Count_Islands {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(i, j, grid, m, n);
                    bfs(i, j, grid, m, n);
                }
            }
        }
        return count;
    }

    void dfs(int i, int j, char[][] grid, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0')
            return;

        grid[i][j] = '0';
        dfs(i + 1, j, grid, m, n);
        dfs(i, j - 1, grid, m, n);
        dfs(i - 1, j, grid, m, n);
        dfs(i, j + 1, grid, m, n);
    }

    void bfs(int i, int j, char grid[][], int m, int n) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { i, j });
        int dr[] = { 0, 0, 1, -1 };
        int dc[] = { 1, -1, 0, 0 };
        while (!q.isEmpty()) {
            int x = q.peek()[0];
            int y = q.peek()[1];
            q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = x + dr[k];
                int ny = y + dc[k];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == '1') {
                    grid[nx][ny] = '0';
                    q.offer(new int[] { nx, ny });
                }
            }
        }
        return;
    }
}
