package Trees;

import java.util.*;

public class SymmetricBinaryTree {
     public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root.left);
        q.offer(root.right);
        while(!q.isEmpty()){
            TreeNode r1 = q.poll();
            TreeNode r2 = q.poll();
            if(r1==null && r2==null) continue;
            if(r1==null || r2==null || r1.val!=r2.val) return false;
            q.offer(r1.left);
            q.offer(r2.right);
            q.offer(r1.right);
            q.offer(r2.left);
        }
        return true;
    }
}
