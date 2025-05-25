import java.util.HashMap;
import java.util.Scanner;

public class Two_Sum {

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> mpp = new HashMap<>();
        int ans[] = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int req = target - nums[i];
            if (mpp.containsKey(req)) {
                ans[0] = mpp.get(req);
                ans[1] = i;
            }
            mpp.put(nums[i], i);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        in.close();
    }

}
