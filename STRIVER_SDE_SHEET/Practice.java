package STRIVER_SDE_SHEET;

import java.util.Scanner;

public class Practice {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = in.nextInt();

        // 1. BUY AND SELL STOCK
        // System.out.println(buysellstock(arr, n));

        // 2. GT ELEMENT TO RIGHT
        // gtElementToRight(arr, n);

        // 3. MAX SUM SUBARRAY
        // int sum = maxSumSubarray(arr, n);
        // System.out.println(sum);

        // 4. NEXT PERMUTATION

        // nextPerm(arr);

        // 5. PASCAL'S TRIANGLE

        // int a = ncr(6, 2);
        // System.out.println(a);
        // System.out.println();

        // 6. SORT 0S, 1S AND 2S

        dnfAlgorithm(arr);
        for (int i : arr)
            System.out.print(i + " ");

        in.close();
    }

    private static void dnfAlgorithm(int[] arr) {
        int low = 0;
        int mid = 0;
        int high = arr.length-1;
        while(mid<high){
            if(arr[mid]==0){
                int temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;
                mid++;
                low++;
            }
            if(arr[mid]==1){
                mid++;
            }
            if(arr[mid]==2){
                int temp = arr[high];
                arr[high] = arr[mid];
                arr[mid] = temp;
                high--;
            }
        }
    }

    private static int ncr(int n, int r) {
        int res = 1;
        for (int i = 0; i < r; i++) {
            res = res * (n - i);
            res = res / (i + 1);
        }
        return res;
    }

    private static void nextPerm(int[] arr) {
        int n = arr.length;
        int ind = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                ind = i;
                break;
            }
        }
        if (ind == -1) {
            int lt = 0;
            int rt = n - 1;
            while (lt < rt) {
                int temp = arr[lt];
                arr[lt] = arr[rt];
                arr[rt] = temp;
                lt++;
                rt--;
            }
            return;
        }
        for (int i = n - 1; i >= ind; i--) {
            if (arr[i] > arr[ind]) {
                int temp = arr[i];
                arr[i] = arr[ind];
                arr[ind] = temp;
                break;
            }
        }
        int lt = ind + 1;
        int rt = n - 1;
        while (lt < rt) {
            int temp = arr[lt];
            arr[lt] = arr[rt];
            arr[rt] = temp;
            lt++;
            rt--;
        }
    }

    private static int maxSumSubarray(int[] arr, int n) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            max = Math.max(max, sum);
            if (sum < 0)
                sum = 0;
        }
        return max;
    }

    private static void gtElementToRight(int[] arr, int n) {
        int gt = -1;
        for (int i = n - 1; i >= 0; i--) {
            int max = Math.max(arr[i], gt);
            arr[i] = gt;
            gt = max;
        }
    }

    private static int buysellstock(int[] arr, int n) {
        int maxprofit = Integer.MIN_VALUE;
        int min = arr[0];
        for (int i = 0; i < n; i++) {
            maxprofit = Math.max(maxprofit, arr[i] - min);
            min = Math.min(min, arr[i]);
        }

        return maxprofit;
    }

}
