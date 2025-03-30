package Trees;

public class DiamaterOfATree {
    static int ans;
    static int diamater(TreeNode root) {
        ans = Integer.MIN_VALUE;
        height(root);
        return ans;
    }

    private static int height(TreeNode root) {
        if(root==null) return 0;
        int lt = height(root.left);
        int rt = height(root.right);
        ans = Math.max(ans,lt+rt);
        return 1+Math.max(lt,rt);
    }
}
