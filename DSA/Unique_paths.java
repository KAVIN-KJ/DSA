import java.util.Scanner;

public class Unique_paths {
    public static void main(String[] args) {
        int m=0;
        int n=0;
        Scanner in = new Scanner(System.in);
        m=in.nextInt();
        n=in.nextInt();
        int dp[][] = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j] = -1;
            }
        }
        in.close();
        System.out.println(uniquePaths(m-1,n-1,dp));
        System.out.println(uniquePathsDP(m,n));
    }

    private static int uniquePathsDP(int m, int n) {
        int dp[][] = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int top=0,left=0;
                if(i==0&&j==0) dp[i][j] = 1;
                else{
                    if(i>0) top = dp[i-1][j];
                    if(j>0) left = dp[i][j-1];
                    dp[i][j] = top+left;
                }
            }
        }
        return dp[m-1][n-1];
    }

    private static int uniquePaths(int i, int j,int[][] dp) {
        if(i==0&&j==0) return 1;
        if(i<0||j<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        return dp[i][j] =  uniquePaths(i-1, j,dp) + uniquePaths(i, j-1,dp);
    }
}
