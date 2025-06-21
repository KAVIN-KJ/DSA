class Solution {
    public String minWindow(String s, String t) {
        int hash[] = new int[256];
        int minlen = (int)1e9;
        int st = -1;
        int l = 0,r = 0;
        for(char c : t.toCharArray()) hash[c]++;
        int cnt = 0;
        while(r<s.length()){
            char c = s.charAt(r);
            if(hash[c]>0) cnt++;
            hash[c]--;
            while(cnt==t.length()){
                if(r-l+1 < minlen){
                    minlen = r-l+1;
                    st = l;
                }
                hash[s.charAt(l)]++;
                if(hash[s.charAt(l)]>0) cnt--;
                l++;
            }
            r++;
        }
        return st==-1 ? "" : s.substring(st,st+minlen);
    }
}