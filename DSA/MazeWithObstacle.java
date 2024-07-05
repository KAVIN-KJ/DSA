import java.util.Scanner;

public class MazeWithObstacle {
    public static void main(String[] args) {
         int m=0;
        int n=0;
        Scanner in = new Scanner(System.in);
        m=in.nextInt();
        n=in.nextInt();
        int dp[][] = new int[m][n];
        int arr[][] = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j] = -1;
                arr[i][j] = in.nextInt();
            }
        }
        int a = solveMazeRecurse(m-1,n-1,arr);
        int b = solveMazeMem(m-1,n-1,arr,dp);
        int c = solveMazeTabulation(m,n,arr);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);;
    }

// TABULATION
    
    private static int solveMazeTabulation(int m, int n,int[][] arr) {

        int dp[][] = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i>=0&&j>=0&&arr[i][j]==-1) dp[i][j] = 0;
                else if(i==0&&j==0) dp[i][j] = 1;
                else{
                    int top=0,left=0;
                    if(i>0) top = dp[i-1][j];
                    if(j>0) left = dp[i][j-1];
                    dp[i][j] = top+left;
                }
            }
        }

        return dp[m-1][n-1];
    }
    
//  RECURSION

    private static int solveMazeRecurse(int m, int n,int arr[][]) {
            if(n>=0&&m>=0&&arr[m][n]==-1) return 0;
            if(m==0&&n==0) return 1;
            if(m<0||n<0) return 0;

            return solveMazeRecurse(m-1, n, arr) + solveMazeRecurse(m, n-1, arr);

    }

// MEMOIZATION

    private static int solveMazeMem(int m, int n, int[][] arr, int[][] dp) {
        if(n>=0&&m>=0&&arr[m][n]==-1) return 0;
        if(m==0&&n==0) return 1;
        if(m<0||n<0) return 0;
        if(dp[m][n]!=-1) return dp[m][n];
        return dp[m][n] = solveMazeMem(m-1, n, arr,dp) + solveMazeMem(m, n-1, arr,dp);
    }

}

   