import java.util.*;

/*LEETCODE 2999 (hard)
 * 
 * You are given three integers start, finish, and limit. You are also given a 0-indexed string s representing a positive integer.

A positive integer x is called powerful if it ends with s (in other words, s is a suffix of x) and each digit in x is at most limit.

Return the total number of powerful integers in the range [start..finish].

A string x is a suffix of a string y if and only if x is a substring of y that starts from some index (including 0) in y and extends to the index y.length - 1. For example, 25 is a suffix of 5125 whereas 512 is not.


 * 
 */

public class CountPowerFulIntegers {
    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        String st = Long.toString(start-1);
        String nd = Long.toString(finish);
        return solve(nd,s,limit) - solve(st,s,limit);
    }
    static long solve(String num, String s, int lim){
        if(num.length() < s.length()) return 0;
        if(num.length()==s.length()) return num.compareTo(s) >=0 ? 1 : 0;
        int preflen = num.length() - s.length();
        String suf = num.substring(preflen);
        long count = 0;
        for(int i=0;i<preflen;i++){
            int dig = num.charAt(i) - '0';
            if(dig>lim){
                count+=(long)Math.pow(lim+1,preflen-i);
                return count;
            }
            count+=(long)dig * (long)Math.pow(lim+1,preflen-i-1);
        }
        if(suf.compareTo(s)>=0) count++;
        return count;
    }
}
