import java.util.*;

import java.util.Scanner;

class item {
    int val, wei;

    item(int v, int w) {
        this.val = v;
        this.wei = w;
    }
}

public class KnapSack {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        item arr[] = new item[n];
        System.out.println("Enter weight followed by value of each element : ");
        for (int i = 0; i < n; i++) {
            int wei = in.nextInt();
            int val = in.nextInt();
            item it = new item(val, wei);
            arr[i] = it;
        }
        System.out.println("Enter the capacity of the Sack : ");
        int cap = in.nextInt();
        int dp[][] = new int[n][cap + 1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i], -1);
        }
        in.close();
        System.out.println("Recursive : " + solve(n - 1, arr, cap));
        System.out.println("Memoized : " + solve(n - 1, arr, cap, dp));
        System.out.println("Tabulated : " + solve(arr,cap));
    }

    private static int solve(item[] arr, int cap) {
        int n = arr.length;
        int dp[][] = new int[n][cap+1];
        for(int i=arr[0].wei;i<=cap;i++){
            dp[0][i] = arr[0].val;
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<=cap;j++){
                int npick = dp[i-1][j];
                int pick = Integer.MIN_VALUE;
                if(arr[i].wei<=j) pick = arr[i].val + dp[i-1][j-arr[i].wei];
                dp[i][j] = Math.max(npick, pick);
            }
        }
        
        return dp[n-1][cap];
    }

    private static int solve(int i, item[] arr, int cap, int[][] dp) {
        if (i == 0) {
            return arr[0].wei <= cap ? arr[0].val : 0;
        }
        if(dp[i][cap]!=-1) return dp[i][cap];
        int npick = solve(i - 1, arr, cap, dp);
        int pick = Integer.MIN_VALUE;
        if (arr[i].wei <= cap)
            pick = arr[i].val + solve(i - 1, arr, cap - arr[i].wei, dp);
        dp[i][cap] = Math.max(npick, pick);
        return dp[i][cap];
    }

    private static int solve(int i, item[] arr, int cap) {
        if (i == 0) {
            return arr[0].wei <= cap ? arr[0].val : 0;
        }
        int npick = solve(i - 1, arr, cap);
        int pick = Integer.MIN_VALUE;
        if (arr[i].wei <= cap)
            pick = arr[i].val + solve(i - 1, arr, cap - arr[i].wei);
        return Math.max(npick, pick);
    }

}
