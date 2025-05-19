package Trees;
import java.util.ArrayList;

public class RootToLeafNumSum {
    static ArrayList<Integer> nums;

    public int sumNumbers(TreeNode root) {
        nums = new ArrayList<>();
        helper(root, 0);
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        return sum;
    }

    static void helper(TreeNode root, int cur) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            cur *= 10;
            cur += root.val;
            nums.add(cur);
        }
        int temp = (cur * 10) + root.val;
        helper(root.left, temp);
        helper(root.right, temp);

    }
}
