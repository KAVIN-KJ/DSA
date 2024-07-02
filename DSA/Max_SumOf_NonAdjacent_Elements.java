import java.util.Arrays;

public class Max_SumOf_NonAdjacent_Elements {

    public static void main(String[] args) {
        int arr[] = {5, 5, 10, 100, 10, 5};


        // int arr[] = {
        //     27314, 9533, 19464, 3096, 18307, 6048, 161, 22596, 32082, 7795, 3491, 32268, 4562, 2738, 
        //     6634, 31596, 29529, 6250, 7199, 11253, 4230, 14284, 20352, 31357, 4902, 27775, 26084, 23317,
        //     16984, 14139, 6905, 8507, 20464, 15764, 3281, 1617, 5402, 9235, 32157, 29774, 576, 20107,
        //     25272, 26804, 17965, 31402, 25831, 962, 28786, 26831, 13791, 6122, 4872, 1819, 24327, 19845,
        //     10040, 21195, 28032, 11974, 14776, 25541, 8035, 12268, 8727, 22128, 30281, 1980, 18778, 1993,
        //     21265, 27695, 17384, 22452, 32477, 1896, 17059, 25999, 17758, 14568, 8024, 31501, 1106, 30469,
        //     2137, 6466, 21578, 25752, 3944, 23546, 11953, 28407, 8151, 10063, 13578, 2083, 8174, 21371,
        //     32121, 20802, 16781, 19178, 2181, 18767, 17938, 20116, 17436, 21520, 14717, 21641, 16343, 11592,
        //     26835, 13517, 30336, 7215, 6080, 6247, 20690, 31519, 14719, 24245, 17791, 26512, 12543, 27906,
        //     14968, 11846, 23614, 7258, 2920, 18377, 28409, 14749, 22913, 30998, 24712, 19411, 2172, 27796,
        //     28932, 5311, 3291, 22345, 2474, 32695, 28530, 32334, 31876, 29363, 10789, 12416, 26438, 13731,
        //     16883, 2169, 15734, 25606, 16948, 2751, 15823, 7352, 32030, 29754, 22248, 25611, 13710, 19692,
        //     16145, 27674, 5638, 4828, 17277, 14170, 6385, 4435, 4775, 18802, 17967, 14411, 1518, 23117,
        //     27085, 2085, 11906, 16237, 10260, 26010, 10628, 32642, 4806, 27124, 32617, 17467, 9124, 894,
        //     4768, 7772, 16435, 31289, 24948, 20497, 10944, 11472, 7987
        // };


        int dp[] = new int[arr.length];
        Arrays.fill(dp, -1);
        System.out.println(maxSumDP(arr.length-1,arr,dp));
        System.out.println(maxSum(arr.length-1,arr));
        System.out.println(maxSumTab(arr));
        System.out.println(maxSumSpaceOpt(arr));
    }

    private static int maxSumTab(int[] arr) {
        int dp[] = new int[arr.length];
        dp[0] = arr[0];
        for(int i=1;i<arr.length;i++){
            int include = arr[i];
            if(i>1) include+=dp[i-2];
            int exclude = dp[i-1];
            dp[i] = Math.max(include,exclude);
        }
        return dp[arr.length-1];
    }

    private static int maxSum(int i, int[] arr) {
       if(i==0) return arr[i];
       if(i<0) return 0;
       int pick = arr[i] + maxSum(i-2, arr);
       int not_pick = maxSum(i-1, arr);
       return Math.max(pick,not_pick);
    }

    private static int maxSumDP(int i,int[] arr,int[] dp) {
        if(i==0) return arr[i];
        if(i<0) return 0;
        if(dp[i]!=-1) return dp[i];
        int pick = arr[i] + maxSumDP(i-2,arr,dp);
        int n_pick = maxSumDP(i-1, arr,dp);
        return dp[i] = Math.max(pick,n_pick);
    }

    private static int maxSumSpaceOpt(int arr[]){      // Space Optimized Function
        int prev = arr[0],prev2 = 0;
        for(int i=1;i<arr.length;i++){
            int include = arr[i] + prev2;
            int exclude = prev;
            int curr = Math.max(include,exclude);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }


    
}