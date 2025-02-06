package Random_Revision;
import java.util.ArrayList;
import java.util.List;


class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        this.val = x;
    }
}


public class SerializeAndDeserialize {
      public String serialize(TreeNode root) {
        List<String> res = new ArrayList<>();
        buildString(root,res);
        return String.join(",",res);
    }
    private static void buildString(TreeNode root, List<String> res){
        if(root==null){
            res.add("N");
            return;
        }
        res.add(String.valueOf(root.val));
        buildString(root.left,res);
        buildString(root.right,res);
    }

    // Decodes your encoded data to tree.
    private static int i = 0;
    public TreeNode deserialize(String data) {  
        System.out.println(data);
        i = 0;
        String arr[] = data.split(",");
        return buildTree(arr);
    }
    private static TreeNode buildTree(String arr[]){
        if(arr[i].equals("N")){
            i++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(arr[i]));
        i++;
        node.left = buildTree(arr);
        node.right = buildTree(arr);
        return node;
    }
}
