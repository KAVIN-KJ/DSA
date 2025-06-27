package NeetCode_150.Stacks;

import java.util.*;

public class Car_Fleet {
         public int carFleet(int target, int[] pos, int[] sp) {
        int n = pos.length;
        double arr[][] = new double[n][2];
        for(int i=0;i<n;i++){
            arr[i][0] = (double)pos[i];
            arr[i][1] = (double)(target - pos[i]) / sp[i];
        }
        Arrays.sort(arr, (a,b)-> Double.compare(b[0],a[0]));
        /*
         * Approach 1 :
         */
        double time = 0;
        int fleet = 0;
        for(int i=0;i<n;i++){
            if(arr[i][1] > time){
                fleet++;
                time = arr[i][1];
            }
        }
        System.out.println(fleet);
        /*
         * Approach 2 :
         */
        Stack<Double> st = new Stack<>();
        for(int i=0;i<n;i++){
            st.push(arr[i][1]);
            if(st.size() >=2){
                double first = st.pop();
                double second = st.pop();
                if(first <= second){
                    st.push(second);
                }
                else{
                    st.push(second);
                    st.push(first);
                }
            }
        }
        System.out.println(st.size());
        return st.size();
    }
}
