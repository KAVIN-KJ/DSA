package Arrays;

import java.util.Scanner;

public class Next_Permutation {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = in.nextInt();
        }
        int ind = -1;
        for(int i=n-2;i>=0;i--){
            if(arr[i]<arr[i+1]){
                ind = i;
                break;
            }
        }
        if(ind == -1) {
            for(int i=n-1;i>=0;i--){
                System.out.print(arr[i]);
            }
        }
        for(int i=n-1;i>=ind;i--){
            if(arr[i]>arr[ind]){
                int temp = arr[i];
                arr[i] = arr[ind];
                arr[ind] = temp;
                break;
            }
        }
        int lt = ind+1;
        int rt = n-1;
        while(lt<rt){
            int temp = arr[lt];
            arr[lt] = arr[rt];
            arr[rt] = temp;
            lt++;
            rt--;
        }
        for(int i=0;i<n;i++){
            System.out.print(arr[i]);
        }
        in.close();
    }
}