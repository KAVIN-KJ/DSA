package Amazon;
import java.util.*;
public class SpiralMatrix {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int arr[][] = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++)
                arr[i][j] = in.nextInt();
        }
        in.close();
        int left = 0;
        int right = m-1;
        int top = 0;
        int bottom = n-1;
        ArrayList<Integer> al = new ArrayList<>();
        while(left<=right && top<=bottom){
            for(int i=left;i<=right;i++){
                al.add(arr[top][i]);
            }
            top++;
            for(int i=top;i<=bottom;i++){
                al.add(arr[i][right]);
            }
            right--;
            if(top<=bottom){
                for(int i=right;i>=left;i--){
                    al.add(arr[bottom][i]);
                }
                bottom--;
            }
            if(left<=right){
                for(int i=bottom;i>=top;i--){
                    al.add(arr[i][left]);
                }
                left++;
            }
        }
        for(int i : al){
            System.out.print(i+" ");
        }
    }

}
