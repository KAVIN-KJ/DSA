import java.util.*;

public class JumpGame {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Array Size : ");
        int n = in.nextInt();
        int arr[] = new int[n]; 
        System.out.println("Enter Array Elements : ");
        for(int i=0;i<n;i++){
            arr[i] = in.nextInt(); 
        }
        boolean canreach[] = new boolean[n];
        canreach[n-1] = true;
        for(int i=n-2;i>=0;i--){
            if(i+arr[i]>=n-1) canreach[i] = true;
        }
        for(boolean i : canreach){
            // if(!i) {
            //     System.out.println(false);
            //     return;
            // }
            System.out.println(i);
        }

    }

    //  private static int solve(int i,int[] arr) {
    //     if(i==0) return 0;
    //     int singleJump = solve(i-1, arr) + Math.abs(arr[i] - arr[i-1]);
    //     int doubleJump = Integer.MAX_VALUE;
    //     if(i>1) doubleJump = solve(i-2, arr) + Math.abs(arr[i] - arr[i-2]);
    //     return Math.min(singleJump,doubleJump);
    // }
}
