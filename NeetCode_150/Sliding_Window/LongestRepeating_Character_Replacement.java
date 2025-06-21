
public class LongestRepeating_Character_Replacement {
     public int characterReplacement(String s, int k) {
        int freq[] = new int[26];
        int lt=0,rt=0,ans=0,maxfreq=0;

        while(rt<s.length()){
            int ind = s.charAt(rt)-'A';
            freq[ind]++;
            maxfreq = Math.max(maxfreq,freq[ind]);
            if(((rt-lt)+1)-maxfreq > k){
                freq[s.charAt(lt++)-'A']--;
            }
            ans = Math.max(((rt-lt)+1),ans);
            rt++;
        }
        return ans;
    }
}
