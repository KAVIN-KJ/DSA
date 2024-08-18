import java.util.Scanner;

// TEST : 2 3 3 3 4 5 SUM = 20, ANSWER = TRUE
public class CanPartitionWithEqualSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        int target = in.nextInt();
        boolean dp[][] = new boolean[n][target + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = false;
            }
        }
        System.out.println(solve(arr));
        in.close();
    }

    public static boolean solve(int[] arr) {
        int n = arr.length;
        int sum = 0;
        for(int i : arr){
            sum+=i;
        }
        if (sum%2==1) return false;
        int trgt = sum/2;
        boolean dp[][] = new boolean[n][trgt+1];
        for(int i=0;i<n;i++){
            dp[i][0] = true;
        }
        if(arr[0]<=trgt) dp[0][arr[0]] = true;
        for(int i=1;i<n;i++){
            for(int j=1;j<=trgt;j++){
                boolean take = false;
                boolean n_take = dp[i-1][j];
                if(arr[i]<=j) take = dp[i-1][j-arr[i]];
                dp[i][j] = take|n_take;
            }
        }
        return dp[n-1][trgt];
    }

}
