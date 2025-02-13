package Recursion;

import java.util.*;

public class UniqueSubsets {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = in.nextInt();
        }
        in.close();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        uniqueSubsets(0, arr, ans, new ArrayList<Integer>());
        for(ArrayList<Integer> i : ans){
            for(int j : i){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
    static void uniqueSubsets(int ind, int arr[],ArrayList<ArrayList<Integer>> ans,ArrayList<Integer> curr){
            ans.add(new ArrayList<>(curr));
            for(int i=ind;i<arr.length;i++){
                if(i>ind && arr[i]==arr[i-1]) continue;
                curr.add(arr[i]);
                uniqueSubsets(i+1,arr,ans,curr);
            curr.remove(curr.size()-1);
        }
    }
}