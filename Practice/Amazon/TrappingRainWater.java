package Amazon;
import java.util.*;

public class TrappingRainWater {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = in.nextInt();
        }   
        int pfix[] = new int[n];
        int sfix[] = new int[n];
        pfix[0] = arr[0];
        sfix[n-1] = arr[n-1];
        for(int i=1,j=n-2;i<n && j>=0;i++,j--){
            pfix[i] = Math.max(pfix[i-1],arr[i]);
            sfix[j] = Math.max(sfix[j+1], arr[j]);
        }
        int total = 0;
        for(int i=0;i<n;i++){
            total += Math.min(pfix[i],sfix[i]) - arr[i];
        }
        System.out.println("Total water that can be caught : "+total);
    }
}
