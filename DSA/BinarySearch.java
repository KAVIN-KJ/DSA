
public class BinarySearch{
    public static void main(String args[]){
        int arr[] = new int[1000000];
        for(int i=0;i<arr.length;i++){
            arr[i] = i;
        }
        int index = binarySearch(arr,777777);
        System.out.println("Found Target at index : " + index);
    }

    private static int binarySearch(int[] arr, int trgt) {
        int low = 0;
        int high = arr.length -1;
        int value = 0;
        while(low<=high){
            int mid = (low+high)/2;
            value = arr[mid];
            System.out.println("Mid Value : "+ value);
            if(trgt<value){
                high = mid-1;
            }
            else if(trgt > value){
                low = mid  +1;
            }
            else{
                return mid;
            }
        }

       return -1;
    }
}