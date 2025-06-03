package NeetCode_150.Sliding_Window;

import java.util.Scanner;

public class BestTimeTo_BuyAndSell_Stocks {
     static int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int ans = 0;
        for(int i : prices){
            min = Math.min(min,i);
            ans = Math.max(ans,i-min);
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = in.nextInt();
        }
        System.out.println("Max profit : "+maxProfit(arr));
        in.close();
    }
}
