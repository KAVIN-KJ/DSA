

// LEETCODE 72 - EDIT DISTANCE

import java.util.*;
public class MininumOpetations {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.nextLine();
        String s2 = in.nextLine();
        int ans = solve(s1.length()-1,s2.length()-1,s1,s2);
        System.out.println(ans);
        ans = solve(s1,s2);
        System.out.println(ans);
        in.close();
    }


    public int solve_SpaceOptimized(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int prev[] = new int[m+1];
        int cur[] = new int[m+1];
        for(int i=0;i<=m;i++){
            prev[i] = i;
        }
        if(n==0) return m;
        for(int i=1;i<=n;i++){
            cur[0] = i;
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)) cur[j] = prev[j-1];
                else{
                    int ins = cur[j-1];
                    int del = prev[j];
                    int rep = prev[j-1];
                    cur[j] = 1 + Math.min(ins,Math.min(del,rep));
                }
            }
            prev = cur.clone();
        }
        return cur[m];
    }



    private static int solve(String s1,String s2){
        int n = s1.length();
        int m = s2.length();
        int dp[][] = new int[n+1][m+1];
        for(int i=0;i<=m;i++){
            dp[0][i] = i;
        }
        for(int i=0;i<=n;i++){
            dp[i][0] = i;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
                else{
                    int ins = dp[i][j-1];
                    int del = dp[i-1][j];
                    int rep = dp[i-1][j-1];
                    dp[i][j] = 1+Math.min(ins,Math.min(del,rep));
                }
            }
        }
        return dp[n][m];
    }

    private static int solve(int i,int j, String s1, String s2) {
// s1 exhausted
        if(i<0) return j+1;
// S2 Exhausted
        if(j<0) return i+1;

        if(s1.charAt(i)==s2.charAt(j)) return solve(i-1, j-1, s1, s2);
        int ins = 1 + solve(i,j-1,s1,s2);
        int del = 1 + solve(i-1,j,s1,s2);   
        int rep = 1 + solve(i-1,j-1,s1,s2);
        return Math.min(ins,Math.min(del,rep));
    }
}
