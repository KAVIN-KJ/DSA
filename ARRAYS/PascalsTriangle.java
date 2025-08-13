package ARRAYS;

import java.util.*;

public class PascalsTriangle {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=1;i<=n;i++){
            ans.add(genRow(i));
        }
        return ans;
    }
    ArrayList<Integer> genRow(int r){
        ArrayList<Integer> row = new ArrayList<>();
        int ans = 1;
        row.add(ans);
        for(int i=1;i<r;i++){
            ans*=(r-i);
            ans/=(i);
            row.add(ans);
        }
        return row;
    }
    int ncr(int n,int r){
        int ans = 1;
        for(int i=0;i<r;i++){
            ans *= (r-i);
            
        }
        return ans;
    }
}
