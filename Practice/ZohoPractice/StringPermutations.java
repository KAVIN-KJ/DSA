package ZohoPractice;

import java.util.*;

public class StringPermutations {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        char arr[] = s.toCharArray();
        List<String> comb = new ArrayList<>();
        permuteunique(0, arr, comb);
        for(String i : comb) System.out.println(i);
    }

    private static void permute(int i, char[] arr, List<String> comb) {
        if(i==arr.length-1){
            comb.add(new String(arr));
            return;
        }
        for(int j=i;j<arr.length;j++){
            char t = arr[j];
            arr[j] = arr[i];
            arr[i] = t;
            permute(i+1, arr, comb);
            t = arr[j];
            arr[j] = arr[i];
            arr[i] = t;
        }
    }
    private static void permuteunique(int i, char[] arr, List<String> comb) {
        if(i==arr.length-1){
            comb.add(new String(arr));
            return;
        }
        Set<Character> st = new HashSet<>();
        for(int j=i;j<arr.length;j++){
            if(st.contains(arr[j])) continue;
            st.add(arr[j]);
            char t = arr[j];
            arr[j] = arr[i];
            arr[i] = t;
            permuteunique(i+1, arr, comb);
            t = arr[j];
            arr[j] = arr[i];
            arr[i] = t;
        }
    }
}
