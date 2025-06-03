package NeetCode_150.Sliding_Window;

import java.util.Arrays;
import java.util.Scanner;

public class LongestSubstr_Without_Repeating {
     static int lengthOfLongestSubstring(String s) {
        int rt = 0,lt=0,ans=0;
        int hash[] = new int[256];
        Arrays.fill(hash,-1);
        while(rt<s.length()){
            int c = (int)s.charAt(rt);
            if(hash[c]!=-1){
                if(hash[c]>=lt)
                    lt = hash[c]+1;
            }
            ans = Math.max(ans,(rt-lt)+1);
            hash[c] = rt++;
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        System.out.println(lengthOfLongestSubstring(s));
        in.close();
    }
}
