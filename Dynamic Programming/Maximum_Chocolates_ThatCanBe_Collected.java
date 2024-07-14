import java.util.Scanner;

public class Maximum_Chocolates_ThatCanBe_Collected {
    public static void main(String[] args) {
         Scanner in = new Scanner(System.in);
        int m=in.nextInt();
        int n=in.nextInt();
        int arr[][] = new int[m][n];            
        int dp[][][] = new int[m][n][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                arr[i][j] = in.nextInt();
                for(int k=0;k<n;k++) dp[i][j][k] = -1;
            }
        }
        int ans = maxCandy(0,0,n-1,arr,dp);
        System.out.println("Memoization : "+ans);
        ans = maxCandy(arr,dp);
        System.out.println("Tabulation : "+ans);
        in.close();
    }

// TABULATION
    private static int maxCandy(int[][] arr, int[][][] dp) {
        int m = arr.length;
        int n = arr[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j) dp[m-1][i][j] = arr[m-1][i];
                else dp[m-1][i][j] = arr[m-1][i] + arr[m-1][j];
            }
        }
        for(int i=m-2;i>=0;i--){
            for(int j1=0;j1<n;j1++){
                for(int j2=0;j2<n;j2++){
                    int ans=Integer.MIN_VALUE;
                    for(int dj1=-1;dj1<=1;dj1++){
                        for(int dj2=-1;dj2<=1;dj2++){
                            int new1 = j1+dj1;
                            int new2 = j2+dj2;
                            int val=Integer.MIN_VALUE;
                            if(new1>=0&&new1<n&&new2>=0&&new2<n){
                                if(j1==j2) val = arr[i][j1] + dp[i+1][new1][new2];
                                else val = arr[i][j1] + arr[i][j2] + dp[i+1][new1][new2];
                            }
                            ans = Math.max(ans,val);
                        }
                    }
                    dp[i][j1][j2] = ans;
                }
            }
        }
        return dp[0][0][n-1];
    }


// RECURSION
    private static int maxCandy(int i, int j1, int j2, int[][] arr,int[][][]dp){
        if(j1<0||j1>=arr[0].length||j2<0||j2>=arr[0].length) return -1*Integer.MAX_VALUE;
        if(i==arr.length-1){
            if(j1==j2) return arr[i][j1];
            else return arr[i][j1]+arr[i][j2];
        }
        if(dp[i][j1][j2]!=-1) return dp[i][j1][j2];
        int ans=Integer.MIN_VALUE;
        for(int d1=-1;d1<=1;d1++){
            for(int d2=-1;d2<=1;d2++){
                int val=0;
                    if(j1==j2) val = arr[i][j1] + maxCandy(i+1, j1+d1, j2+d2, arr, dp);
                    else val = (arr[i][j1]+arr[i][j2]+maxCandy(i+1, j1+d1, j2+d2, arr, dp)); 
                    ans = Math.max(ans,val);
            }
        }
        return dp[i][j1][j2] = ans;
    }
}
