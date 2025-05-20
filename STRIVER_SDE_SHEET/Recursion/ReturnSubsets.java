package Recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class ReturnSubsets {
     public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = in.nextInt();
        }
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        subset(0,arr,ans,new ArrayList<>());
        for(ArrayList<Integer> i : ans){
            for(int j : i)
                System.out.print(j+" ");
            System.err.println();
        }
        System.out.println();
        in.close();
    }
    static void subset(int i,int arr[],ArrayList<ArrayList<Integer>> ans,ArrayList<Integer> curr){
            if(i==arr.length){
                ans.add(new ArrayList<>(curr));
                return;
            }
            curr.add(arr[i]);
            subset(i+1,arr,ans,curr);
            curr.remove(curr.size()-1);
            subset(i+1,arr,ans,curr);
    }
}
