import java.util.Scanner;

public class BuyAndSellStocks {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++) arr[i] = in.nextInt();
        int min = Integer.MAX_VALUE;
        int ans = 0;
        for(int i=0;i<n;i++){
            min = Math.min(arr[i],min);
            ans = Math.max(ans,arr[i]-min);
        }
        System.out.println(ans);
        in.close();
    }
}
