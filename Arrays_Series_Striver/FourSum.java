package Arrays_Series_Striver;
import java.util.*;
public class FourSum {
        public List<List<Integer>> fourSum(int[] arr, int trgt) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        int n = arr.length;
        for(int a=0;a<n;a++){
            if(a>0&&arr[a-1]==arr[a]) continue;
            for(int b=a+1;b<n;b++){
                if(b>a+1&&arr[b-1]==arr[b]) continue;
                int c = b+1;
                int d = n-1;
                while(c<d){
                    long sum = 0L+ arr[a]+arr[b]+arr[c]+arr[d];
                    if(sum<trgt) c++;
                    else if(sum>trgt) d--;
                    else{
                        ans.add(Arrays.asList(arr[a],arr[b],arr[c],arr[d]));
                        while(c<d&&arr[c+1]==arr[c]) c++;
                        while(c<d&&arr[d-1]==arr[d]) d--;
                        c++;
                        d--;
                    }
                }
            }
        }
        return ans;
    }
}
