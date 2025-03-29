package Trees;

import java.util.*;;

public class FlattenTree {
    TreeNode prev = null;
    void flatten(TreeNode root){
        if(root==null) return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }

    void flatten_Iterative(TreeNode root){
        if(root==null) return;
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while(!s.isEmpty()){
            TreeNode cur = s.pop();
            if(cur.right!=null) s.push(cur.right);
            if(cur.left!=null) s.push(cur.left);
            if(!s.isEmpty()) cur.right = s.peek();
            cur.left = null;
        }
    }

}
