import java.util.*;
public class PivotIndex {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = in.nextInt();
        }
        System.out.println("Pivot index : "+solve(arr,n));
        in.close();
    }

    private static int solve(int[] arr, int n) {
        int tot = 0;
        for(int i : arr){
            tot+=i;
        }
        int ltsum = 0;
        for(int i=0;i<n;i++){
            int rtsum = tot - arr[i] - ltsum;
            if(ltsum==rtsum) return i;
            ltsum += arr[i];
        }
        return -1;
    }
}
