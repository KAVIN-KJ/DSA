public class InterpolationSearch {
    
    public static void main(String[] args){
        int arr[] = new int[100000];
        for(int i=0;i<arr.length;i++){
            arr[i] = i*10;
        }
        int index = interpolationSearch(arr,12340);
        if(index!=-1){
            System.out.println("Found At : "+index);
        }
        else System.out.println("Not Found");
    }

    private static int interpolationSearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int probe =0;
        while(low<=high && target>=arr[low] && target<=arr[high]){
            probe = low + (high-low)*(target - arr[low])/(arr[high] - arr[low]);
            if(target == arr[probe]){
                return probe;
            }
            else if(target>arr[probe]){
                low=probe+1;
            }
            else high = probe-1;
        }
        return -1;
    }
    
}
