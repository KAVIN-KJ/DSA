package Practice;

import java.util.*;
import java.util.Scanner;

import STRIVER_SDE_SHEET.LongestConsecutiveSequence;

public class Practice {
    static int count = 0;

    public static void main(String[] args) {
        @SuppressWarnings("unused")
        int ans = 0;
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        // ans = maxProfit(arr);

        // int m = in.nextInt();
        // int arr[][] = new int[n][m];
        // for (int i = 0; i < n; i++) {
        // for (int j = 0; j < m; j++) {
        // arr[i][j] = in.nextInt();
        // }
        // }
        // count = 0;
        // countInversions(arr);

        // ans = findDuplicate(arr);

        // gtElementToRight(arr);

        // ans = majorityElement(arr);

        // ans = maxSumSubarray(arr);
        // int trgt = in.nextInt();
        // ans = searchMatrix(arr, trgt);
        ans = longestConsecutiveSequence(arr);
        // for (int i : twosum(arr, trgt)) {
        // System.out.print(i);
        // }
        System.out.println(ans);

        in.close();
    }
    @SuppressWarnings("unused")
    private static int longestConsecutiveSequence(int[] arr) {
        Arrays.sort(arr);
        int ans = 0;
        int prev = Integer.MIN_VALUE;
        int curlen = 0;
        for(int i : arr){
            if(i-1==prev){
                curlen++;
            }
            else if(i!=prev){
                curlen = 1;
            }
            prev = i;
            ans = Math.max(ans,curlen);
        }
        return ans;
    }

    @SuppressWarnings("unused")
    private static int[] twosum(int[] arr, int trgt) {
        int[] ans = new int[2];
        ans[0] = ans[1] = -1;
        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int req = trgt - arr[i];
            if (mp.containsKey(req)) {
                ans[0] = mp.get(req);
                ans[1] = i;
                return ans;
            }
            mp.put(arr[i], i);
        }
        return ans;
    }

    @SuppressWarnings("unused")
    private static int searchMatrix(int[][] arr, int trgt) {
        int low = 0;
        int high = (arr.length * arr[0].length) - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            int temp = arr[mid / arr[0].length][mid % arr[0].length];
            if (temp < trgt) {
                low = mid + 1;
            } else if (temp > trgt) {
                high = mid - 1;
            } else {
                return temp;
            }
        }

        return -1;
    }

    @SuppressWarnings("unused")

    private static int maxSumSubarray(int[] arr) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i : arr) {
            sum += i;
            if (sum > max)
                max = sum;
            if (sum < 0)
                sum = 0;
        }
        return (max > 0) ? max : 0;
    }

    @SuppressWarnings("unused")

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

    @SuppressWarnings("unused")

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

    @SuppressWarnings("unused")

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

    @SuppressWarnings("unused")

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

    @SuppressWarnings("unused")

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