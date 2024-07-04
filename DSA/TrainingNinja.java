import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class TrainingNinja {
    public static void main(String[] args) {
        int days=0,tasks=0;
        Scanner in = new Scanner(System.in);
        days=in.nextInt();
        tasks = in.nextInt();
        int arr[][] = new int[days][tasks];
        for(int i=0;i<days;i++){
            for(int j=0;j<tasks;j++){
                arr[i][j] = in.nextInt();
            }
        }
        int dp[][] = new int[days][tasks+1];
        for(int i=0;i<days;i++){
            for(int j=0;j<=tasks;j++){
                dp[i][j] = -1;
            }
        }
        int a = maxCredits(days-1,3,arr);
        int b = maxCredits(days-1,-1, arr, dp);
        int c = maxCredits(arr);
        in.close(); 
        System.out.println("Max Credits : "+a);
        System.out.println("Max Credits Memoization : "+b);
        System.out.println("Max Credits Tabulation : "+c);
    }
// TABULATED
private static int maxCredits(int[][] arr) {
        int days = arr.length;
        int tasks = arr[0].length;
        int dp[][] = new int[days][tasks];
        dp[0][0] = Math.max(arr[0][1],arr[0][2]);
        dp[0][1] = Math.max(arr[0][0],arr[0][2]);
        dp[0][2] = Math.max(arr[0][1],arr[0][0]);
        int ans=0;
        for(int day=1;day<days;day++){
            for(int last=0;last<tasks;last++){
                dp[day][last] = 0;
                for(int task=0;task<tasks;task++){
                    if(task!=last){
                        int point = arr[day][task] + dp[day-1][last];
                        dp[day][last] = Math.max(point,dp[day][last]);
                        ans = dp[day][last];
                    }
                }
            }
        }
        for(int[] i : dp){
            for(int j : i){
                System.out.print(j+" ");
            }
            System.out.println();
        }
        return ans;
}
    // Recursive
    private static int maxCredits(int day, int last, int[][] arr) {
        if(day==0){
            int maxPt = 0;
            for(int i=0;i<arr[day].length;i++){
                if(i!=last)
                    maxPt = Math.max(maxPt,arr[day][i]);
            }
            return maxPt;
        }
        int maxPt=0;
        for(int i=0;i<arr[day].length;i++){
            if(i!=last){
                int point = arr[day][i] + maxCredits(day-1, i, arr);
                maxPt = Math.max(point,maxPt);
            }
        }
        return maxPt;

    }

// Memoized
private static int maxCredits(int day, int last, int[][] arr,int[][] dp) {
    if(day==0){
        int maxPt = 0;
        for(int i=0;i<arr[day].length;i++){
            if(i!=last)
                maxPt = Math.max(maxPt,arr[day][i]);
        }
        return maxPt;
    }
    if(last!=-1&&dp[day][last]!=-1) return dp[day][last];
    int maxPt=0;
    for(int i=0;i<arr[day].length;i++){
        if(i!=last){
            int point = arr[day][i] + maxCredits(day-1, i, arr, dp);
            maxPt = Math.max(point,maxPt);
        }
    }
    if(last!=-1) dp[day][last] = maxPt;
    return maxPt;
}
}
