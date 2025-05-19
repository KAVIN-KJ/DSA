package Amazon;
import java.util.*;
public class MaxSumSubarray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = in.nextInt();
        }
        in.close();
        int ans = arr[0];
        int curmax = arr[0];
        for(int i=0;i<n;i++){
            curmax = Math.max(arr[i]+curmax,arr[i]);
            ans = Math.max(curmax, ans);
        }
        
        System.out.println("Max sum subarray : "+ans);


    }
}
