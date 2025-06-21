
import java.util.Arrays;
import java.util.Scanner;


public class Permutation_In_String {

    static boolean checkInclusion(String s1,String s2){
        int f1[] = new int[26];
        int f2[] = new int[26];

        for(char c: s1.toCharArray()) f1[c-'a']++;
        for(int i=0;i<s2.length();i++){
            f2[s2.charAt(i)-'a']++;
            if(i>=s1.length()){
                f2[s2.charAt(i-s1.length()) -'a']--;
            }
            if(Arrays.equals(f1, f2)) return true;;
        }
        
        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.nextLine();
        String s2 = in.nextLine();
        System.out.println(checkInclusion(s1, s2));
        in.close();
    }
}
