package NeetCode_150.Stacks;

import java.util.Stack;

public class Min_Stack {
    Stack<Integer> st, mn;

    public Min_Stack() {
        this.st = new Stack<>();
        this.mn = new Stack<>();
        mn.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        st.push(val);
        mn.push(Math.min(val, mn.peek()));
    }

    public void pop() {
        st.pop();
        mn.pop();
    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return mn.peek();
    }
}
