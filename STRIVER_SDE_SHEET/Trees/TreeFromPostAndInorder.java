package Trees;

import java.util.*;

public class TreeFromPostAndInorder {
    public TreeNode buildTree(int[] ino, int[] post) {

        HashMap<Integer,Integer> mpp = new HashMap<>();
        for(int i=0;i<ino.length;i++) mpp.put(ino[i],i);
        return solve(0,ino.length-1,ino,0,post.length-1,post,mpp);

    }
    
    static TreeNode solve(int ins,int ind,int[] ino,int pos,int pnd,int[] post,HashMap<Integer,Integer> mpp){
        if(ins>ind || pos>pnd) return null;
        TreeNode root = new TreeNode(post[pnd]);
        int rootind = mpp.get(post[pnd]);
        int lt = rootind - ins;
        root.left = solve(ins,rootind-1,ino,pos,pos+lt-1,post,mpp);
        root.right = solve(rootind+1,ind,ino,pos+lt,pnd-1,post,mpp);
        return root;
    }

}
