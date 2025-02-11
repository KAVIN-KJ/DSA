package Arrays;

import java.util.Scanner;

public class MaxConsecutiveOnes {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = in.nextInt();
        }
        System.out.println("Maximum consecutive ones : "+findMaxConsecutiveOnes(arr));
        in.close();
    }
    static int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int curmax = 0;
        for(int i : nums){
            if(i==1){
                curmax++;
                max = Math.max(max,curmax);
            }
            else{
                curmax = 0;
            }
        }
        return max;
    }
}