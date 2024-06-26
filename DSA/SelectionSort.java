public class SelectionSort {
    public static void main(String[] args) {
        int arr[] = {8,7,3,4,6,5,1,9,2,0};
        sort(arr);
        for(int i : arr){
            System.out.print(i+" ");
        }
        
    }

    public static void sort(int[] arr){
        for(int i=0;i<arr.length;i++){
            int min = i;
            for(int j=i;j<arr.length;j++){
                if(arr[j]<arr[min]){
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }

}
