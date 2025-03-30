package Trees;

import java.util.ArrayList;
import java.util.List;

public class TreePathsToLeafNodes {
    static List<String> ans;
    public List<String> binaryTreePaths(TreeNode root) {
        ans = new ArrayList<>();
        traverse(root,new StringBuilder());
        return ans;
    }
    static void traverse(TreeNode root,StringBuilder cur){
        if(root==null) return;
        int n = cur.length();
        if(n>0) cur.append("->");
        cur.append(root.val);
        if(root.left==null && root.right==null){
            ans.add(cur.toString());
        }
        else{
            traverse(root.left,cur);
            traverse(root.right,cur);
        }
        cur.setLength(n);
    }
}
