package Arrays_Series_Striver;
import java.util.*;
public class ThreeSum {
     public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> al = new ArrayList<>();
        for(int i=0;i<nums.length-2;i++){
            if(i>0&&nums[i-1]==nums[i]) continue;
            int lt = i+1;
            int rt = nums.length-1;
            while(lt<rt){
                int sum = nums[lt]+nums[rt]+nums[i];
                if(sum<0) lt++;
                else if(sum>0) rt--;
                else{
                    al.add(Arrays.asList(nums[i],nums[lt],nums[rt]));
                    while(lt<rt&&nums[lt]==nums[lt+1]) lt++;
                    while(lt<rt&&nums[rt]==nums[rt-1]) rt--;
                    lt++;
                    rt--;
                }
            }
        }
        return al;
    }
}
