package Trees;

import java.util.*;

public class MaxWidth {


    class Pair{
        TreeNode node;
        int ind;
        Pair(TreeNode node,int ind){
            this.node = node;
            this.ind = ind;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root,0));
        int width = Integer.MIN_VALUE;
        while(!q.isEmpty()){
            int front = 0;
            int last = 0;
            int n = q.size();
            int min = q.peek().ind;
            for(int i=0;i<n;i++){
                Pair p = q.poll();
                TreeNode cur = p.node;
                int ind = p.ind-min;
                if(i==0) front = ind;
                if(i==n-1) last = ind;
                if(cur.left!=null) q.offer(new Pair(cur.left,ind*2));
                if(cur.right!=null) q.offer(new Pair(cur.right,(ind*2)+1));
            }
            width = Math.max(width,last-front+1);
        }
        return width;
    }


}
