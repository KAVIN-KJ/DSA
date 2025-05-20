import java.util.Scanner;

public class PartitionWithMinDiff {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        int sum=0;
        for(int i=0;i<n;i++){
            arr[i] = in.nextInt();
            sum+=arr[i];
        }
        boolean dp[][] = new boolean[n][sum+1];
        int min = (int) 1e9;
        solve(arr, dp, sum);
        for(int i=0;i<=sum;i++){
            if(dp[n-1][i] == true){
                int s1 = i;
                int s2 = sum-s1;
                int diff = Math.abs(s1-s2);
                min = Math.min(min , diff);
            }
        }
        System.out.println(min);
        in.close();
    }

    private static boolean solve(int[] arr, boolean[][] dp,int sum) {
        int n = arr.length;
        for(int i=0;i<n;i++){
            dp[i][0] = true;
        }
        if(arr[0]<=sum) dp[0][arr[0]] = true;

        for(int ind=1;ind<n;ind++){
            for(int trgt=1;trgt<=sum;trgt++){
                boolean n_take = dp[ind-1][trgt];
                boolean take = false;
                if(arr[ind]<=trgt) take = dp[ind-1][trgt-arr[ind]];
                dp[ind][trgt] = take|n_take;
            }
        }

        return dp[n-1][sum];
    }
}
