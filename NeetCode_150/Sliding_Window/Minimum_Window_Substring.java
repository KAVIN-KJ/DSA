package NeetCode_150.Sliding_Window;

public class Minimum_Window_Substring {

        public static String minWindow(String s, String t) {
        int fs[] = new int[256];
        int ft[] = new int[256];
        for(char c : t.toCharArray()) ft[c]++;
        int req = 0;
        for(int i : ft){
            if(i>0) req++;
        }
        int lt=0,rt=0,match=0;
        int minlen = Integer.MAX_VALUE;
        int minst=0;
        while(rt<s.length()){
            char cr = s.charAt(rt);
            fs[cr]++;
            if (ft[cr] > 0 && fs[cr] == ft[cr]) match++;
            while(match==req){
                if((rt-lt+1) < minlen){
                    minlen = (rt-lt)+1;
                    minst = lt;
                }
                char cl = s.charAt(lt);
                fs[cl]--;
                if (ft[cl] > 0 && fs[cl] < ft[cl]) match--;

                lt++;
            }
            rt++;
        }
        return minlen != Integer.MAX_VALUE ? s.substring(minst, minst + minlen) : "";
    }
    
}