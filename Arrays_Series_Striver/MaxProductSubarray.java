package Arrays_Series_Striver;
public class MaxProductSubarray {
    public int maxProduct(int[] nums) {
        int prf = 1;
        int suf = 1;
        int max = (int)-1e9;
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(prf==0) prf = 1;
            if(suf==0) suf = 1;
            prf *= nums[i];
            suf *= nums[n-i-1];
            max = Math.max(max,Math.max(prf,suf));
        }
        return max;
    }
}
