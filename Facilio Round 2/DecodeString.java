import java.util.*;

public class DecodeString {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        StringBuilder ans = new StringBuilder();
        int i=0;
        while(i<s.length()){
            char c = s.charAt(i);
            String num = "";
            int n = 0;
            if(c>='0'&&c<='9')
                num = ""+c;
            n = Integer.parseInt(num.length()>0 ? num : "0");
            i+=2;
            StringBuilder str = new StringBuilder();
            while(s.charAt(i)!=']'){
                str.append(s.charAt(i++));
            }
            i++;
            for(int x=0;x<n;x++) ans.append(str);
        }
        System.out.println(ans.toString());
        
    }
}
