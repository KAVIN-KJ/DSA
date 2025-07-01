package Trees;
import java.util.Queue;
import java.util.LinkedList;

public class Sum_Of_Left_Leaves {
        public int sumOfLeftLeaves(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int sum = 0;
        while(!q.isEmpty()){
            TreeNode cur = q.poll();
            if(cur.left!=null && cur.left.left==null && cur.left.right==null){
                sum+=cur.left.val;
            }
            if(cur.left!=null){
                q.offer(cur.left);
            }
            if(cur.right!=null){
                q.offer(cur.right);
            }    
        }
        return sum;
    }
}
