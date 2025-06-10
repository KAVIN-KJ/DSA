import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = in.nextInt();
        }
        Arrays.sort(arr);
        int search = in.nextInt();
        in.close();
        int lt = 0;
        int rt = n-1;
        while(lt<rt){
            int mid = (lt+rt)/2;
            if(search==arr[mid]){
                System.out.println("Found !");
                return;
            }
            else if(search>arr[mid]){
                lt=mid+1;
            }
            else if(search<arr[mid]){
                rt = mid-1;
            }
        }
        System.out.println("Not Found");
    }
}
