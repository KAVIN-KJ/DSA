
// package Trees;
import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left = null;
    TreeNode right = null;
}

public class PathSum {
    static List<List<Integer>> list;

    public boolean hasPathSum(TreeNode root, int trgt) {
        if (root == null) {
            return (false);
        }
        if (root.left == null && root.right == null) {
            return root.val == trgt;
        }
        return hasPathSum(root.left, trgt - root.val) || hasPathSum(root.right, trgt - root.val);
    }

}

class Pathsum_2 {
    static List<List<Integer>> list;
    public List<List<Integer>> pathSum(TreeNode root, int trgt) {
        list = new ArrayList<>();
        sum(root,trgt,new ArrayList<>());
        return list;
    }
    public static void sum(TreeNode root,int trgt,List<Integer> curr){
        if(root==null) return;
        if(root.left == null && root.right == null){
            if(root.val == trgt){
                curr.add(trgt);
                list.add(new ArrayList<>(curr));
                curr.remove(curr.size()-1);
            }
            return;
        }
        curr.add(root.val);
        sum(root.left,trgt-root.val,curr);
        sum(root.right,trgt-root.val,curr);
        curr.remove(curr.size()-1);
    }
}