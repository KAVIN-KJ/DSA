// 1. Replace every element with the greatest element on right side

package Arrays_and_Hashing;
import java.util.*;
public class GreatestElementsToRight {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = in.nextInt();
        }
        // iterate from last - maximum so far towards the right is = -1
        // calculate newMaximum from comparing current element and right max
        // set current element to rightMax;
        // set rightMax to newMax
        int rightMax = -1;
        for(int i=arr.length-1;i>=0;i--){
            int newMax = Math.max(arr[i],rightMax);
            arr[i] = rightMax;
            rightMax = newMax;
        }
        for(int i : arr)
            System.out.print(i+" ");
        in.close();
    }
}
