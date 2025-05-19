import java.util.Scanner;

/**
 * MinimumCoins
 */
public class MinimumCoins {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            int n = in.nextInt();
            int arr[] = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = in.nextInt();
            }
            int trgt = in.nextInt();
            System.out.println("Recursive : " + solve(arr, trgt, n - 1));
            System.out.println("Tabulated : " + solve(arr, trgt));
            in.close(); 
        }
    }

    private static int solve(int[] arr, int trgt) {
        int n = arr.length;
        int dp[][] = new int[n][trgt + 1];
        for (int i = 0; i <= trgt; i++) {
            if (i % arr[0] == 0)
                dp[0][i] = i / arr[0];
            else
                dp[0][i] = (int) 1e9;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= trgt; j++) {
                int n_take = dp[i - 1][j];
                int take = (int) 1e9;
                if (arr[i] <= j) {
                    take = 1 + dp[i][j - arr[i]];
                }
                dp[i][j] = Math.min(n_take, take);
            }
        }
        return dp[n - 1][trgt];
    }

    private static int solve(int[] arr, int trgt, int i) {
        if (i == 0) {
            if (trgt % arr[i] == 0)
                return trgt / arr[i];
            else
                return (int) 1e9;
        }
        int ntake = solve(arr, trgt, i - 1);
        int take = (int) 1e9;
        if (arr[i] <= trgt) {
            take = 1 + solve(arr, trgt - arr[i], i);
        }
        return Math.min(take, ntake);
    }
}