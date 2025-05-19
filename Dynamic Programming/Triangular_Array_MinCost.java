public class Triangular_Array_MinCost {
    public static void main(String[] args) {
        int[][] arr = {
            {14},
            {13, 4},
            {5, 12, 9},
            {15, 10, 11, 2},
            {6, 3, 14, 7, 8},
            {10, 13, 1, 6, 12, 11},
            {7, 2, 5, 9, 4, 8, 3},
            {6, 14, 10, 13, 1, 2, 7, 12},
            {11, 5, 8, 6, 14, 9, 13, 3, 10},
            {2, 7, 12, 15, 5, 1, 8, 10, 6, 4}
        };
        
        int n = arr.length;
        int dp[][] = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dp[i][j] = -1;
            }
        }
        int ans = compute(0,0,arr);
        System.out.println(ans);
        ans = compute(0,0,arr,dp);
        System.out.println(ans);
        ans = compute(arr,dp);
        System.out.println(ans);
        ans = compute(arr);
        System.out.println(ans);
    }



// SPACE OPTIMIZATION
private static int compute(int[][] arr) {
        int n = arr.length;
        int main[] = new int[n];
        for(int i=0;i<n;i++){
            main[i] = arr[n-1][i];
        }
        for(int i=n-2;i>=0;i--){
            int curr[] = new int[n];
            for(int j=i;j>=0;j--){
                int dn = arr[i][j] + main[j];
                int dg = arr[i][j] + main[j+1];
                curr[j] = Math.min(dn, dg);
            }
            main = curr;
        }
        return main[0];
    }


// TABULATION
private static int compute(int[][] arr,int[][] dp) {
        int n = arr.length;
        for(int i=0;i<n;i++){
            dp[n-1][i] = arr[n-1][i];
        }
        for(int i=n-2;i>=0;i--){
            for(int j=i;j>=0;j--){
                int dn = arr[i][j]+dp[i+1][j];
                int dg = arr[i][j]+dp[i+1][j+1];
                dp[i][j] = Math.min(dn,dg);
            }
        }
        return dp[0][0];
    }


// MEMOIZATION
    private static int compute(int i, int j, int[][] arr, int[][] dp) {
        if(i==arr.length-1) return arr[i][j];
        if(dp[i][j]!=-1) return dp[i][j];
        int down = compute(i+1, j, arr)+arr[i][j];
        int diag = compute(i+1, j+1, arr)+arr[i][j];
        return dp[i][j] = Math.min(diag, down);
    }


// RECURSION
    private static int compute(int i, int j, int[][] arr) {
        if(i==arr.length-1) return arr[i][j];
        int down = compute(i+1, j, arr)+arr[i][j];
        int diag = compute(i+1, j+1, arr)+arr[i][j];
        return Math.min(down,diag);
    }

}
