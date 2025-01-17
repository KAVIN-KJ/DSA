package STRIVER_SDE_SHEET;
// LC HAAARRDD !! 💥💥💥🗿🗿
import java.util.ArrayList;
import java.util.Scanner;

public class ReversePairs {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        int ans = countPairs(arr, 0, n - 1);
        System.out.println(ans);
        in.close();

    }

    private static int countPairs(int[] arr, int l, int h) {
        int ans = 0;
        if (l >= h)
            return 0;
        int mid = (l + h) / 2;
        ans += countPairs(arr, l, mid);
        ans += countPairs(arr, mid + 1, h);
        ans += countInversions(arr, l, mid, h);
        merge(arr, l, mid, h);
        return ans;
    }

    private static int countInversions(int[] arr, int l, int mid, int h) {
        int ans = 0;
        int r = mid+1;
        for(int i=l;i<=mid;i++){
            while(r<=h && (long)arr[i] > (long)2*arr[r]){
                r++;
            }
            ans += (r-(mid+1));
        }
        return ans;
    }

    private static void merge(int[] arr, int lo, int mid, int hi) {
        ArrayList<Integer> al = new ArrayList<>();
        int l = lo;
        int r = mid + 1;
        while (l <= mid && r <= hi) {
            if (arr[l] <= arr[r]) {
                al.add(arr[l]);
                l++;
            } else {
                al.add(arr[r]);
                r++;
            }
        }
        while (l <= mid) {
            al.add(arr[l]);
            l++;
        }
        while (r <= hi) {
            al.add(arr[r]);
            r++;
        }
        int x = lo;
        for (int i : al) {
            arr[x] = i;
            x++;
        }
        return;
    }
}
