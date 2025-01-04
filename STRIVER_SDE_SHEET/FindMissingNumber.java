package STRIVER_SDE_SHEET;

import java.util.Scanner;

public class FindMissingNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = in.nextInt();
        }
        in.close();
        int hash[] = new int[n+1];
        for(int i=0;i<n;i++){
            hash[arr[i]]++;
        }
        int i = -1;
        for(i=1;i<=n;i++){
            if(hash[i]<=0){
                break;
            }
        }
        System.out.println(i);
    }
}
