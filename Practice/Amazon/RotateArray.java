package Amazon;

import java.util.Scanner;

public class RotateArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = in.nextInt();
        }
        int d = in.nextInt();
        reverse(arr,0,d-1);
        reverse(arr, d, n-1);
        reverse(arr, 0, n-1);
        for(int i =0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        in.close();
    }
    public static void reverse(int arr[],int i,int j){
        while(i<j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}
