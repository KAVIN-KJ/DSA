package Practice;

import java.util.Scanner;

public class Practice {
    static int count = 0;

    public static void main(String[] args) {
        int ans = 0;
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        // ans = maxProfit(arr);

        count = 0;
        // countInversions(arr);

        // ans = findDuplicate(arr);

        // gtElementToRight(arr);

        // ans = majorityElement(arr);

        // ans = maxSumSubarray(arr);

        

        System.out.println(ans);

        in.close();
    }

    private static int maxSumSubarray(int[] arr) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i : arr){
            sum += i;
            if(sum > max) max = sum;
            if(sum<0) sum = 0;
        }
        return (max>0) ? max : 0;
    }

    private static int majorityElement(int[] arr) {

        int el = arr[0];
        int cnt = 0;
        for (int i : arr) {
            if (cnt == 0) {
                cnt++;
                el = i;
            } else if (i == el) {
                cnt++;
            } else
                cnt--;
        }
        int c = 0;
        for (int i : arr) {
            if (i == el)
                c++;
        }
        return (c > arr.length / 2) ? el : -1;
    }

    private static void gtElementToRight(int[] arr) {

        int max = -1;
        for (int i = arr.length - 1; i >= 0; i--) {
            int newmax = Math.max(arr[i], max);
            arr[i] = max;
            max = newmax;
        }
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    private static int findDuplicate(int[] arr) {
        int slow = arr[0];
        int fast = arr[0];
        do {
            slow = arr[slow];
            fast = arr[arr[fast]];
        } while (slow != fast);
        fast = arr[0];
        while (slow != fast) {
            slow = arr[slow];
            fast = arr[fast];
        }

        return slow;
    }

    private static void countInversions(int[] arr) {
        int n = arr.length;
        if (n <= 1)
            return;
        int lts = arr.length / 2;
        int ltarr[] = new int[lts];
        int rtarr[] = new int[arr.length - lts];
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (i < lts)
                ltarr[i] = arr[i];
            else {
                rtarr[j] = arr[i];
                j++;
            }
        }
        countInversions(ltarr);
        countInversions(rtarr);
        merge(ltarr, rtarr, arr);

    }

    private static void merge(int[] ltarr, int[] rtarr, int[] arr) {
        int n = arr.length;
        int lts = arr.length / 2;
        int rts = n - lts;
        int i = 0, l = 0, r = 0;
        while (l < lts && r < rts) {
            if (ltarr[l] < rtarr[r]) {
                arr[i] = ltarr[l];
                l++;
                i++;
            } else {
                arr[i] = rtarr[r];
                count += (lts - l);
                i++;
                r++;
            }
        }
        while (r < rts) {
            arr[i] = rtarr[r];
            i++;
            r++;
        }
        while (l < lts) {
            arr[i] = ltarr[l];
            i++;
            l++;
        }
    }

    private static int maxProfit(int[] arr) {
        int n = arr.length;
        int min = arr[0];
        int profit = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            profit = Math.max(profit, arr[i] - min);
            min = Math.min(min, arr[i]);
        }
        return profit;
    }

}