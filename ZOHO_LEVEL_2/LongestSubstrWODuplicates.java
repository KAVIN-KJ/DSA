import java.util.*;
public class LongestSubstrWODuplicates {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int l=0,r=0;
        int ans = 0;
        int ind[] = new int[256];
        Arrays.fill(ind,-1);
        while(r<s.length()){
            int c = (int)s.charAt(r);
            if(ind[c]!=-1){
                if(l<=ind[c])
                    l = ind[c]+1;
            }
            ans = Math.max(ans,(r-l)+1);
            ind[c] = r++;
        }
        System.out.println(ans);
    }
}
