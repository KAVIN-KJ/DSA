package NeetCode_150.Stacks;
import java.util.Stack;

public class Evaluate_Reverse_Polish_Notation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(String s : tokens){
            if (!s.equals("+") && !s.equals("-") && !s.equals("*") && !s.equals("/")){
                st.push(Integer.parseInt(s));
            }
            else{
                char o = s.charAt(0);
                int first = st.pop();
                int second = st.pop();
                int result = 0;
                if(o=='+'){
                    result = second+first;
                }
                else if(o=='-'){
                    result = second-first;
                }
                else if(o=='/'){
                    result = second/first;
                }
                else if(o=='*'){
                    result = second*first;
                }
                st.push(result);
            }
        }
        return st.pop();
    }
}
