import java.util.Scanner;

public class Maximum_Sum_Subarray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // int n = in.nextInt();
        // int arr[] = new int[n];
        // for(int i=0;i<n;i++){
        //     arr[i] = in.nextInt();
        // }
        int arr[] = {3, -2, 5, -1, 2, -3, 4, -2, 2, -1,
            1, 2, 3, -4, 2, 5, -6, 3, 4, -2,
            5, 2, -3, 4, 2, -1, 3, -2, 1, 5,
            -3, 2, 4, 5, -6, 7, -2, 3, 2, -1,
            1, 3, -2, 4, 2, -1, 3, 5, -6, 2,
            3, -4, 2, 5, -1, 2, 3, 4, -5, 2,
            5, -3, 2, 1, 3, -2, 4, 5, -1, 3,
            2, -3, 4, 1, 2, -4, 3, 2, -1, 4,
            5, -2, 3, 1, 4, -3, 2, 5, -1, 3,
            2, -4, 5, 3, -2, 4, 1, 5, -3, 2};
            

        int ans=kadaneAlgorithm(arr);
        System.out.println(ans);
        in.close();
    }

    private static int kadaneAlgorithm(int[] arr) {
        int n = arr.length;
        int cur_sum=0,tot_sum=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            cur_sum += arr[i];
            if(tot_sum<cur_sum) tot_sum = cur_sum;
            if(cur_sum<0) cur_sum = 0;
        }
        return tot_sum;
    }
}
