import java.util.*;
public class ShortestCommonSuperSeq {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.nextLine();
        String s2 = in.nextLine();
        int l1 = s1.length();
        int l2 = s2.length();
        int dp[][] = new int[l1+1][l2+1];
        for(int i=0;i<=l1;i++) dp[i][0] = 0;
        for(int j=0;j<=l2;j++) dp[0][j] = 0;

        for(int i=1;i<=l1;i++){
            for(int j=1;j<=l2;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)) dp[i][j] = 1+dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        int i=l1,j=l2;
        String ans="";
        while(i>0&&j>0){
            if(s1.charAt(i-1)==s2.charAt(j-1)){
                ans+=s1.charAt(i-1);
                i--;
                j--;
            }
            else if(dp[i-1][j]>dp[i][j-1]){
                ans+=s1.charAt(i-1);
                i--;
            }
            else{
                ans+=s2.charAt(j-1);
                j--;
            }
        }
        while(i>0) {
            ans+=s1.charAt(i-1);
            i--;
        }
        while(j>0){
            ans+=s2.charAt(j-1);
            j--;
        } 

        System.out.println(new StringBuilder(ans).reverse().toString());
        in.close();
    }
}
