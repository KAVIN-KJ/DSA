import java.util.*;;

public class LongestCommonSubstring {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.nextLine();
        String s2 = in.nextLine();
        System.out.println(solve(s1, s2));
        in.close();
    }

    private static int solve(String s1, String s2) {
       int l1 = s1.length();
       int l2 = s2.length();
       int dp[][] = new int[l1+1][l2+1];
       int ans = 0;
       for(int i=1;i<=l1;i++){
        for(int j=1;j<=l2;j++){
            if(s1.charAt(i-1)==s2.charAt(j-1)){
                dp[i][j] = 1 + dp[i-1][j-1];
            }
            else{
                dp[i][j] = 0;
            }
            ans = Math.max(ans,dp[i][j]);
        }
       }
       return ans;
    }
}
