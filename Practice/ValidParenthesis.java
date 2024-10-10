package Practice;

import java.util.*;;

public class ValidParenthesis {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String expr = in.nextLine();
        if (isValid(expr)) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }
        in.close();
    }

    private static boolean isValid(String expr) {
        Stack<Character> list = new Stack<Character>();
        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);
            if(c=='('||c=='{'||c=='['){
                list.push(c);
                continue;
            }
            if(list.empty()) return false;
            char check = list.pop();
            switch (c) {
                case ')':
                    if(check=='{'||check=='[') return false;
                    break;
                case '}':
                    if(check=='('||check=='[') return false;
                    break;
                case ']':
                    if(check=='('||check=='{') return false;
                    break;
            }
        }
        return list.empty();
    }
}
