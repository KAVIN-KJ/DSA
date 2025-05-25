import java.util.HashMap;
import java.util.Scanner;

public class Valid_Anagrams {
    public static boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> mpps = new HashMap<>();
        HashMap<Character,Integer> mppt = new HashMap<>();
        if(s.length()!=t.length()) return false;
        for(int i=0;i<s.length();i++){
            mpps.put(s.charAt(i),1+mpps.getOrDefault(s.charAt(i),0));
            mppt.put(t.charAt(i),1+mppt.getOrDefault(t.charAt(i),0));
        }
        return mpps.equals(mppt);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String t = in.next();

        System.out.println(isAnagram(s,t));

        in.close();
    }
}