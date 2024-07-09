import java.util.Scanner;

public class Minimum_Path_Sum {
    public static void main(String[] args) {
        int m=0,n=0;
        Scanner in = new Scanner(System.in);
        m=in.nextInt();
        n=in.nextInt();
        int arr[][] = new int[m][n];
        int dp[][] = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                arr[i][j] = in.nextInt();
                dp[i][j] = -1;
            }
        }
        System.out.println(MinCostPath(m-1,n-1,arr));
        System.out.println(MinCostPathMEM(m-1,n-1,arr,dp));
        System.out.println(MinCostPathTAB(m,n,arr));
        in.close();
    }

// TABULATED
    private static int MinCostPathTAB(int m, int n, int[][] arr) {
        int dp[][] = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int right=Integer.MAX_VALUE,down=Integer.MAX_VALUE;
                if(i==0&&j==0) dp[i][j] = arr[i][j];
                else{
                    if(i>0) down=arr[i][j]+dp[i-1][j];
                    if(j>0) right=arr[i][j]+dp[i][j-1];
                    dp[i][j] = Math.min(right, down);
                }
            }
        }
        return dp[m-1][n-1];
    }
// MEMOIZED
    private static int MinCostPathMEM(int i, int j, int[][] arr, int[][] dp) {
        if(i==0&&j==0) return arr[i][j];
        if(i<0||j<0) return Integer.MAX_VALUE-10000;
        if(dp[i][j]!=-1) return dp[i][j];
        int left = arr[i][j]+MinCostPathMEM(i, j-1, arr, dp);
        int top = arr[i][j]+MinCostPathMEM(i-1, j, arr, dp);
        return dp[i][j] = Math.min(left,top);
    }
// RECURSION
    private static int MinCostPath(int i, int j, int[][] arr) {
       if(i==0&&j==0) return arr[i][j];
       if(i<0||j<0) return Integer.MAX_VALUE-10000;
       int left = arr[i][j]+MinCostPath(i, j-1, arr);
       int top = arr[i][j]+MinCostPath(i-1, j, arr);
       return Math.min(left,top);
    }
}
