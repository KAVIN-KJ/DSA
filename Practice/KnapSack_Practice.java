// package Practice;

import java.util.*;

class item {
    int w;
    int v;

    item(int wei, int val) {
        this.w = wei;
        this.v = val;
    }
}

public class KnapSack_Practice {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        item arr[] = new item[n];
        for (int i = 0; i < n; i++) {
            int v = in.nextInt();
            int w = in.nextInt();
            item it = new item(w, v);
            arr[i] = it;
        }
        int cap = in.nextInt();
        System.out.println(solve(n - 1, arr, cap));
        in.close();

    }

    private static int solve(int i, item[] arr, int cap) {
        if (i == 0) {
            if (arr[i].w <= cap) {
                return arr[i].v;
            }
            else{
                return 0;
            }
        }
        int n_pick = solve(i - 1, arr, cap);
        int pick = (int) -1e9;
        if (arr[i].w <= cap) {
            pick = arr[i].v + solve(i - 1, arr, cap - arr[i].w);
        }
        return Math.max(n_pick, pick);
    }
}
