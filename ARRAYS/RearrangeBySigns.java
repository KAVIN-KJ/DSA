package ARRAYS;

public class RearrangeBySigns {
    public int[] rearrangeArray(int[] nums) {
        // ArrayList<Integer> pos = new ArrayList<>();
        // ArrayList<Integer> nig = new ArrayList<>();
        // for(int i : nums){
        //     if(i<0){
        //         nig.add(i);
        //     }
        //     else{
        //         pos.add(i);
        //     }
        // }
        // int p = 0;
        // int n = 0;
        // for(int i=0;i<nums.length;i++){
        //     if(i%2==0){
        //         nums[i] = pos.get(p++);
        //     }
        //     else{
        //         nums[i] = nig.get(n++);
        //     }
        // }
        // return nums;
        int ans[] = new int[nums.length];
        int p = 0;
        int n = 1;
        for(int i : nums){
            if(i<0 && n<ans.length){
                ans[n] = i;
                n+=2;
            }
            else if(i>0 && p<ans.length){
                ans[p] = i;
                p+=2;
            }
        }
        return ans;
    }
}
