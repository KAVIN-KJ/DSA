package Arrays_and_Hashing;
import java.util.*;
public class SubarraysWitXOR_K {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = in.nextInt();
        }
        int k = in.nextInt();
        in.close();

        HashMap<Integer,Integer> mp = new HashMap<>();
        int xr = 0;
        int count = 0;
        mp.put(xr,1);
        for(int i : arr){
            xr = xr ^ i;
            int x = xr ^ k;
            if(mp.containsKey(x)){
                count+=mp.get(x);
            }
            mp.put(xr,mp.getOrDefault(xr,0)+1);
        }
        System.out.println(count);
    }
}
