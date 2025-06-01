import java.util.Scanner;

public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
       char[] arr = s.toCharArray();
       StringBuilder sb = new StringBuilder();
       for(char c: arr){
            if(Character.isLetterOrDigit(c))
                sb.append(Character.toLowerCase(c));
       }
       char[] ss = sb.toString().toCharArray();
       int i = 0,j = ss.length-1;
       while(i<j){
            if(ss[i]!=ss[j]){
                return false;
            }
            i++; 
            j--;
       }
       return true;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        System.out.println(isPalindrome(s));
        in.close();
    }
}
