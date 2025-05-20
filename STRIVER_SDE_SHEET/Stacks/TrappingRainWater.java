package Stacks;

import java.util.Scanner;

public class TrappingRainWater {
    static int trap(int[] arr) {
        int n = arr.length;
        int pref[] = new int[n];
        int suff[] = new int[n];
        pref[0] = arr[0];
        suff[n-1] = arr[n-1];
        for(int i=1;i<n;i++) pref[i] = Math.max(pref[i-1],arr[i]);
        for(int i=n-2;i>=0;i--) suff[i] = Math.max(suff[i+1],arr[i]);

        int total = 0;
        for(int i=0;i<n;i++){
            total +=(Math.min(pref[i],suff[i]) - arr[i]);
        }
        return total;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for(int i = 0;i < n;i ++) arr[i] = in.nextInt();
        System.out.println(trap(arr));
        in.close();
    }

}
