package ARRAYS;
public class LongestRepeatingNonOverlapping {
    public String longestSubstring(String s) {
        // code here
        int dp[][] = new int[s.length()+1][s.length()+1];
        int ind = 0;
        int maxlen = 0;
        for(int i=1;i<=s.length();i++){
            for(int j=i+1;j<=s.length();j++){
                if(dp[i-1][j-1] < (j-i) && s.charAt(i-1)==s.charAt(j-1) ){
                    dp[i][j] = dp[i-1][j-1]+1;
                    if(dp[i][j]>maxlen){
                        maxlen = dp[i][j];
                        ind = i;
                    }
                }
            }
        }
        return (maxlen==0) ? "-1" : s.substring(ind-maxlen,ind);
        
    }
}
