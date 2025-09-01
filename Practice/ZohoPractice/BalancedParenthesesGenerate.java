package ZohoPractice;

import java.util.*;

public class BalancedParenthesesGenerate {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<String> ans = new ArrayList<>();
        generate(n, 0, 0, new StringBuilder(), ans);
        for(String s : ans) System.out.println(s);
    }

    private static void generate(int n, int o, int c, StringBuilder sb, List<String> ans) {
        if (sb.length() == 2 * n) {
            ans.add(sb.toString());
            return;
        }
        if (o < n) {
            sb.append('(');
            generate(n, o + 1, c, sb, ans);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (c < o) {
            sb.append(')');
            generate(n, o, c+1, sb, ans);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
