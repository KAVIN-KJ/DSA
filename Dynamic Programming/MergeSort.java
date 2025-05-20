import java.util.*;

public class MergeSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        mergeSort(arr, 0, n-1);
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

    private static void mergeSort(int[] arr, int low, int high) {
        if(low>=high) return;
        int mid = (low + high) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>();
        int r = mid+1;
        int l = low;
        while(l<=mid && r<=high){
            if(arr[l]<=arr[r]){
                temp.add(arr[l]);
                l++;
            }
            else{
                temp.add(arr[r]);
                r++;
            }
        }
        while(l<=mid){
            temp.add(arr[l]);
            l++;
        }
        while (r<=high) {
            temp.add(arr[r]);
            r++;
        }
        int x=low;
        for(int i : temp){
            arr[x] = i;
            x++;
        }
    }

}
