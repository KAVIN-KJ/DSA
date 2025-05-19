package Trees;

import java.util.HashMap;

public class BuildTreeFromPre_In {
        public TreeNode buildTree(int[] pre, int[] in) {
        HashMap<Integer,Integer> mpp = new HashMap<>();
        for(int i=0;i<in.length;i++) mpp.put(in[i],i);
        return solve(pre,0,pre.length-1,in,0,in.length-1,mpp);
    }
    static TreeNode solve(int pre[],int pst,int pnd,int in[],int ist,int ind,HashMap<Integer,Integer> mpp){
        if(pst>pnd || ist>ind) return null;

        TreeNode root = new TreeNode(pre[pst]);
        int rind = mpp.get(pre[pst]);
        int lt = rind - ist;

        root.left = solve(pre,pst+1,pst+lt,in,ist,rind-1,mpp);
        root.right = solve(pre,pst+lt+1,pnd,in,rind+1,ind,mpp);

        return root;

    }
}
