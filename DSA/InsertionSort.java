public class InsertionSort {
    public static void main(String[] args) {
        int arr[] = {8,7,3,4,6,5,1,9,2,0};
        insertSort(arr);
        for(int i : arr){
            System.out.print(i+" ");
        }
    }

    private static void insertSort(int[] arr) {
       for(int i=1;i<arr.length;i++){
         int j=i-1;
         int temp = arr[i];
         while(j>=0 && arr[j]>temp){
            arr[j+1] = arr[j];
            j--;
         }
         arr[j+1] = temp;
       }
    }
}
