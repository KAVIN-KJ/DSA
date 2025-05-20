
// FIND THE MAXIMUM PATH SUM STARTING FROM
// ANY POINT IN FIRST ROW TO ANY POINT AT THE LAST ROW
// WE CAN MOVE DOWN (straight, left, right)

import java.util.Scanner;

public class Max_Path_Sum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m=in.nextInt();
        int n=in.nextInt();
        int arr[][] = new int[m][n];            
        int dp[][] = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                arr[i][j] = in.nextInt();
                dp[i][j] = -1;
            }
        }
        int ans=maxPath(m-1, 0, arr);
        for(int i=1;i<arr[0].length;i++){
            ans = Math.max(ans,maxPath(arr.length-1, i, arr));
        }
        System.out.println("Recursion : "+ans);
        ans = maxPath(m-1, 0, arr, dp);
        for(int i=1;i<arr[0].length;i++){
            ans = Math.max(ans,maxPath(arr.length-1, i, arr, dp));
        }
        System.out.println("Memoization : "+ans);
        ans = maxPath(arr);
        System.out.println("Tabulation : "+ans);
        ans = maxPathSpaceOpt(arr);
        System.out.println("Space Optimized : "+ans);
        in.close();
    }

// RECURSIVE
    private static int maxPath(int i, int j, int[][] arr) {
        if(j<0||j>=arr[0].length) return (int) -1e9;
        if(i==0) return arr[i][j];
        int up = maxPath(i-1, j, arr)+arr[i][j];
        int upleft = maxPath(i-1, j-1, arr)+arr[i][j];
        int upright = maxPath(i-1, j+1, arr)+arr[i][j];
        return Math.max(up,Math.max(upleft,upright));
    }


// MEMOIZED
    private static int maxPath(int i, int j, int[][] arr,int[][]dp) {
        if(j<0||j>=arr[0].length) return (int) -1e9;
        if(i==0) return arr[i][j];
        if(dp[i][j]!=-1) return dp[i][j];
        int up = maxPath(i-1, j, arr)+arr[i][j];
        int upleft = maxPath(i-1, j-1, arr)+arr[i][j];
        int upright = maxPath(i-1, j+1, arr)+arr[i][j];
        return dp[i][j] = Math.max(up,Math.max(upleft,upright));
    }


// TABULATION

    private static int maxPath(int[][] arr) {
        int m=arr.length,n=arr[0].length;
        int dp[][] = new int[m][n];
        int ans=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int d=0,l=0,r=0;
                if(i==0) dp[i][j] = arr[i][j];
                else{
                    if(i>0) d = arr[i][j]+dp[i-1][j];
                    if(i>0&&j<arr[0].length-1) r = arr[i][j]+dp[i-1][j+1];
                    if(i>0&&j>0) l = arr[i][j] + dp[i-1][j-1];
                    dp[i][j] = Math.max(d,Math.max(r,l));
                }
                if(i==m-1) ans=Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }


// SPACE OPTIMIZATION

    private static int maxPathSpaceOpt(int[][] arr) {
        int m=arr.length; //ROWS
        int n=arr[0].length; //COLS
        int dp[] = new int[n];
        int ans=(int) -1e9;
        for(int i=0;i<m;i++){
            int temp[] = new int[n];
            for(int j=0;j<n;j++){
                int u = (int) -1e9,l = (int) -1e9,r = (int) -1e9;
                if(i==0) {
                    dp[j] = arr[i][j];
                    temp[j] = arr[i][j];
                }
                else{
                    if(i>0) u = arr[i][j]+dp[j];
                    if(i>0&&j<n-1) r = arr[i][j]+dp[j+1];
                    if(i>0&&j>0) l = arr[i][j] + dp[j-1];
                    temp[j] = Math.max(u,Math.max(r,l));
                }
                ans=Math.max(ans,temp[j]);
            }
            dp = temp;
        }
        return ans;
    }
}
