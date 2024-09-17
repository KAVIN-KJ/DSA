        import java.util.Scanner;

        public class CoinChange_2 {

            public static void main(String[] args) {
                Scanner in = new Scanner(System.in);
                int n = in.nextInt();
                int arr[] = new int[n];
                for(int i=0;i<n;i++){
                    arr[i] = in.nextInt();
                }
                int trgt = in.nextInt();
                System.out.println("Recursive : "+solve(n-1,arr,trgt));
                System.out.println("Tabulated : "+solve(arr, trgt));
                in.close();
            }

            private static int solve(int[] arr, int trgt) {
                int n = arr.length;
                int dp[][] = new int[n][trgt+1];
                for(int t=0;t<=trgt;t++){
                    if(t%arr[0]==0) dp[0][t] = 1;
                    else dp[0][t] = 0;
                }
                for(int i=1;i<n;i++){
                    for(int t=0;t<=trgt;t++){
                        int n_take = dp[i-1][t];
                        int take = 0;
                        if(arr[i]<=t) {
                            take = dp[i][t-arr[i]];
                        }
                        dp[i][t] = take+n_take;
                    }
                }
                return dp[n-1][trgt];
            }

            private static int solve(int i, int[] arr, int trgt) {
                if(i == 0 ){
                    if(trgt%arr[0]==0) return 1;
                    else return 0;
                }
                int n_take = solve(i-1, arr, trgt);
                int take = 0;   
                if(arr[i]<=trgt) {
                    take = solve(i, arr, trgt-arr[i]);
                }

                return take+n_take;
            }
                    
        }