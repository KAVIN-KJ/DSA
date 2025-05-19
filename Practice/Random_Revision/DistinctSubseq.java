package Random_Revision;

// package Practice;
import java.util.*;
public class DistinctSubseq {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.nextLine();
        String s2 = in.nextLine();
        int ans = solve(s1,s2);
        System.out.println(ans);
        ans = solve_optimized(s1, s2);
        System.out.println(ans);
        in.close();
    }

    private static int solve_optimized(String s1,String s2){
        int n = s1.length();
        int m = s2.length();
        int prev[] = new int[m+1];
        int cur[] = new int[m+1];
        prev[0] = cur[0] = 1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    cur[j] = prev[j]+prev[j-1];
                }
                else cur[j] = prev[j];
            }
            prev = cur.clone();
        }
        return cur[m];
    }    

    private static int solve(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int dp[][] = new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            dp[i][0] = 1;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][m];
    }
}
