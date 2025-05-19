package Trees;
import java.util.*;

public class ZigZagTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean ltr = true;
        while(!q.isEmpty()){
            int n = q.size();
            List<Integer> level = new ArrayList<>();
            for(int i=0;i<n;i++){
                TreeNode cur = q.poll();
                if(ltr){
                    level.add(cur.val);
                }
                else level.addFirst(cur.val);
                if(cur.left!=null) q.add(cur.left);
                if(cur.right!=null) q.add(cur.right);
            }
            ltr=!ltr;
            ans.add(level);
        }
        return ans;
    }
}
