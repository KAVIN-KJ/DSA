import java.util.*;;

public class CountSubsets {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        int trgt = in.nextInt();
        int dp[][] = new int[n][trgt + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= trgt; j++) {
                dp[i][j] = -1;
            }
        }
        in.close();
        System.out.println("Recursive : " + solve(arr, trgt, n - 1));
        System.out.println("Memoized : " + solve(arr, trgt, n - 1, dp));
        System.out.println("Tabulated : " + solve(arr, trgt));
    }

    public static int solve(int arr[], int target, int index) {
        if (target == 0) {
            return 1;
        }
        if (index == 0) {
            // can't cast to integer LOL !
            return arr[index] == target ? 1 : 0;
        }
        int npick = solve(arr, target, index - 1);
        int pick = 0;
        if (arr[index] <= target)
            pick = solve(arr, target - arr[index], index - 1);
        return npick + pick;
    }

    private static int solve(int[] arr, int trgt, int n, int[][] dp) {
        if (trgt == 0) {
            return 1;
        }
        if (n == 0) {
            return arr[n] == trgt ? 1 : 0;
        }
        if (dp[n][trgt] != -1)
            return dp[n][trgt];
        int npick = solve(arr, trgt, n - 1);
        int pick = 0;
        if (arr[n] <= trgt)
            pick = solve(arr, trgt - arr[n], n - 1);
        dp[n][trgt] = npick + pick;
        return dp[n][trgt];
    }

    private static int solve(int[] arr, int trgt) {
        int n = arr.length;
        int dp[][] = new int[n][trgt+1];
        for(int i=0;i<n;i++){
            dp[i][0] = 1;
        }
        if(arr[0]<=trgt) dp[0][arr[0]] = 1;

        for(int i=1;i<n;i++){
            for(int j=0;j<=trgt;j++){
                int npick = dp[i-1][j];
                int pick = 0;
                if(arr[i]<=j)
                 pick = dp[i-1][j-arr[i]];
                dp[i][j] = npick+pick;
            }
        }

        return dp[n-1][trgt];
    }

}
