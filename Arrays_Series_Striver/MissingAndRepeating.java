package Arrays_Series_Striver;

import java.util.ArrayList;

public class MissingAndRepeating {
        ArrayList<Integer> findTwoElement(int arr[]) {
        // code here
        int n = arr.length;
        long s = 0;
        long s2 = 0;
        for(int i : arr){
            s+=i;
            s2+=((long)i*i);
        }
        long sn = 1L*n*(n+1)/2;
        long s2n = 1L*n*(n+1)*(2*n+1)/6;
        long diff1 = s-sn;
        long diff2 = (s2-s2n)/diff1;
        long x = (diff1+diff2)/2;
        long y = diff2-x;
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add((int)x);
        ans.add((int)y);
        return ans;
    }
}
