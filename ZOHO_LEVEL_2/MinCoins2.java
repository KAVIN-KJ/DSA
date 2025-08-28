import java.util.*;

public class MinCoins2 {
    static HashMap<Integer, Integer> mpp;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        mpp = new HashMap<>();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
            mpp.put(arr[i], 0);
        }
        int sum = in.nextInt();
        System.out.println("Output : ");
        int ans = helper(arr, sum, n - 1, mpp);
        System.out.println(ans > 0 ? ans : -1);
        // for(int i : mpp.keySet()) System.out.println(i+" x "+mpp.get(i));

    }

    static int helper(int arr[], int sum, int i, HashMap<Integer, Integer> mpp) {
        if (i == 0) {
            if (sum % arr[i] == 0) {
                return sum / arr[i];
            } else
                return (int) 1e9;
        }
        int pick = (int) 1e9;
        if (arr[i] <= sum) {
            mpp.put(arr[i], mpp.getOrDefault(arr[i], 0) + 1);
            pick = 1 + helper(arr, sum - arr[i], i, mpp);
        }
        if (mpp.get(arr[i]) > 0)
            mpp.put(arr[i], mpp.get(arr[i]) - 1);
        int npick = helper(arr, sum, i - 1, mpp);
        return Math.min(pick, npick);
    }
    // static int solution(int arr[])
}