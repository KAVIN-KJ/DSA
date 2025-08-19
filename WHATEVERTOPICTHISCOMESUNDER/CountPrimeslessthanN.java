package WHATEVERTOPICTHISCOMESUNDER;

import java.util.Arrays;

public class CountPrimeslessthanN {
    public int countPrimes(int n) {
        boolean flag[] = new boolean[n+1];
        Arrays.fill(flag,true);
        int cnt = 0;
        for(int i=2;i*i<n;i++){
            if(flag[i]){
                for(int j=i*i;j<n;j+=i){
                    flag[j]=false;
                }
            }
        }
        for(int i=2;i<n;i++){
            if(flag[i]) cnt++;
        }
        return cnt;
    }
}
