package Arrays_Series_Striver;

public class MajorityElement1 {
    public int majorityElement(int[] nums) {
        int el = nums[0];
        int cnt = 0;
        for(int i : nums){
            if(i==el) cnt++;
            else cnt--;
            if(cnt==0){
                el = i;
                cnt=1;
            }
        }
        return el;
    }
}
