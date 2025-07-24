package Arrays_Series_Striver;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
        public List<Integer> spiralOrder(int[][] arr) {
        int tp = 0;
        int bt = arr.length-1;
        int lt = 0;
        int rt = arr[0].length-1;
        List<Integer> ans = new ArrayList<>();
        while(lt<=rt && tp<=bt){
            for(int i=lt;i<=rt;i++){
                ans.add(arr[tp][i]);
            }
            tp++;
            for(int i=tp;i<=bt;i++){
                ans.add(arr[i][rt]);
            }
            rt--;
            if(tp<=bt){
                for(int i=rt;i>=lt;i--){
                    ans.add(arr[bt][i]);
                }
                bt--;
            }
            if(lt<=rt){
                for(int i=bt;i>=tp;i--){
                    ans.add(arr[i][lt]);
                }
                lt++;
            }
        }
        return ans;
    }
}
