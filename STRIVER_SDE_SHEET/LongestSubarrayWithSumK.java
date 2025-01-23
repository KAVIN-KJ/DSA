package STRIVER_SDE_SHEET;

import java.util.HashMap;
import java.util.Scanner;

public class LongestSubarrayWithSumK {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        int k = in.nextInt();
        int len = lengthOfLongest(arr, k);
        System.out.println(len);
        len = countSubArrays(arr, k);
        System.out.println(len);
        len = solveBy2Pointers(arr, k);
        System.out.println(len);
        in.close();
    }

    private static int solveBy2Pointers(int[] arr, int k) {
        int lt = 0, rt=0;
        int len = 0;
        int n = arr.length;
        
        int sum = arr[0];
        while(rt<n){
            while(lt<=rt && sum > k){
                sum-=arr[lt];
                lt++;
            }
            if(sum==k){
                len = Math.max(len,rt-lt+1);
            }
            rt++;
            if(rt<n) sum+=arr[rt];
        }

        return len;
    }

    private static int lengthOfLongest(int[] arr, int k) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        int sum = 0;
        int len = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (mp.getOrDefault(sum - k, -1) != -1) {
                len = Math.max(len, i - mp.get(sum - k));
            }
            if (!mp.containsKey(sum))
                mp.put(sum, i);
        }
        return len;
    }

    public static int countSubArrays(int arr[], int k) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);
        int sum = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (mp.containsKey(sum - k)) {
                count += mp.get(sum - k);
            }
            mp.put(sum, mp.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
