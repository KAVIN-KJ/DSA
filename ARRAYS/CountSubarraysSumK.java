package ARRAYS;

import java.util.HashMap;

public class CountSubarraysSumK {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> mpp = new HashMap<>();
        int sum = 0,ans = 0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(sum==k) ans++;
            if(mpp.containsKey(sum-k)) ans+=mpp.get(sum-k);
            mpp.put(sum,mpp.getOrDefault(sum,0)+1);
        }
        return ans;
    }
}
