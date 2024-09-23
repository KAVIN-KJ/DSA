import java.util.Scanner;

public class MinimumInsertionsAndDeletions {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.nextLine();
        String s2 = in.nextLine();
        System.out.println(solve(s1,s2));
    }

    private static int solve(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        int dp[][] = new int[l1+1][l2+1];
        for(int i=0;i<=l1;i++){
            dp[i][0] = 0;
        }
        for(int j=0;j<=l2;j++){
            dp[0][j] = 0;
        }

        for(int i=1;i<=l1;i++){
            for(int j=1;j<=l2;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)) dp[i][j] = 1 + dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        int lcs = dp[l1][l2];
        int ans = (s1.length()-lcs) + (s2.length()-lcs);
        return ans;
    }
}
