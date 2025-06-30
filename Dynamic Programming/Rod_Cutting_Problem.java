 public class Rod_Cutting_Problem{
    public int cutRod(int[] arr) {
        // code here
        int n = arr.length;
        int dp[][] = new int[n][n+1];
        for(int i=0;i<=n;i++){
            dp[0][i] = arr[0] * i;
        }
        for(int i=1;i<n;i++){
            for(int l=0;l<=n;l++){
                int npick = dp[i-1][l];
                int pick = Integer.MIN_VALUE;
                if(i+1<=l) pick = arr[i] + dp[i][l-(i+1)];
                dp[i][l] = Math.max(pick,npick);
            }
        }
        return dp[n-1][n];
    }
}