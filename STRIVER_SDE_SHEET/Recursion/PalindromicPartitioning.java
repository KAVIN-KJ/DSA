package Recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class PalindromicPartitioning {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        in.close();
        palindromePart(0,s,new ArrayList<String>(),ans);
        for(ArrayList<String> al : ans){
            for(String str : al){
                System.out.print(str+" ");
            }
            System.out.println();
        }
    }

    private static void palindromePart(int ind, String s, ArrayList<String> curr, ArrayList<ArrayList<String>> ans) {
        if (ind == s.length()) {
            ans.add(new ArrayList<>(curr));
        }
        for (int i = ind; i < s.length(); i++) {
            if (isPal(s, ind, i)) {
                curr.add(s.substring(ind, i + 1));
                palindromePart(i + 1, s, curr, ans);
                curr.remove(curr.size() - 1);
            }
        }
    }

    static boolean isPal(String s, int st, int nd) {
        while (st < nd) {
            if (s.charAt(st++) != s.charAt(nd--))
                return false;
        }
        return true;
    }
}
