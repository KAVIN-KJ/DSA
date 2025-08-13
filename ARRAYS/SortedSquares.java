package ARRAYS;

public class SortedSquares {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = n-1;
        int i = n-1;
        int ans[] = new int[n];
        while(i>=0){
            if(nums[l]*nums[l] > nums[r]*nums[r]){
                ans[i--] = nums[l]*nums[l++]; 
            }
            else{
                ans[i--] = nums[r]*nums[r--]; 
            }
        }
        return ans;
    }
}
