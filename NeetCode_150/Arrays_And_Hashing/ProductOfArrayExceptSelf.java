import java.util.Scanner;

public class ProductOfArrayExceptSelf {

    static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        long prod = 1;
        int zeros = 0;
        for(int i : nums){
            if(i!=0) prod*=i;
            else zeros++;
        }

        if(zeros>=2) return ans;
        if(zeros==1){
            for(int i=0;i<n;i++){
                if(nums[i]==0){
                    ans[i] = (int)prod;
                    return ans;
                }
            }
        }
        for(int i=0;i<n;i++){
            ans[i] = (int) prod/nums[i];
        }

        return ans;
        
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++) arr[i] = in.nextInt();
        for(int i : productExceptSelf(arr)){
            System.out.print(i+" ");
        }
        in.close();
    }
}
