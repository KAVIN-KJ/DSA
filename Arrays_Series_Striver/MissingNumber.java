package Arrays_Series_Striver;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int mpp[] = new int[n+1];
        for(int i=0;i<n;i++){
            mpp[nums[i]]++;
        }
        for(int i=1;i<=n;i++){
            if(mpp[i]==0) return i;
        }
        return 0;
    }
}
