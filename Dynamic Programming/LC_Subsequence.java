// import java.util.*;

// public class LC_Subsequence {
//     public static void main(String[] args) {
//         Scanner in = new Scanner(System.in);
//         String s1 = in.nextLine();
//         String s2 = in.nextLine();
//         int i1 = s1.length() - 1;
//         int i2 = s2.length() - 1;
//         System.out.println("Recursive : " + solve(s1, s2, i1, i2));
//         System.out.println("Tabulated : " + solve(s1, s2));
//         in.close();
//     }

//     private static int solve(String s1, String s2) {
//         int l1 = s1.length();
//         int l2 = s2.length();
//         int dp[][] = new int[l1 + 1][l2 + 1];
//         for (int i = 0; i <= l1; i++) {
//             dp[i][0] = 0;
//         }
//         for (int i = 0; i <= l2; i++) {
//             dp[0][i] = 0;
//         }
//         for (int i = 1; i <= l1; i++) {
//             for (int j = 1; j <= l2; j++) {
//                 if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
//                     dp[i][j] = 1 + dp[i - 1][j - 1];
//                 } else {
//                     dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
//                 }
//             }
//         }
//         return dp[l1][l2];
//     }

//     private static int solve(String s1, String s2, int i1, int i2) {
//         if (i1 < 0 || i2 < 0) {
//             return 0;
//         }
//         if (s1.charAt(i1) == s2.charAt(i2)) {
//             return 1 + solve(s1, s2, i1 - 1, i2 - 1);
//         }
//         return Math.max(solve(s1, s2, i1 - 1, i2), solve(s1, s2, i1, i2 - 1));
//     }
// }


/**
 * LC_Subsequence
 */

import java.util.*;
public class LC_Subsequence {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.next();
        String s2 = in.next();
        solve(s1,s2);
        in.close();
    }

    private static void solve(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        int dp[][] = new int[l1+1][l2+1];
        for(int i=0;i<=l1;i++){
            dp[i][0] = 0;
        }
        for(int i=0;i<=l2;i++){
            dp[0][i] = 0;
        }
        for(int i=1;i<=l1;i++){
            for(int j=1;j<=l2;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                        dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        int i = l1;
        int j = l2;
        String ans = "";
        while(i>0&&j>0){
            if(s1.charAt(i-1)==s2.charAt(j-1)){
                ans+=s1.charAt(i-1);
                i--;
                j--;
            }
            else if(dp[i-1][j]>dp[i][j-1]){
                i--;
            }
            else j--;
        }
        System.out.println("The Length of LCS is "+dp[l1][l2]);
        System.out.println("The LCS is : "+new StringBuilder(ans).reverse().toString());
    }
    
}