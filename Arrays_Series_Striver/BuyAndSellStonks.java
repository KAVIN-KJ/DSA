package Arrays_Series_Striver;

public class BuyAndSellStonks {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int ans = 0;
        for(int i : prices){
            min = Math.min(min,i);
            ans = Math.max(ans,(i-min));
        }
        return ans;
    }
}
