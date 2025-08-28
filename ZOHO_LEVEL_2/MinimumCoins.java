import java.util.*;
public class MinimumCoins {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = in.nextInt();
        }
        Arrays.sort(arr);
        int rt = n-1;
        int lt = 0;
        while(lt<rt){
            int temp = arr[lt];
            arr[lt++] = arr[rt];
            arr[rt--] = temp;
        }
        int sum = in.nextInt();
        ArrayList<String> ans = new ArrayList<>();
        int d = 0;

        while(sum>arr[n-1]&&sum!=0){
                if(arr[d]>sum){
                    d++;
                    continue;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(arr[d]);
                sb.append(" x "+sum/arr[d]);
                sum -= (sum/arr[d] * arr[d]);
                ans.add(sb.toString());
                while (sum<arr[d]) {
                    d++;
                }
                if(sum%arr[d]==0) break;
        }
        ans.add(arr[d]+" x "+sum/arr[d]);
        System.out.println("Output : ");
        System.out.println(helper(arr, sum, n-1));
        // for(String s : ans) System.out.println(s);
    }
    static int helper(int arr[],int sum,int i){
        if(i==0){
            if(sum%arr[i]==0){
                return sum/arr[i];
            }
            else return Integer.MAX_VALUE;
        }
        int pick = Integer.MAX_VALUE;
        int npick = helper(arr,sum,i-1);
        if(arr[i]<=sum){
            pick = 1 + helper(arr,sum-arr[i],i);
        }
        return Math.min(pick,npick);
    }
}
