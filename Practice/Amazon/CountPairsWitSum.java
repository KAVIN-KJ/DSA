package Amazon;
import java.util.*;
public class CountPairsWitSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = in.nextInt();
        }
        int sum = in.nextInt();
        in.close();
        Arrays.sort(arr);
        int lt = 0;
        int count = 0;
        int rt = n-1;
        while(lt<rt){
            if(arr[lt]+arr[rt] > sum){
                rt--;
            }
            else if(arr[lt]+arr[rt]<sum){
                lt++;
            }
            else{
                count++;
                lt++;
                rt--;
            }
        }
        System.out.println("No. of pairs : "+count);
    }
}
