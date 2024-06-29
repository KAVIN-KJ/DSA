import java.util.*;
public class Frog_Jump_2 {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = in.nextInt();
        }
        System.out.println(findCost(arr,k));
        in.close();
    }

    private static int findCost(int[] arr,int k) {
        int n = arr.length;
        int dp[] = new int[n];
        if(n<=1) return 0;
        dp[0] = 0;
        int minCost = Integer.MAX_VALUE;
        for(int i=1;i<n;i++){
            for(int j=1;j<k;j++){
                if(i-j>=0){
                    int jump = dp[i-j] + Math.abs(arr[i] - arr[i-j]);
                    minCost = Math.min(jump,minCost);
                    dp[i] = minCost;
                }
            }
        }
        return dp[n-1];
    }
}
