package Arrays_Series_Striver;

import java.util.ArrayList;
import java.util.List;

public class MajorityElement2 {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int el1 = nums[0],el2=nums[0],cnt1=0,cnt2=0;
        for(int i : nums){
            if(cnt1==0&&i!=el2){
                el1 = i;
                cnt1 = 1;
            }
            else if(cnt2==0&&i!=el1){
                el2 = i;
                cnt2 = 1;
            }
            else if(i==el1){
                cnt1++;
            }
            else if(i==el2){
                cnt2++;
            }
            else{
                cnt1--;
                cnt2--;
            }
        }
        List<Integer> ans = new ArrayList<>();
        int cnt=0;
        for(int i : nums) if(i==el1) cnt++;
        if(cnt>n/3) ans.add(el1);
        cnt=0;
        for(int i : nums) if(i==el2) cnt++;
        if(cnt>n/3 && el1!=el2) ans.add(el2);
        return ans;
    }
}
