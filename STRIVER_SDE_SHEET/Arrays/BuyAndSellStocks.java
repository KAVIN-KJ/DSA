package STRIVER_SDE_SHEET.Arrays;

import java.util.Scanner;

public class BuyAndSellStocks {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++) arr[i] = in.nextInt();
        int min = arr[0];
        int profit = 0;
        for(int i=0;i<n;i++){
            profit = Math.max(profit,arr[i]-min);
            min = Math.min(min,arr[i]);
        }
        System.out.println(profit);
        in.close();
    }
}
