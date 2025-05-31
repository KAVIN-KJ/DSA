import java.util.*;

public class TopKFrequentElements {
    public static int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer,Integer> mpp = new HashMap<>();
        for(int i : nums){ mpp.put(i,mpp.getOrDefault(i,0)+1); }
    
        int n = nums.length;
        @SuppressWarnings("unchecked")
        List<Integer> bucket[] = new List[n+1];
    
        for(int key : mpp.keySet()){
            int freq = mpp.get(key);
            if(bucket[freq]==null) bucket[freq] = new ArrayList<>();
            bucket[freq].add(key);
        }
    
        List<Integer> res = new ArrayList<>();
        for(int i=n;i>=0&&res.size()<k;i--){
            if(bucket[i]!=null)
                res.addAll(bucket[i]);
        }
        int ans[] = new int[k];
        for(int i=0;i<k;i++){
            ans[i] = res.get(i);
        }
        return ans;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++) arr[i] = in.nextInt();
        int k = in.nextInt();
        int ans[] = topKFrequent(arr, k);
        for(int i : ans) System.out.print(i+" ");
        System.out.println();
        in.close();
    }
}
