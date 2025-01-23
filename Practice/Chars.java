package Practice;

import java.util.Scanner;

public class Chars {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String ans="";
        int cnt = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            String tp = "";
            if(!isChar(c)){
                cnt = (int)c - 48;
                int j = i+1;
                while(!isChar(s.charAt(j))){
                    cnt*=10;
                    cnt+= (int)c-48;
                    j++;
                    i++;
                }
                while(j<s.length() && isChar(s.charAt(j))){
                    tp+=s.charAt(j);
                    j++;
                }
                for(int k=0;k<cnt;k++){
                    ans+=tp+" ";
                }
            }
        }
        System.out.println(ans);
        in.close();
    }
    public static boolean isChar(char c){
        return (c>='A' && c<='z');
    }
}
