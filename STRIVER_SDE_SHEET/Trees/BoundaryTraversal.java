package Trees;
import java.util.ArrayList;
import java.util.Collections;

public class BoundaryTraversal {
    void leftBound(Node root,ArrayList<Integer> res){
        if(root==null) return;
        Node temp = root.left;
        while(temp!=null){
            if(temp.left!=null || temp.right!=null) res.add(temp.data);
            if(temp.left!=null) temp=temp.left;
            else temp = temp.right;
        }
        
    }
    
    void rightBound(Node root,ArrayList<Integer> res){
        if(root==null) return;
        ArrayList<Integer> temp = new ArrayList<>();
        Node tp = root.right;
        while(tp!=null){
            if(tp.left!=null || tp.right!=null) temp.add(tp.data);
            if(tp.right!=null) tp = tp.right;
            else tp = tp.left;
        }
        Collections.reverse(temp);
        res.addAll(temp);
    }
    
    void leafNodes(Node root,ArrayList<Integer> res){
        if(root==null) return;
        if(root!=null && root.left==null && root.right==null){
            res.add(root.data);
            return;
        }
        leafNodes(root.left,res);
        leafNodes(root.right,res);
    }
    
    
    
    ArrayList<Integer> boundaryTraversal(Node node) {
        // code here
        ArrayList<Integer> al = new ArrayList<>();
        if(node==null) return al;
        if(node.left==null && node.right==null){
            al.add(node.data);
            return al;
        }
        al.add(node.data);
        leftBound(node,al);
        leafNodes(node,al);
        rightBound(node,al);
        return al;
    }
}
