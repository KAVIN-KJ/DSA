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
        in.close(); 
        System.out.println("Max Credits : "+a);
        System.out.println("Max Credits : "+b);
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
    if(last!=-1){
        dp[day][last] = maxPt;
    }
    return maxPt;
}

}
