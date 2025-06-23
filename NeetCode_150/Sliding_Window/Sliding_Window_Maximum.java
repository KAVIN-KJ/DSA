import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Sliding_Window_Maximum {
    public int[] maxSlidingWindow(int[] arr, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            while(!dq.isEmpty() && arr[i] >= arr[dq.peekLast()]){
                dq.removeLast();
            }
            dq.addLast(i);
            if(dq.peekFirst() <= i-k) dq.removeFirst();
            if(i>=k-1) res.add(arr[dq.peekFirst()]);
        }
        int ans[] = new int[res.size()];
        int j=0;
        for(int i : res){
            ans[j++] = i;
        }
        return ans;
    }

}
