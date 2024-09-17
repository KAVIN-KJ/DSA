import java.util.Scanner;


public class Unbounded_KnapSack {
    static class item {
        int w, v;
        item(int w, int v) {
            this.w = w;
            this.v = v;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        item items[] = new item[n];
        System.out.println("Enter weight followed by value : ");
        for (int i = 0; i < n; i++) {
            int w = in.nextInt();
            int v = in.nextInt();
            items[i] = new item(w, v);  
        }
        System.out.println("Enter Capacity of the bag : ");
        int cap = in.nextInt();
        System.out.println("Recursive : " + solve(n - 1, items, cap));
        System.out.println("Tabulated : " + solve(items, cap));

        in.close();
    }

    private static int solve(item[] items, int cap) {
        int n = items.length;
        int dp[][] = new int[n][cap+1];
        for(int i=0;i<=cap;i++){
            dp[0][i] = (i/items[0].w)*items[0].v;
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<=cap;j++){
                int n_pick = dp[i-1][j];
                int pick = Integer.MIN_VALUE;
                if(items[i].w<=j){
                    pick = items[i].v + dp[i][j-items[i].w];
                }
                dp[i][j] = Math.max(n_pick,pick);
            }
        }
        return dp[n-1][cap];
    }

    private static int solve(int i, item[] items, int cap) {
        if (i == 0) {
            int ans = (cap / items[i].w) * items[i].v;
            return ans;
        }
        int n_pick = solve(i - 1, items, cap);
        int pick = Integer.MIN_VALUE;
        if (items[i].w <= cap) {
            pick = items[i].v + solve(i, items, cap - items[i].w);
        }
        return Math.max(n_pick, pick);
    }
}
