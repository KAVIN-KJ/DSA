package ARRAYS;

import java.util.ArrayList;
import java.util.Collections;

public class LeadersInArray {
    static ArrayList<Integer> leaders(int arr[]) {
        // code here
        int prev = Integer.MIN_VALUE;
        ArrayList<Integer> al = new ArrayList<>();
        int n = arr.length;
        for(int i=n-1;i>=0;i--){
            if(arr[i]>=prev){
                al.add(arr[i]);
                prev = arr[i];
            }
        }
        Collections.reverse(al);
        return al;
    }
}
