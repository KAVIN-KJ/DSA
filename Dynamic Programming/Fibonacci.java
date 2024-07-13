import java.util.Arrays;

public class Fibonacci {

    // RECURSION

    public static int fib(int n){
        if(n<=1) return n;

        return fib(n-1) + fib(n-2);

    }

    // MEMOIZATION

    public static int fib(int n,int[] dp){
        if(n<=1) return n;
        if(dp[n]!=-1) return dp[n];
        dp[n] = fib(n-1,dp) + fib(n-2,dp);
        return dp[n];
    }

    // TABULATION

    public static int fibt(int n){
        int dp[] = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    // EVEN MORE EFFICIENT !!! 
    public static int fibe(int n){
        int prev1 = 0,prev = 1;
        int curr = 0;
        for(int i=2;i<=n;i++){
            curr = prev1 + prev;
            prev1 = prev;
            prev = curr;
        }
        return curr;
    }

    public static void main(String[] args) {
        int n = 40;
        // System.out.println("recursion : ");
        // System.out.println(fib(n));
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        System.out.println("Memoization : ");
        System.out.println(fib(n,dp));

    }
}


