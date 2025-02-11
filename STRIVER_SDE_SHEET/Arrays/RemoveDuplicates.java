package Arrays;

import java.util.Scanner;

public class RemoveDuplicates {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        in.close();
        int k = removeDuplicates(arr);
        for(int i=0;i<k;i++){
            System.out.print(arr[i]+" ");
        }
    }

    private static int removeDuplicates(int[] arr) {
        int n = arr.length;
        if(n==0) return 0;
        int j = 1;
        for(int i=1;i<n;i++){
            if(arr[i]!=arr[i-1]){
                arr[j] = arr[i];
                j++;
            }
        }
        return j;
    }
}
