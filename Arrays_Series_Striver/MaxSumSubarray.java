package Arrays_Series_Striver;

public class MaxSumSubarray {
    class Solution {
    public int maxSubArray(int[] nums) {
        int ans = -(int)1e9;
        int cur = 0;
        for(int i : nums){
            cur+=i;
            ans=Math.max(ans,cur);
            if(cur<0) cur = 0;
        }
        return ans;
    }
}
}
