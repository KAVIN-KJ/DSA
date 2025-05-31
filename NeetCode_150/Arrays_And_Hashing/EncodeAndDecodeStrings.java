import java.util.*;

public class EncodeAndDecodeStrings {
    static String encode(List<String> strs){
        
        StringBuilder sb = new StringBuilder();
        for(String s : strs){
            sb.append(s.length()).append("#").append(s);
        }

        return sb.toString();
    }
    static List<String> decode(String str){

        List<String> ans = new ArrayList<>();
        int i=0;
        while (i<str.length()) {
            int j = i;
            while(str.charAt(j)!='#') j++;
            int len = Integer.parseInt(str.substring(i, j));
            j++;
            ans.add(str.substring(j, j+len));
            i=j+len;
        }

        return ans;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        List<String> strs = new ArrayList<>();
        for(int i=0;i<n;i++){
            String a=in.nextLine();
            strs.add(a);
        }
        System.out.println(encode(strs));
        for(String s : decode(encode(strs))){
            System.out.println(s);
        }
        in.close();
    }
}
