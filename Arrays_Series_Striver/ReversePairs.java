package Arrays_Series_Striver;

import java.util.ArrayList;

public class ReversePairs {
    static int count;
    public int reversePairs(int[] nums) {
        count = 0;
        mergesort(nums,0,nums.length-1);
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
        int j = m+1;
        for(int i=l;i<=m;i++){
            while(j<=r && (long)arr[i]>(long)2*arr[j]) j++;
            count+=(j-(m+1));
        }
        j=m+1;
        int i = l;
        while(i<=m&&j<=r){
            if(arr[i]<arr[j]) al.add(arr[i++]);
            else al.add(arr[j++]);
        }
        while(i<=m) al.add(arr[i++]);
        while(j<=r) al.add(arr[j++]);
        i = l;
        for(int x : al) arr[i++] = x;
    }
}
