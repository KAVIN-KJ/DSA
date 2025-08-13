package ARRAYS;
import java.util.*;
public class CheckIfArrayIsSorted {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=in.nextInt();
        }
        int count  =0;
        for(int i=0;i<n;i++){
            if(arr[i]>arr[(i+1)%n]) count++;
        }
        in.close();
        System.out.println(count<=1 ? "Yes" : "No");
    }
}
