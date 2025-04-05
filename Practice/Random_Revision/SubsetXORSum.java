package Random_Revision;

public class SubsetXORSum {
    static int ans = 0;
    public int subsetXORSum(int[] nums) {
        ans = 0;
        solve(0,nums,0);
        return ans;
    }
    static void solve(int i,int[] nums,int xor){
        if(i==nums.length){
            ans+=xor;
            return;
        }
        solve(i+1,nums,xor);
        solve(i+1,nums,xor^nums[i]);

    }
}
