package ARRAYS;
import java.util.*;
public class FindSecondLargestElement {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = in.nextInt();
        }
        in.close();
        int l = -1;
        int sl = -1;
        for(int i=0;i<n;i++){
            if(arr[i]>l){
                sl = l;
                l = arr[i];
            }
            else if(arr[i]>sl && arr[i] < l){
                sl = arr[i];
            }
        }
        System.out.println("Second largest value is "+sl);
    }
}
