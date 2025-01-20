package STRIVER_SDE_SHEET;

import java.util.*;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        int ans = solve(arr);
        System.out.println(ans);
    }

    private static int solve(int[] arr) {
        Arrays.sort(arr);
        int ans = 0;
        int prev = Integer.MIN_VALUE;
        int curlen = 0;
        for(int i : arr){
            if(i-1 == prev){
                curlen++;
                prev = i;
            }
            else if(i != prev){
                curlen = 1;
                prev = i;
            }
            ans = Math.max(ans,curlen);
        }
        return ans;
    }
}
