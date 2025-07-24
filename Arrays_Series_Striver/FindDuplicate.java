package Arrays_Series_Striver;

public class FindDuplicate {
    public int findDuplicate(int[] nums) {
        boolean seen[] = new boolean[nums.length];
        for(int i : nums){
            if(!seen[i]) seen[i] = true;
            else return i;
        }
        return 0;
    }
}
