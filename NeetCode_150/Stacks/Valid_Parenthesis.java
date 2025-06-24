package NeetCode_150.Stacks;
import java.util.*;
public class Valid_Parenthesis {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(char c : s.toCharArray()){
            if(c=='(' || c=='{' || c=='['){
                st.push(c);
            }
            else{
                if(st.isEmpty()) return false;
                char x = st.pop();
                if(c==')'){
                    if(x=='['||x=='{') return false;
                }
                else if(c=='}'){
                    if(x=='['||x=='(') return false;
                }
                else if(c==']'){
                    if(x=='('||x=='{') return false;
                }
            }
        }
        return st.isEmpty();
    }
}