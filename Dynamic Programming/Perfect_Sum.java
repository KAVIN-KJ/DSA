public class Perfect_Sum {
    public int perfectSum(int[] nums, int target) {
        // return solve(nums, nums.length - 1, target,0);
        return solve(nums,target);
    }

    static int solve(int arr[], int i, int trgt,int cur) {
        if(i<0){
            if(cur==trgt) return 1;
            else return 0;
        }
        int pick = 0;
        if(cur+arr[i]<=trgt){
            pick = solve(arr,i-1,trgt,cur+arr[i]);
        }
        int npick = solve(arr,i-1,trgt,cur);
        return pick+npick;
    }
    static int solve(int arr[],int trgt){
        int n = arr.length;
        int dp[][] = new int[n][trgt+1];
        dp[0][0] = 1;
        if(arr[0]<=trgt) dp[0][arr[0]]+=1;
        for(int i=1;i<n;i++){
            for(int c=0;c<=trgt;c++){
                int pick = 0;
                if(c-arr[i]>=0){
                    pick = dp[i-1][c-arr[i]];
                }
                int npick = dp[i-1][c];
                dp[i][c] = pick+npick;
            }
        }
        return dp[n-1][trgt];
    }
}
