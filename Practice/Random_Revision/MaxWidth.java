package Random_Revision;

import java.util.LinkedList;
import java.util.Queue;

class Pair{
    TreeNode n;
    int i;
    Pair(TreeNode n,int i){
        this.n = n;
        this.i = i;
    }
}

public class MaxWidth {
    static int MaxWidth(TreeNode root) {
        int ans = (int) -1e9;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,0));
        while(!q.isEmpty()){
            int n = q.size();
            int st=0,nd=0;
            int min= q.peek().i;
            for(int i=0;i<n;i++){
                Pair cur = q.poll();
                cur.i-=min;
                if(i==0) st = cur.i;
                if(i==n-1) nd = cur.i;
                if(cur.n.left!=null) q.add(new Pair(cur.n.left, 2*i+1));
                if(cur.n.left!=null) q.add(new Pair(cur.n.right, 2*i+2));
            }
            ans = Math.max(ans,nd-st+1);
        }
        return ans;
    }
}
