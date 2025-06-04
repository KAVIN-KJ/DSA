import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums.length <= 1) {
            List<Integer> lst = new ArrayList<>();
            for (int i : nums)
                lst.add(i);
            return lst;
        }
        Arrays.sort(nums);
        int n = nums.length;
        int dp[] = new int[n];
        int prev[] = new int[n];
        int maxlen = 0;
        int maxind = 0;
        Arrays.fill(prev, -1);
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            if (dp[i] > maxlen) {
                maxlen = dp[i];
                maxind = i;
            }
        }
        List<Integer> ans = new ArrayList<>();
        int k = maxind;
        while (k >= 0) {
            ans.add(nums[k]);
            k = prev[k];
        }
        Collections.reverse(ans);
        return ans;
    }
// ALWAYS PASS IN THE SORTED ARRAY
    @SuppressWarnings("unused")
    private List<Integer> recursive(int[] nums, int prevIndex, int currIndex) {
        if (currIndex == nums.length) {
            return new ArrayList<>();
        }

        // Exclude current element
        List<Integer> exclude = recursive(nums, prevIndex, currIndex + 1);

        List<Integer> include = new ArrayList<>();
        // Include current element if divisible
        if (prevIndex == -1 || nums[currIndex] % nums[prevIndex] == 0) {
            include = recursive(nums, currIndex, currIndex + 1);
            include.add(0, nums[currIndex]); // Add at the beginning
        }

        // Return the longer list
        return include.size() > exclude.size() ? include : exclude;
    }
}
