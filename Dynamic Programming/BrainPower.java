import java.util.*;


//  Solving Questions With Brainpower LEETCODE 2140

public class BrainPower {
    public long mostPoints(int[][] arr) {
        long dp[] = new long[arr.length];
        Arrays.fill(dp, -1);
        return solve(0, arr, dp);
    }

    static long solve(int i, int[][] arr, long dp[]) {
        if (i == arr.length - 1) {
            return arr[i][0];
        }
        if (i >= arr.length)
            return 0;
        if (dp[i] != -1)
            return dp[i];

        long pick = arr[i][0] + solve(i + arr[i][1] + 1, arr, dp);
        long npick = solve(i + 1, arr, dp);

        return dp[i] = Math.max(pick, npick);
    }

    static long solve(int[][] arr) {
        int n = arr.length;
        long dp[] = new long[n];
        dp[n - 1] = arr[n - 1][0];
        for (int i = n - 2; i >= 0; i--) {
            long pick = arr[i][0];
            if (i + arr[i][1] + 1 <= n - 1)
                pick += dp[i + arr[i][1] + 1];
            long npick = dp[i + 1];
            dp[i] = Math.max(pick, npick);
        }
        return dp[0];
    }
}
