package Amazon;
import java.util.*;
public class SearchInAMatrix {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int arr[][] = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++)
                arr[i][j] = in.nextInt();
        }
        int trgt = in.nextInt();
        in.close();

        int lt = 0;
        int rt = (m*n)-1;
        while(lt<rt){
            int mid = (lt+rt)/2;
            int i = mid/m;
            int j = mid%m;
            if(trgt==arr[i][j]){
                System.out.println("Target found at : "+i+"th row and "+j+"th column");
                return;
            }
            else if(trgt<arr[i][j]){
                rt = mid-1;
            }
            else{
                lt = mid+1;
            }
           
                
            
        }
        System.out.println("Not found");

    }
}
