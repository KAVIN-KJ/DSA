package GreedyAlgorithms;
import java.util.*;
public class RearrangeWordsInASentence {
        public static String arrangeWords(String text) {
        String arr[] = text.toLowerCase().split(" ");
        Arrays.sort(arr,new Comparator<String>(){
            public int compare(String a,String b){
                return Integer.compare(a.length(),b.length());
            }
        });
        StringBuilder sb = new StringBuilder();
        sb.append(arr[0]);
        for(int i=1;i<arr.length;i++){
            sb.append(" "+arr[i]);
        } 
        String res = sb.toString();
        return Character.toTitleCase(res.charAt(0))+res.substring(1);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        in.close();
        System.out.println(arrangeWords(s));
    }
}