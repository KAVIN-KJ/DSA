package Trees;

import java.util.LinkedList;
import java.util.Queue;

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

public class NextRightPointer {
    public Node connect(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        if(root==null) return root;
        if(root!=null) root.next=null;
        Node prev = null;
        while(!q.isEmpty()){
            int n = q.size();
            prev = null;
            for(int i=0;i<n;i++){
            Node cur = q.poll();
            if(prev!=null) prev.next = cur.left;
            if(cur!=null && cur.left!=null){
                cur.left.next = cur.right;
                prev = cur.right;
            }
            if(cur.left!=null) q.offer(cur.left);
            if(cur.right!=null) q.offer(cur.right);
            }
        }
        return root;
    }   
}
