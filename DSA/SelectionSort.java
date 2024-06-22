public class SelectionSort {
    public static void main(String[] args) {
        int arr[] = {8,7,3,4,6,5,1,9,2,0};
        sort(arr);
        for(int i : arr){
            System.out.print(i+" ");
        }
    }

    public static void sort(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            int min=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[min] > arr[j]) min = j;
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }

}
