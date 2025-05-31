import java.util.*;

public class LongestConsecutiveSubseqence {
    static int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        HashSet<Integer> st = new HashSet<>();
        for(int i : nums) st.add(i);
        int maxl = 1;
        for(int i : st){
            if(!st.contains(i-1)){
                int curlen = 1;
                int cur = i;
                while(st.contains(cur+1)){
                    cur++;
                    curlen++;
                    maxl = Math.max(maxl,curlen);
                }
            }
        }
        return maxl;
    }    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++) arr[i] = in.nextInt();
        System.out.println(longestConsecutive(arr));
        in.close();
    }
}
