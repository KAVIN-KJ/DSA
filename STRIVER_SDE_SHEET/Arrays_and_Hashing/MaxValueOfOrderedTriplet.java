package Arrays_and_Hashing;

// LEETCODE : 2874

public class MaxValueOfOrderedTriplet {
    public long maximumTripletValue(int[] nums) {
        long ans = 0;
        int n = nums.length;
        int pref[] = new int[n];
        int suf[] = new int[n];
        pref[0] = nums[0];
        suf[n - 1] = nums[n - 1];
        for (int i = 1, j = n - 2; i < n && j >= 0; i++, j--) {
            pref[i] = Math.max(pref[i - 1], nums[i]);
            suf[j] = Math.max(nums[j], suf[j + 1]);
        }
        for (int i = 1; i < n - 1; i++) {
            ans = Math.max(ans, (long) (pref[i - 1] - nums[i]) * suf[i + 1]);
        }
        return ans;
    }
}
