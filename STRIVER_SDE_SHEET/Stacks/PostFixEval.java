package Stacks;

import java.util.*;

public class PostFixEval {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String expr = in.next();
        System.out.println("Expression is evaluated as : "+evaluate(expr));
        in.close();
    }

/*
 * 
 *      LEETCODE 150 SOLUTION
 * 
 */

    public int evalRPN(String[] arr) {
        Stack<Integer> st = new Stack<>();
        for(String s : arr){
            if(s.equals("+")){
                st.push(st.pop()+st.pop());
            }
            else if(s.equals("-")){
                int b = st.pop();
                int a = st.pop();
                st.push(a-b); 
            }
            else if(s.equals("*")){
                st.push(st.pop() * st.pop());
            }
            else if(s.equals("/")){
                int b = st.pop();
                int a = st.pop();
                st.push(a/b);
            }
            else{
                st.push(Integer.parseInt(s));
            }
        }
        return st.pop();
    }

    /*
     *  
     * IF  CURRENT CHARACTER IS A DIGIT ADD IT TO STACK
     * IF CURRENT CHARACTER IS AN OPERATOR POP LAST 2 ELEMENTS FROM THE STACK , PERFORM THE OPERATION AND ADD IT TO STACK
     * 
     */
    
    public static int evaluate(String s){
        Stack<Integer> st = new Stack<>();
        for(char ch : s.toCharArray()){
            if(Character.isDigit(ch)){
                st.push(ch-'0');
            }
            else{
                int v2 = st.pop();
                int v1 = st.pop();
                switch(ch){
                    case '+':
                        st.push(v1+v2);
                    break;
                    case '-':
                        st.push(v1-v2);
                    break;
                    case '*':
                        st.push(v1*v2);
                    break;
                    case '/':
                        st.push(Math.max(v1,v2)/Math.min(v1,v2));
                    break;
                }
            }

        }
        return st.pop();
    }
}
