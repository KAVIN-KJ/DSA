package ARRAYS;

import java.util.HashSet;

public class LongestConsecutiveSequence {
    public int solution(int arr[]){
        HashSet<Integer> st = new HashSet<>();
        if(arr.length==0) return 0;
        int ans = 1;
        for(int i : arr) st.add(i);
        
        for(int i : st){
            if(!st.contains(i-1)){
                int cur = i;
                int len = 0;
                while(st.contains(cur++)){
                    len++;
                }
                ans = Math.max(len,ans);
            }
        }
        return ans;
    }
}
