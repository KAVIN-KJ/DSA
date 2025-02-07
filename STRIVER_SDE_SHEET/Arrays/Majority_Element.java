package Arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Majority_Element {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }   
        int ans = solveByHashing(arr);
        System.out.println("Majority Element : " + ans);
        ans = MooresVotingAlgorithm(arr);
        System.out.println("Majority Element : "+ans);
        in.close();
    }

    private static int MooresVotingAlgorithm(int[] nums) {
        // int n = nums.length;
        // int el = nums[0];
        // int cnt = 0;
        // for(int i : nums){
        //     if(cnt==0){
        //         el = i;
        //         cnt = 1;
        //     }
        //     else if(i==el) cnt++;
        //     else cnt--;
        // }
        // int c = 0;
        // for(int i : nums){
        //     if(i==el){
        //         c++;
        //     }
        // }
        // return (c > n/2) ?  el : -1;
        int el = nums[0];
        int count = 0;
        for(int i : nums){
            if(count==0){
                el = i;
                count = 1;
            }
            else if(i==el) count++;
            else count--;
        }
        int c=0;
        for(int i : nums){
            if(el==i){
                c++;
            }
        }

        return (c>nums.length/2) ? el : -1;
    }

    private static int solveByHashing(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int value = map.getOrDefault(arr[i], 0);
            map.put(arr[i], value + 1);
        }

        for (Map.Entry<Integer, Integer> i : map.entrySet()) {
            if (i.getValue() > arr.length / 2) {
                return i.getKey();
            }
        }

        return -1;
    }
}
