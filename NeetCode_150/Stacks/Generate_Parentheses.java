package NeetCode_150.Stacks;

import java.util.ArrayList;
import java.util.List;

public class Generate_Parentheses {
    static List<String> ans;
    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        solve(n,0,0,new StringBuilder());
        return ans;
    }
    public static void solve(int n,int open,int close,StringBuilder sb){
        if(sb.length()==n*2){
            ans.add(sb.toString());
            return;
        }
        if(open<n){
            solve(n,open+1,close,sb.append("("));
            sb.deleteCharAt(sb.length()-1);
        }
        if(close<open){
            solve(n,open,close+1,sb.append(")"));
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
