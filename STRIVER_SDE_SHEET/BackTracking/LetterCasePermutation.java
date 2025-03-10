import java.util.*;
class LetterCasePermutation{
    static List<String> ans;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        ans = new ArrayList<>();
        generatePerm(0, s, "");
        for(String i : ans){
            System.out.println(i);
        }
        in.close();
    }
    public static boolean isChar(char c){
        return ((c>='a'&&c<='z')||(c>='A'&&c<='Z'));
    }
    public static void generatePerm(int i,String s, String curr){
        if (i==s.length()){
            ans.add(curr);
            return;
        }
        char c = s.charAt(i);
        if(isChar(c)){
            char upr = Character.toUpperCase(c);
            char lwr = Character.toLowerCase(c);
            generatePerm(i+1,s,curr+upr);
            generatePerm(i+1,s,curr+lwr);
        }
        else{
            generatePerm(i+1,s,curr+c);
        }
    }
}