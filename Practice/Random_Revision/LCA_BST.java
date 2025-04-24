package Random_Revision;
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return root;
        if(root==p||root==q) return root;
        TreeNode lt = lowestCommonAncestor(root.left,p,q);
        TreeNode rt = lowestCommonAncestor(root.right,p,q);
        if(lt!=null && rt!=null) return root;
        return lt!=null ? lt : rt;
    }
}