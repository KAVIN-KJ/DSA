package ARRAYS;

public class MaxConsecOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int cur = 0;
        int ans = 0;
        for(int i : nums){
            if(i==1) cur++;
            else cur = 0;
            ans = Math.max(ans,cur);
        }
        return ans;
    }
}
