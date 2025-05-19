package Stacks;

import java.util.*;

public class RemoveKDigits {
    public static String removeKdigits(String num, int k) {
        Stack<Character> s = new Stack<>();
        for(char c : num.toCharArray()){
            while(!s.empty() && k>0 && s.peek()>c){
                s.pop();
                k--;
            }
            s.push(c);
        }
        while(!s.empty() && k>0){
            s.pop();
            k--;
        }
        StringBuilder res = new StringBuilder();
        while(!s.empty()){
            res.append(s.pop());
        }
        res.reverse();
        while(res.length()>0 && res.charAt(0)=='0'){
            res.deleteCharAt(0);
        }
        return res.length()>0 ? res.toString() : "0";
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int k = in.nextInt();
        in.close();
        System.out.println(removeKdigits(s, k));
    }
}
