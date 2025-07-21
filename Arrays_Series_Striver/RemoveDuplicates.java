package Arrays_Series_Striver;

public class RemoveDuplicates {
    public int removeDuplicates(int[] arr) {
        int i = 1;
        for(int n : arr){
            if(n!=arr[i-1]){
                arr[i++] = n;
            }
        }
        return i;
    }
}
