import java.util.Scanner;


//  TESTCASE TO PASTE IN THE CONSOLE ->   5 1 2 3 4 5 9 4 1 2 4 8 6 3 1 2 3 7 6 5 3 9 2 8 7 17 5 1 3 5 9 12 30 1 5 5 2 5 5 10

public class HasSubsequenceWithTargetSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // LOOP FOR TESTCASES
        for(int t=1;t<8;t++){
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
        System.out.println("\nTestcase "+t);
        System.out.println("Recursive : "+hasSubseq(n-1, target, arr));
        System.out.println("Memoized : "+hasSubseq(n-1, target, arr, dp));
        System.out.println("Tabulated : "+hasSubseq(arr, target));
        System.out.println("Space Optimized : "+hasSubseq(arr, target, n));
        System.out.println("***********");
    }
    in.close();
    }

// RECURSIVE
    public static boolean hasSubseq(int i,int trgt,int[] arr){
        if(trgt==0) return true;
        if(i==0) return (arr[i]==trgt);
        boolean not_taken = hasSubseq(i-1, trgt, arr);
        boolean taken = false;
        if(arr[i]<=trgt){
            taken = hasSubseq(i-1, trgt-arr[i], arr);
        }
        return taken||not_taken;
    }

// MEMOIZED 
    public static boolean hasSubseq(int i,int trgt,int[] arr,boolean[][] dp){
        if(trgt==0) return true;
        if(i==0) return (arr[i]==trgt);
        if(dp[i][trgt]) return dp[i][trgt];
        boolean not_taken = hasSubseq(i-1, trgt, arr);
        boolean taken = false;
        if(arr[i]<=trgt){
            taken = hasSubseq(i-1, trgt-arr[i], arr);
        }
        return dp[i][trgt] = taken||not_taken;
    }

// TABULATED
    public static boolean hasSubseq(int[] arr, int trgt){
        int n = arr.length;
        boolean dp[][] = new boolean[n][trgt+1];
        for(int i=0;i<n;i++){
            dp[i][0] = true;
        }
        if(arr[0]<=trgt){
            dp[0][arr[0]] = true;
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<=trgt;j++){
                boolean not_take = dp[i-1][j];
                boolean take = false;
                if(arr[i]<=j) take = dp[i-1][j-arr[i]];
                dp[i][j] = not_take||take;
            }
        }
        return dp[n-1][trgt];
    }

// SPACE OPTIMIZED
    public static boolean hasSubseq(int arr[],int k,int n){

        boolean prev[] = new boolean[k+1];
        boolean curr[] = new boolean[k+1];
        curr[0] = prev[0] = true;
        if(arr[0]<=k) prev[arr[0]] = true;
        for(int i=1;i<n;i++){
            curr[0] = true;
            for(int j=1;j<=k;j++){
                boolean ntake = prev[j];
                boolean take = false;
                if(arr[i]<=j) take = prev[j-arr[i]];
                curr[j] = ntake||take;
            }
            prev = curr.clone();
        }
        return prev[k];
    }


}
