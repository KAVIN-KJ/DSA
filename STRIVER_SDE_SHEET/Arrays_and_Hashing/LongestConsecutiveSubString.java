package Arrays_and_Hashing;

import java.util.*;

public class LongestConsecutiveSubString {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int ans = longestConsecSubstr(s);
        System.out.println(ans);
        in.close();
    }

    private static int longestConsecSubstr(String s) {
        int ans = 0;
        int hash[] = new int[256];
        Arrays.fill(hash,-1);
        int l = 0;
        int r = 0;
        while(r<s.length()){
            int x = s.charAt(r);
            if(hash[x]!=-1){
                if(hash[x]>=l){
                    l = hash[x]+1;
                }
            }
            hash[x] = r;
            ans = Math.max(ans,(r-l)+1);
            r++;
        }
        
        return 0;
    }
}
