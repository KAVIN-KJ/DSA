package Trees;

public class ValidBST {
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        return solve(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    static boolean solve(TreeNode root,long lwr,long upr){
        if(root==null) return true;
        if(!(root.val > lwr && root.val < upr)) return false;
        return solve(root.left,lwr,(long)root.val)&&solve(root.right,(long)root.val,upr);
    }
}
