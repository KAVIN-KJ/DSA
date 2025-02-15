package Recursion;

import java.util.*;

public class CombinationSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = in.nextInt();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int trgt = in.nextInt();
        combinationSum(0, arr, new ArrayList<Integer>(), trgt, ans);
        System.out.println("Combination1 -> repetition allowed : ");
        for (ArrayList<Integer> al : ans) {
            for (int i : al) {
                System.out.print(i + " ");
            }
            System.out.println();

        }
        combinationSum2(0, arr, new ArrayList<Integer>(), ans, trgt);
        in.close();
    }

    private static void combinationSum(int i, int arr[], ArrayList<Integer> curr, int trgt,
            ArrayList<ArrayList<Integer>> ans) {
        if (trgt == 0)
            ans.add(new ArrayList<>(curr));

        if (i == arr.length || trgt < 0)
            return;

        for (int j = i; j < arr.length; j++) {
            if (j > i && arr[j] == arr[j - 1])
                continue;
            if (trgt < arr[j])
                break;
            curr.add(arr[j]);
            combinationSum(j, arr, curr, trgt - arr[j], ans);
            curr.remove(curr.size() - 1);
        }
    }

    static void combinationSum2(int i, int arr[], ArrayList<Integer> curr, ArrayList<ArrayList<Integer>> ans,
            int trgt) {
        if (trgt == 0) {
            ans.add(new ArrayList<>(curr));
        }
        if (trgt < 0 || i == arr.length)
            return;
        for (int j = i; j < arr.length; j++) {
            if (j > i && arr[j] == arr[j - 1])
                continue;
            if (trgt < 0)
                break;
            curr.add(arr[j]);
            combinationSum2(j + 1, arr, curr, ans, trgt - arr[j]);
            curr.remove(curr.size() - 1);
        }
    }
}
