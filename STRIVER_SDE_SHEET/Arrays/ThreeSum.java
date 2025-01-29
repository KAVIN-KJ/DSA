package STRIVER_SDE_SHEET.Arrays;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        ArrayList<List<Integer>> al = solveByHashing(arr);
        System.out.println("Hashing approach");
        for (List<Integer> i : al) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
        System.out.println("2 Pointer approach");
        List<List<Integer>> ans = solveBy2PTR(arr);
        for (List<Integer> i : ans) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        in.close();
    }

    private static List<List<Integer>> solveBy2PTR(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        int n = arr.length;
        for(int i=0;i<n;i++){
            if(i>0 && arr[i] == arr[i-1]) continue;
            int j = i+1;
            int k = n-1;
            while(j<k){
                int sum = arr[i] + arr[j] + arr[k];
                if(sum<0){
                    j++;
                }
                else if(sum>0){
                    k--;
                }
                else{
                    ans.add(Arrays.asList(arr[i],arr[j],arr[k]));
                    j++;
                    k--;
                    while(j<k && arr[j] == arr[j-1]) j++; 
                    while(j<k && arr[k] == arr[k+1]) k--; 
                }
            }
        }
        return ans;
    }

    private static ArrayList<List<Integer>> solveByHashing(int[] arr) {
        HashSet<List<Integer>> ans = new HashSet<>();
        ArrayList<List<Integer>> al = new ArrayList<>();
        for (int i = 0; i < arr.length - 1; i++) {
            HashSet<Integer> temp = new HashSet<>();
            for (int j = i + 1; j < arr.length; j++) {
                int req = -1 * (arr[i] + arr[j]);
                if (temp.contains(req)) {
                    List<Integer> lst = new ArrayList<Integer>();
                    lst.add(arr[i]);
                    lst.add(arr[j]);
                    lst.add(req);
                    Collections.sort(lst);
                    ans.add(lst);
                }
                temp.add(arr[j]);
            }
        }
        Iterator<List<Integer>> it = ans.iterator();
        while (it.hasNext()) {
            al.add(it.next());
        }
        return al;
    }
}
