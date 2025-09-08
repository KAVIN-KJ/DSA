package ZohoPractice;

public class BalancedTree {
    // Helper function returns height, or -1 if unbalanced
    private int checkHeight(Node root) {
        if (root == null) return 0;

        int left = checkHeight(root.left);
        if (left == -1) return -1; // left subtree not balanced

        int right = checkHeight(root.right);
        if (right == -1) return -1; // right subtree not balanced

        if (Math.abs(left - right) > 1) return -1; // current node unbalanced

        return Math.max(left, right) + 1;
    }

    public boolean isBalanced(Node root) {
        return checkHeight(root) != -1;
    }
}
