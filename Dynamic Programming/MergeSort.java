import java.util.*;

public class MergeSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = in.nextInt();
        }
        mergeSort(arr);
        System.out.println();
        System.out.println();
        System.out.println();

        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println();
        System.out.println();
        in.close();
    }

    private static void mergeSort(int[] arr) {
        if(arr.length<=1) return;
        int n = arr.length;
        int mid = n / 2;
        int lts = n / 2;
        int rts = n - lts;
        int ltarr[] = new int[lts];
        int rtarr[] = new int[rts];
        int i = 0, r = 0;
        for (; i < n; i++) {
            if (i < mid)
                ltarr[i] = arr[i];
            else {
                rtarr[r] = arr[i];
                r++;
            }
        }
        mergeSort(ltarr);
        mergeSort(rtarr);
        merge(ltarr, rtarr, arr);
    }

    private static void merge(int[] ltarr, int[] rtarr, int[] arr) {
        int l=0,r=0,i=0;
        int lts = ltarr.length;
        int rts = rtarr.length;
        while(l<lts && r<rts){
            if(ltarr[l] < rtarr[r]){
                arr[i] = ltarr[l];
                i++;
                l++;
            }
            else{
                arr[i] = rtarr[r];
                i++;
                r++;
            }
        }
        while(l<lts){
            arr[i] = ltarr[l];
            i++;
            l++;
        }
        while(r<rts){
            arr[i] = rtarr[r];
            i++;
            r++;
        }
    }

}
