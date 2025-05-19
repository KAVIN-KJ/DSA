package Trees;

public class KthSmallestNode {
    static int res = 0, count = 0;

    public int kthSmallest(TreeNode root, int k) {
        res = 0;
        count = 0;
        inorder(root, k);

        return res;
    }

    static void inorder(TreeNode root, int k) {
        if (root == null)
            return;
        inorder(root.left, k);
        count++;
        if (k == count) {
            res = root.val;
            return;
        }
        inorder(root.right, k);
    }
}