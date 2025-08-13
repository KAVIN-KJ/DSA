package ARRAYS;

import java.util.ArrayList;

public class CountInversions {
    static int count;
    static int inversionCount(int arr[]) {
        // Code Here
        count = 0;
        mergesort(arr,0,arr.length-1);
        return count;
    }
    static void mergesort(int arr[],int l,int r){
        if(l>=r) return;
        int m = (l+r)/2;
        mergesort(arr,l,m);
        mergesort(arr,m+1,r);
        merge(arr,l,m,r);
    }
    static void merge(int arr[],int l,int m,int r){
        ArrayList<Integer> al = new ArrayList<>();
        int i = l,j = m+1;
        
        while(i<=m && j<=r){
            if(arr[i]>arr[j]) count+=(m-i+1);
            if(arr[i]<=arr[j]){
                al.add(arr[i++]);
            }
            else{
                al.add(arr[j++]);
            }
        }
        
        while(i<=m) al.add(arr[i++]);
        while(j<=r) al.add(arr[j++]);
        
        i=l;
        for(int x : al) arr[i++] = x;
        
    }
}
