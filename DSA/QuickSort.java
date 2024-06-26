public class QuickSort {
public static void main(String[] args) {
    int arr[] = {10,9,1,8,2,7,3,6,4,5};
    quickSort(arr,0,arr.length-1);
    for(int i : arr){
        System.out.print(i+" ");
    }
}

private static void quickSort(int[] arr, int st, int nd) {
    if(nd<=st) return;
    int pivot = partition(arr,st,nd);
    quickSort(arr, st, pivot-1);
    quickSort(arr, pivot+1,nd);
}

private static int partition(int[] arr, int st, int nd) {
    // int i=st-1;
    // int piv = nd;
    // for(int j=st;j<nd;j++){
    //     if(arr[j] < arr[piv]){
    //         i++;
    //         int temp = arr[j];
    //         arr[j] = arr[i];
    //         arr[i] = temp;
    //     }
    // }
    // i++;
    // int temp = arr[i];
    // arr[i] = arr[piv];
    // arr[piv] = temp;
    // return i;

    int piv = nd;
    int x=st-1;
    for(int i=st;i<=nd;i++){
        if(arr[i] < arr[piv]){
            x++;
            int temp = arr[x];
            arr[x] = arr[i];
            arr[i] = temp;
        }
    }
    x++;
    int temp = arr[piv];
    arr[piv] = arr[x];
    arr[x] = temp;
    return x;

}

}