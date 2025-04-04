package Random_Revision;


public class LCA_BST {
    public static TreeNode lca(TreeNode root,TreeNode p,TreeNode q){
        if(root==null || root==p || root==q){
            return root;
        }
        TreeNode lt = lca(root.left,p,q);
        TreeNode rt = lca(root.right,p,q);
        if(lt!=null && rt!=null) return root;
        return lt!=null ? lt : rt;
    }
}
