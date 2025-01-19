package STRIVER_SDE_SHEET;

import java.util.*;

public class FourSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        int target = in.nextInt();
        List<List<Integer>> ans = solveByHashing(arr, target);
        for (List<Integer> i : ans) {
            System.out.println(i);
        }
        ans = pointerApproach(arr, target);
        for (List<Integer> i : ans) {
            System.out.println(i);
        }
        in.close();
    }

    private static List<List<Integer>> pointerApproach(int[] arr, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (i > 0 && arr[i] == arr[i - 1])
                continue;
            for (int j = i + 1; j < n; j++) {
                if (j > i + 1 && arr[j] == arr[j - 1])
                    continue;
                int k = j + 1;
                int l = n - 1;
                while (k < l) {
                    long sum = (long) arr[i] + arr[j] + arr[k] + arr[l];
                    if (sum < (long) target)
                        k++;
                    else if (sum > (long) target)
                        l--;
                    else {
                        List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k], arr[l]);
                        Collections.sort(temp);
                        ans.add(temp);
                        k++;
                        l--;
                        while (k < l && arr[k] == arr[k - 1])
                            k++;
                        while (k < l && arr[l] == arr[l + 1])
                            l--;
                    }
                }
            }
        }
        return ans;
    }

    public static List<List<Integer>> solveByHashing(int[] arr, int target) {
        HashSet<List<Integer>> set = new HashSet<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                HashSet<Long> temp = new HashSet<>();
                for (int k = j + 1; k < n; k++) {
                    long sum = (long) arr[i] + arr[j] + arr[k];
                    long req = target - sum;
                    if (temp.contains(req)) {
                        List<Integer> tp = Arrays.asList(arr[i], arr[j], arr[k], (int) req);
                        Collections.sort(tp);
                        set.add(tp);
                    }
                    long a = (long) arr[k];
                    temp.add(a);
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        Iterator<List<Integer>> it = set.iterator();
        while (it.hasNext()) {
            ans.add(it.next());
        }
        return ans;
    }
}
