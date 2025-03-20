public class MaximumPathSum {
    public int maxPathSum(TreeNode root) {
        int[] maxi = new int[]{(int)-1e9};
        solve(root,maxi);
        return maxi[0];
    }
    static int solve(TreeNode root,int[] maxi){
        if(root==null) return 0;
        int lt = solve(root.left,maxi);
        int rt = solve(root.right,maxi);
        if(lt<0) lt = 0;
        if(rt<0) rt = 0;
        maxi[0] = Math.max(maxi[0],lt+rt+root.val);
        return root.val + Math.max(lt,rt);
    }
}
