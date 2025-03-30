package Trees;

import java.util.*;

public class RootEqualsChildrenSum {
    public static boolean isSumProperty(TreeNode root)
    {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode cur = q.poll();
            int sum = 0;
            if(cur.left!=null){
                sum+=cur.left.val;
                q.offer(cur.left);
            }
            if(cur.right!=null){
                sum+=cur.right.val;
                q.offer(cur.right);
            }
            if(cur.left!=null || cur.right!=null){
                if(cur.val!=sum) return false;
            }
        }
        return true;   
        
    }
}
