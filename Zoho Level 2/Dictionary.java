import java.util.*;

public class Dictionary {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Dictionary Length : ");
        int n = in.nextInt();
        in.nextLine();
        HashSet<String> st = new HashSet<>();
        System.out.println("Enter Dictionary Words : ");
        for (int i = 0; i < n; i++) {
            String tp = in.nextLine();
            st.add(tp);
        }
        System.out.println("Enter String to be segmented : ");
        String s = in.nextLine();
        in.close();
        int rt = 0;
        int visited = 0;
        for (int lt = 0; lt < s.length() - 1; lt++){

            while (rt < s.length()) {
                String search = s.substring(lt, rt + 1);
                // System.out.println(search);
                if (st.contains(search)) {
                    rt++;
                    lt = rt;
                    visited += search.length();
                }
                rt++;
            }
            if (visited >= s.length()) {
                System.out.println("True");
                return;
            }
        }
        System.out.println("False");
    }
}
