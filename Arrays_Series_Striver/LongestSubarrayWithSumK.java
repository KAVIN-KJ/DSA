package Arrays_Series_Striver;

import java.util.HashMap;

public class LongestSubarrayWithSumK {
    public int betterApproach(int arr[],int k){
        int ans = 0,sum=0,n=arr.length;
        HashMap<Integer,Integer> mpp = new HashMap<>();
        for(int i=0;i<n;i++){
            sum+=arr[i];
            if(sum==k) ans = i+1;
            if(mpp.containsKey(sum-k)) ans = Math.max(ans,i-mpp.get(sum-k));
            mpp.putIfAbsent(sum, i);
        }
        return ans;
    }
    public int optimalForOnlyPositives(int arr[],int k){
        int i=0,j=0,sum = 0, len = 1;
        while(j<arr.length){
            sum+=arr[j++];
            if(sum==k) len = Math.max(len,j-i);
            if(sum>k){
                sum-=arr[i++];
            }
        }
        return len;
    }
}
