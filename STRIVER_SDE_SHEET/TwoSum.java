package STRIVER_SDE_SHEET;

import java.util.HashMap;
import java.util.Scanner;

public class TwoSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        int trgt = in.nextInt();
        int ans[] = solve(arr, trgt);
        System.out.println(ans[0] + " " + ans[1]);
        in.close();
    }

    private static int[] solve(int[] arr, int trgt) {
        int ans[] = new int[2];
        HashMap<Integer,Integer> mp = new HashMap<>();
        ans[0] = ans[1] = -1;
        for(int i=0;i<arr.length;i++){
            int req = trgt - arr[i];
            if(mp.containsKey(req)){
                // WE NEED ONLY INDICES OF THE NUMS THAT ADD UP TO TRGT 
                ans[0] = mp.get(req);
                ans[1] = i;
                return ans;
            }
            mp.put(arr[i], i);
        }
        return ans;
    }
}
