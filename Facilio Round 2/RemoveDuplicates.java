import java.util.*;

public class RemoveDuplicates {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input : ");
        String s = in.nextLine();
        System.out.println(s);
        char arr[] = s.toCharArray();
        HashSet<Character> st = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            if(st.add(c))
                sb.append(c);
        }
        System.out.println("Output : "+sb.toString());
    }
}