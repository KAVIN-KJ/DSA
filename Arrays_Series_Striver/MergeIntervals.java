package Arrays_Series_Striver;
import java.util.*;
public class MergeIntervals {
    public int[][] merge(int[][] arr) {
        Arrays.sort(arr,(a1,b)-> a1[0]-b[0]);
        int n = arr.length;
        int st = arr[0][0];
        int nd = arr[0][1];
        ArrayList<int[]> al = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(nd>=arr[i][0]){
                nd = Math.max(nd,arr[i][1]);
            }
            else{
                al.add(new int[]{st,nd});
                st = arr[i][0];
                nd = arr[i][1];
            }
        }
        al.add(new int[]{st,nd});
        int ans[][] = new int[al.size()][2];
        int j=0;
        for(int[] i : al){
            ans[j++] = i;
        }
        return ans;
    }
}
