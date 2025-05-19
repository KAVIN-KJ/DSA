package Arrays_and_Hashing;

import java.util.Arrays;


// LEETCODE 3375

public class MinOperationTomakeArraytoK {

    public int minOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        if(nums[0]<k) return -1;
        int ans = 0;
        for(int i=0;i<n;i++){
            if(nums[i]>k){
                ans++;
                while(i<n-1 && nums[i+1]==nums[i]) i++;   
            }
        }
        return ans;
    }
}
