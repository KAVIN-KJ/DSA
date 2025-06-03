import java.util.Scanner;

public class Trapping_Rainwater {
    static int trap(int[] arr) {
        int lt = 0;
        int rt = arr.length-1;
        int ltmax = 0;
        int rtmax = 0;
        int ans = 0;
        while(lt<rt){
            if(arr[lt]<arr[rt]){
                ltmax = Math.max(ltmax,arr[lt]);
                ans+= (ltmax - arr[lt]);
                lt++;
            }
            else{
                rtmax = Math.max(rtmax,arr[rt]);
                ans+= (rtmax - arr[rt]);
                rt--;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = in.nextInt();
        }
        System.out.println(trap(arr));
        in.close();
    }
}
