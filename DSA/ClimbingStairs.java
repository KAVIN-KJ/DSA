
//  REACH Nth STAIR FROM 0TH STAIR EITHER BY TAKING 1 STAIR AT A TIME OR 2 STAIRS. RETURN ALL POSSIBLE OUTCOMES OF REACHING THE Nth STAIR

import java.util.Arrays;
import java.util.Scanner;

public class ClimbingStairs {

    public static void main(String[] args) {
        System.out.print("Enter Stair no : ");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long arr[] = new long[n+1];
        Arrays.fill(arr,-1);
        System.out.println(countStairs(n,arr));
        


        in.close();
    }

    private static long countStairs(int n, long[] arr) {
        if(n<=1)  return 1;
        if(arr[n]!=-1) return arr[n];
        arr[n] = countStairs(n-1, arr) + countStairs(n-2, arr);
        return arr[n];
    }

    
}
