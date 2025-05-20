package Trees;

public class BuildTreeFromSorted {
    public TreeNode sortedArrayToBST(int[] nums) {
        return insert(0,nums.length-1,nums);
    }
    static TreeNode insert(int st,int nd,int nums[]){
       if(st==nd) return new TreeNode(nums[st]);
       if(st>nd) return null;
       int mid = (st+nd)/2;
       TreeNode root = new TreeNode(nums[mid]);
       root.left = insert(st,mid-1,nums);
       root.right = insert(mid+1,nd,nums);
       return root;
    }
}
