package ARRAYS;

import java.util.HashMap;

public class CountSubarraysWithXorK {
    public long subarrayXor(int arr[], int k) {
        HashMap<Integer,Integer> mpp = new HashMap<>();
        int xor = 0,ans = 0;
        for(int i : arr){
            xor ^= i;
            if(xor==k) ans++;
            if(mpp.containsKey(xor^k)) ans+=mpp.get(xor^k);
            mpp.put(xor,mpp.getOrDefault(xor,0)+1);
        }
        return ans;
    }
}
