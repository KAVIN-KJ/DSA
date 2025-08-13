package ARRAYS;

public class SortColours {
    public void sortColors(int[] nums) {
        int lt = 0;
        int rt = nums.length-1;
        int mid = 0;
        while(mid<=rt){
            if(nums[mid]==0){
                int temp = nums[mid];
                nums[mid++] = nums[lt];
                nums[lt++] = temp;
            }
            else if(nums[mid]==2){
                int temp = nums[mid];
                nums[mid] = nums[rt];
                nums[rt--] = temp;
            }
            else{
                mid++;
            }
        }
    }
}
