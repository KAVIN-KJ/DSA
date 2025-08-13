package ARRAYS;

import java.util.Arrays;

public class MinimumPlatforms {
     static int findPlatform(int arr[], int dep[]) {
        // add your code here
        int min = 1;
        int cur = 0;
        int i=0;
        int j=0;
        Arrays.sort(arr);
        Arrays.sort(dep);
        while(i<arr.length &&j<dep.length){
            if(arr[i]<=dep[j]){
                cur++;
                i++;
            } 
            else{
                cur--;
                j++;
            } 
            min = Math.max(min,cur);
        }
        while(i++<arr.length){
            min++;
        } 
        return min;
    }
}
