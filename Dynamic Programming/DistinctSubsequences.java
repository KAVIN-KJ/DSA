// RETURN THE TOTAL NUMBER OF OCCURRENCE OF S2 IN S1 AS A SUBSEQUENCE EG : 
// S1 = BABGBAG   S2 = BAG
import java.util.*;
public class DistinctSubsequences {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.nextLine();
        String s2 = in.nextLine();
        System.out.println(Solve(s1,s2));
        System.out.println(Solve1D(s1,s2));
        in.close();
    }

    private static int Solve1D(String s1,String s2){
        int n = s1.length();
        int m = s2.length();
        int prev[] = new int[m+1];
        int cur[] = new int[m+1];
        prev[0] = cur[0] = 1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    cur[j] = prev[j-1]+prev[j];
                }
                else{
                    cur[j] = prev[j];
                }
            }
            prev = cur.clone();
        }
        return cur[m];
    }

    private static int Solve(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int dp[][] = new int[n+1][m+1];
        // If s2 is exhausted, Match is always found !
        for(int i=0;i<=n;i++){
            dp[i][0] = 1;
        }
        // i for S1, j for S2
       for(int i=1;i<=n;i++){
        for(int j=1;j<=m;j++){
            if(s1.charAt(i-1)==s2.charAt(j-1)){
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                //  dp[i-1][j-1] -> match found and check fo next match
                // dp[i-1][j] -> match found but also check for a different match in s1
            }
            else {
                // Match not found so check for a match in s1
                dp[i][j] = dp[i-1][j];
            }
        }
       }
        return dp[n][m];
    }
}
