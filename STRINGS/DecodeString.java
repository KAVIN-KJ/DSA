import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder ans = new StringBuilder();
        for(char c : s.toCharArray()){
            if(c!=']') st.push(c);
            else{
                StringBuilder sb = new StringBuilder();
                while(!st.isEmpty() && st.peek()!='['){
                    sb.insert(0,st.pop());
                }
                st.pop();
                StringBuilder k = new StringBuilder();
                while(!st.isEmpty() && st.peek()>='0'&&st.peek()<='9'){
                    k.insert(0,st.pop());
                }
                int rep = Integer.parseInt(k.length()>0 ? k.toString() : "0");
                for(int i=0;i<rep;i++){
                    for(char j : sb.toString().toCharArray()){
                        st.push(j);
                    }
                }
            }
        }
        while(!st.isEmpty()) ans.insert(0,st.pop());
        return ans.toString();
    }
}