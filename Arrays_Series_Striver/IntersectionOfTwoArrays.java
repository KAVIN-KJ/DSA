package Arrays_Series_Striver;
import java.util.*;
public class IntersectionOfTwoArrays {
     public static ArrayList<Integer> findUnion(int nums1[], int nums2[]) {
        // code here
        int n1 = nums1.length;
        int n2 = nums2.length;
        int i=0,j=0;
        ArrayList<Integer> al = new ArrayList<>();
        while(i<n1 && j<n2){
            if(nums1[i]<=nums2[j]){
                if(al.size()==0||al.get(al.size()-1)<nums1[i]){
                    al.add(nums1[i]);
                }
                i++;
            }
            else{
                if(al.size()==0||al.get(al.size()-1)<nums2[j]){
                    al.add(nums2[j]);
                }
                j++;
            }
        }
        while(i<n1){
            if(al.size()==0||al.get(al.size()-1)<nums1[i]){
                    al.add(nums1[i]);
                }
            i++;
        }
        while(j<n2){
            if(al.size()==0||al.get(al.size()-1)<nums2[j]){
                    al.add(nums2[j]);
                }
            j++;
        }
        return al;
    }
}
