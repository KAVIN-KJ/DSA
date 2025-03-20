// package Trees;

public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        int ht = height(root);
        return (ht>0);   
    }
    static int height(TreeNode root){
        if(root==null) return 0;
        int lt = height(root.left);
        int rt = height(root.right);
        if(Math.abs(lt-rt)>1 || lt<0 || rt<0) return -1;
        return 1+Math.max(lt,rt);
    }
}
