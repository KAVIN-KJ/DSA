package STRIVER_SDE_SHEET;

import java.util.Scanner;

public class CountInversions {
    static int count;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
            long arr[] = new long[n];
        for(int i=0;i<n;i++){
            arr[i] = in.nextInt();
        }
        count=0;
        mergesort(arr);
        System.out.println(count);
        in.close();
    }
    private static void mergesort(long arr[]){
        int n = arr.length;
        int mid = n/2;
        if(n<=1) return;
        int lts = n/2;
        int rts = n - lts;
        long ltarr[] = new long[lts];
        long rtarr[] = new long[rts];
        int j = 0;
        for(int i=0;i<n;i++){
            if(i<mid){
                ltarr[i] = arr[i];
            }
            else{
                rtarr[j] = arr[i];
                j++;
            }
        }
        mergesort(ltarr);
        mergesort(rtarr);
        merge(ltarr,rtarr,arr);
    }
    private static void merge(long ltarr[],long rtarr[],long arr[]){
        int n = arr.length;
        int mid = n/2;
        int lts = mid;
        int rts = n - lts;
        int i=0,l=0,r=0;
        while(l<lts && r<rts){
            if(ltarr[l] < rtarr[r]){
                arr[i] = ltarr[l];
                l++;
                i++;
            }
            else{
                arr[i] = rtarr[r];
                count += lts - l;
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
