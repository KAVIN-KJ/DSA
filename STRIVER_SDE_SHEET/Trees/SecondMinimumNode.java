package Trees;

public class SecondMinimumNode {
    public int findSecondMinimumValue(TreeNode root) {
        return solve(root, root.val);
    }

    static int solve(TreeNode root, int min) {
        if (root == null)
            return -1;
        if (root.val > min)
            return root.val;
        int lt = solve(root.left, min);
        int rt = solve(root.right, min);
        if (lt == -1)
            return rt;
        if (rt == -1)
            return lt;
        return Math.min(lt, rt);
    }
}
