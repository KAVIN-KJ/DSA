
public class BinarySearch{
    public static void main(String args[]){
        int arr[] = new int[1000000];
        for(int i=0;i<arr.length;i++){
            arr[i] = i;
        }
        int index = binarySearch(arr,123);
        System.out.println("Found Target at index : " + index);
    }

    private static int binarySearch(int[] arr, int trgt) {
        int low = 0;
        int high = arr.length -1;
        int mid=0,value=0;
        while(low<=high){
            mid = (low+high)/2;
            value = arr[mid];
            if(value>trgt){
                high = mid-1;
            }
            else if(value<trgt) low = mid+1;
            else return mid;
        }
        return -1;
    }
}