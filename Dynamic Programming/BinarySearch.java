/**
 * BinarySearch
 */
import java.util.*;

public class BinarySearch {
    public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            int arr[] = new int[n];
            for(int i=0;i<n;i++){
                arr[i] = in.nextInt();
            }
            int trgt = in.nextInt();
            Arrays.sort(arr);
            int lt = 0;
            int rt = n-1;
            in.close();
            while(lt<=rt){
                int mid = (lt+rt)/2;
                int val = arr[mid];
                if(trgt>val) lt = mid+1;
                else if(trgt<val) rt = mid-1;
                else {
                    System.out.println("Found At "+mid);
                    return;
                }
            }
            System.out.println(lt+" "+rt);
            System.out.println("Not found");
    }    
}