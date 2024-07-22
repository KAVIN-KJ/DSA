import java.util.Scanner;

public class CanPartitionWithEqualSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = in.nextInt();
        }
        int target = in.nextInt();
        boolean dp[][] = new boolean[n][target+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<=target;j++){
                dp[i][j] = false;
            }
        }
        in.close();
    }

    public static boolean solve(int[] arr){
        int n = arr.length;
        int sum = 0;
        for(int i : arr) sum+=i;
        if(sum%2==1) return false;
        int trgt = sum/2;
        boolean dp[][] = new boolean[n][trgt+1];
        for(int i=0;i<n;i++){
            dp[i][0]=true;
        }
        if(arr[0]<=trgt) dp[0][arr[0]] = true;
        for(int ind = 1;ind<n;ind++){
            for(int tgt=1;tgt<=trgt;tgt++){
                boolean ntake = dp[ind-1][trgt];
                boolean take=false;
                if(arr[ind]<=tgt) take = dp[ind-1][tgt-arr[ind]];
                dp[ind][tgt] = ntake||take;
            }
        }

        return dp[n-1][trgt];
    }

}
