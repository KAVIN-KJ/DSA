package Arrays_Series_Striver;
import java.util.*;
public class MergeSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = in.nextInt();
        }
        mergesort(arr,0,n-1);
        for(int i : arr) System.out.print(i+" ");
    }

    private static void mergesort(int[] arr, int l, int r) {
        if(l>=r) return;
        int m = (l+r)/2;
        mergesort(arr, l, m);
        mergesort(arr, m+1, r);
        merge(arr,l,m,r);
    }

    private static void merge(int[] arr, int l, int m, int r) {
        ArrayList<Integer> al = new ArrayList<>();
        int i = l,j = m+1;
        while(i<=m&&j<=r){
            if(arr[i]<=arr[j]){
                al.add(arr[i++]);
            }
            else{
                al.add(arr[j++]);
            }
        }
        while(i<=m){
                al.add(arr[i++]);
        }
        while (j<=r) {
            al.add(arr[j++]);
        }
        i=l;
        for(int x : al){
            arr[i++] = x;
        }
    }
}
