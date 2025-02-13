package Recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class SubsetSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = in.nextInt();
        }
        ArrayList<Integer> ans = new ArrayList<>();
        subsetSum(0,arr,ans,0);
        for(int i : ans) System.out.print(i+" ");
        System.out.println();
        in.close();
    }
    static void subsetSum(int i,int arr[],ArrayList<Integer> ans,int sum){
        if(i==arr.length){
            ans.add(sum);
            return;
        }
        subsetSum(i+1,arr,ans,sum+arr[i]);
        subsetSum(i+1,arr,ans,sum);
    }
}
