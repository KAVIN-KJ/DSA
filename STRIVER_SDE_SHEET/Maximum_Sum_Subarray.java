package STRIVER_SDE_SHEET;

import java.util.*;

public class Maximum_Sum_Subarray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        int start=-1,end=-1;
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        for (int i = 0; i < n; i++) {
            currSum += arr[i];

            if(currSum > maxSum){
                maxSum = currSum;
                end = i;
            }
            if(currSum < 0){
                currSum = 0;
                start = i+1;
            }
        }
        System.out.println(maxSum);
        for(int i=start;i<=end;i++){
            System.out.print(arr[i]+" ");
        }
        in.close();
    }
}
