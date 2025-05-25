import java.util.*;
class Solution {
    public static boolean containsDuplicate(int[] nums) {
        return sorting(nums);
    }
    static boolean hashing(int nums[]){
        HashMap<Integer,Integer> mpp = new HashMap<>();
        for(int i : nums){
            if(mpp.getOrDefault(i,-1)==-1){
                mpp.put(i,0);
            }
            else{
                return true;
            }
        }
        return false;
    }
    static boolean sorting(int arr[]){
        Arrays.sort(arr);
        for(int i=1;i<arr.length;i++){
            if(arr[i-1]==arr[i]) return true;
        }
        return false; 
    }
}

public class ContainsDuplicate {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = in.nextInt();
        }
        System.out.println(Solution.containsDuplicate(arr));
        in.close();
    }
    
}