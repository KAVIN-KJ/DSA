package STRIVER_SDE_SHEET;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Majority_Element_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++) arr[i] = in.nextInt();
        ArrayList<Integer> ans = solveByHashing(arr);
        ans = mooresVotingAlgorithm(arr);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }

    private static ArrayList<Integer> mooresVotingAlgorithm(int[] arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        int cnt1 = 0;
        int cnt2 = 0;
        int el1 = arr[0];
        int el2 = arr[0];
        int n = arr.length;
        for(int i=0;i<n;i++){
            if(cnt1==0 && arr[i]!=el2){
                el1 = arr[i];
                cnt1++;
            }
            else if(cnt2==0 && arr[i]!=el1){
                el2 = arr[i];
                cnt2++;
            }
            else if(el1==arr[i]) cnt1++;
            else if(el2==arr[i]) cnt2++;
            else{
                    cnt1--;
                    cnt2--;
            }
        }
        cnt1=0;
        cnt2=0;
        for(int i : arr){
            if(i==el1) cnt1++;
            if(i==el2) cnt2++;
        }
        if(cnt1>n/3) ans.add(el1);
        if(cnt2>n/3 && el1!=el2) ans.add(el2);
        return ans;
    }

    private static ArrayList<Integer> solveByHashing(int[] arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int value = map.getOrDefault(arr[i], 0);
            map.put(arr[i], value + 1);
        }
        for (Map.Entry<Integer, Integer> i : map.entrySet()) {
            if (i.getValue() > arr.length / 3) {
                ans.add(i.getKey());
            }
        }
        return ans;
    }
}
