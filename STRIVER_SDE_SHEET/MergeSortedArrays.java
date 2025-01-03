package STRIVER_SDE_SHEET;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSortedArrays {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int nums1[] = new int[m + n];
        int nums2[] = new int[n];
        for (int i = 0; i < m; i++) {
            nums1[i] = in.nextInt();
        }
        for (int j = 0; j < n; j++) {
            nums2[j] = in.nextInt();
        }
        in.close();
        merge(nums1, nums2, m, n);
        for(int i : nums1){
            System.out.print(i+" ");
        }
    }

    private static void merge(int[] nums1, int[] nums2, int m, int n) {
        int lt = m-1;
        int rt = 0;
        while(lt>=0 && rt<n){
            if(nums1[lt] > nums2[rt]){
                int temp = nums1[lt];
                nums1[lt] = nums2[rt];
                nums2[rt] = temp;
                lt--;
                rt++;
            }
            else{
                break;
            }
        }
        Arrays.sort(nums1,0,m);
        Arrays.sort(nums2);
        int i=m;
        for(int j=0;j<n;j++){
            nums1[i] = nums2[j];
            i++;
        }
    }

}