import java.util.Scanner;

public class JumpingFrog {
    public static void main(String[] args) {
        int n=0;
        Scanner in  = new Scanner(System.in);
        n = in.nextInt();
        int arr[] = new int[n];
        int dp[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = in.nextInt();
            dp[i] = -1;
        }
        System.out.println(findCost(n-1,arr));
        System.out.println(findCostMEM(n-1,arr,dp));
        System.out.println(findCostTAB(arr));
        in.close();
    }

    private static int findCost(int i,int[] arr) {
        if(i==0) return 0;
        int singleJump = findCost(i-1, arr) + Math.abs(arr[i] - arr[i-1]);
        int doubleJump = Integer.MAX_VALUE;
        if(i>1) doubleJump = findCost(i-2, arr) + Math.abs(arr[i] - arr[i-2]);
        return Math.min(singleJump,doubleJump);
    }

    // MEMOIZATION
    private static int findCostMEM(int i,int[] arr, int[] dp) {
        if(i==0) return 0;
        if(dp[i]!=-1) return dp[i];
        int singleJump = findCost(i-1, arr) + Math.abs(arr[i] - arr[i-1]);
        int doubleJump = Integer.MAX_VALUE;
        if(i>1) doubleJump = findCost(i-2, arr) + Math.abs(arr[i] - arr[i-2]);
        dp[i] = Math.min(singleJump, doubleJump);
        return dp[i];
    }
    // TABULATION
    private static int findCostTAB(int[] arr){
        int dp[] = new int[arr.length];
        dp[0] = 0;
        dp[1] = Math.abs(arr[0]-arr[1]);
        for(int i=2;i<arr.length;i++){
            int sing = dp[i-1]+Math.abs(arr[i] - arr[i-1]);
            int doub = dp[i-2]+Math.abs(arr[i] - arr[i-2]);
            dp[i] = Math.min(sing,doub);
        }
        return dp[arr.length-1];
    }
}
