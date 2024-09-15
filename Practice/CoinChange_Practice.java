    package Practice;
    import java.util.*;
    public class CoinChange_Practice {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            int arr[] = new int[n];
            for(int i=0;i<n;i++){
                arr[i] = in.nextInt();
            }
            int trgt = in.nextInt();
            System.out.println(solve(n-1,arr,trgt));
            System.out.println(solve(arr, trgt));
        }

        private static int solve(int[] arr, int trgt) {
            int n = arr.length;
            int dp[][] = new int[n][trgt+1];
                for(int j=0;j<=trgt;j++){
                    if(j%arr[0]==0) dp[0][j] = j/arr[0];
                    else dp[0][j] = (int)1e9;
                }
        
            for(int i=1;i<n;i++){
                for(int j=0;j<=trgt;j++){
                    int n_pick = dp[i-1][j];
                    int pick = (int)1e9;
                    if(arr[i]<=j){
                        pick = 1 + dp[i][j-arr[i]];
                    }
                    dp[i][j] = Math.min(n_pick,pick);
                }
            }
            return dp[n-1][trgt];
        }

        private static int solve(int i, int[] arr, int trgt) {

            if(i==0){
                if(trgt%arr[0]==0) return trgt/arr[0];
                else return (int)1e9;
            }
            int n_pick = solve(i-1,arr,trgt);
            int pick = (int)1e9;
            if(arr[i]<=trgt) {
                pick = solve(i, arr, trgt-arr[i]) + 1;
            }
            if(Math.min(n_pick,pick)>=(int)1e9){
                return -1;
            }
            return Math.min(n_pick, pick);
        }
    }
