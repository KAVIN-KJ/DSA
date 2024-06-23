public class QuickSort {
    public static void main(String[] args) {
        int arr[] = {8,4,5,3,9,7,6,1,10,2};
        quickSort(arr,0,arr.length-1);   
        for(int i : arr){
            System.out.print(i+" ");
        }
    }

    private static void quickSort(int[] arr, int st, int nd) {
        if(nd<=st) return;
        int pivot = partition(arr,st,nd);
        quickSort(arr, st, pivot-1);
        quickSort(arr, pivot+1, nd);
    }

    private static int partition(int[] arr, int st, int nd) {
        int i=st-1;
        for(int j=st;j<nd;j++){
            if(arr[j] < arr[nd]){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        i++;
        int temp = arr[i];
        arr[i] = arr[nd];
        arr[nd] = temp;
        return i;
    }
}
