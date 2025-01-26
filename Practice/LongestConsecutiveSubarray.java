import java.util.*;

public class LongestConsecutiveSubarray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        int ans = solve(arr);
        System.out.println(ans);

        in.close();
    }

    private static int solve(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int maxLen = 0;
        int prev = arr[0];
        int currLen = 0;
        for(int i=1;i<n;i++){
            if(arr[i]-1 == prev){   
                currLen++;
            }
            else{
                currLen = 1;
            }
            prev = arr[i];
            maxLen = Math.max(maxLen,currLen);
        }
        return maxLen;
    }   
}
