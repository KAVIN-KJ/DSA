package Trees;
import java.util.*;
public class LcaOfDeepestLeaves {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        Set<TreeNode> deepest = new HashSet<>();

        while(!q.isEmpty()){
            int n = q.size();
            deepest.clear();
            for(int i=0;i<n;i++){
                TreeNode cur = q.poll();
                deepest.add(cur);
                if(cur.left!=null) q.offer(cur.left);
                if(cur.right!=null) q.offer(cur.right);
            }
        }
        return findLca(root,deepest);
    }
    static TreeNode findLca(TreeNode root,Set<TreeNode> deepest){
        if(root==null || deepest.contains(root)) return root;
        TreeNode left = findLca(root.left,deepest);
        TreeNode right = findLca(root.right,deepest);
        if(left!=null && right!=null) return root;
        return left!=null ? left : right;
    }
}
