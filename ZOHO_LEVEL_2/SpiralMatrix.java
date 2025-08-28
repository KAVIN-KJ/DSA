import java.util.*;

public class SpiralMatrix {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int arr[][] = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                arr[i][j] = in.nextInt();
            }
        }
        int t = 0, b = m - 1, l = 0, r = n - 1;
        while (t <= b && l <= r) {
            for (int i = l; i <= r; i++) {
                System.out.print(arr[t][i]+" ");
            }
            t++;
            for (int i = t; i <= b; i++) {
                System.out.print(arr[i][r]+" ");
            }
            r--;
            if (t <= b) {
                for (int i = r; i >=l ; i--) {
                    System.out.print(arr[b][i]+" ");
                }
                b--;
            }
            if(l<=r){
                for (int i = b; i >=t ; i--) {
                    System.out.print(arr[i][l]+" ");
                }
                l++;
            }
        }
        System.out.println();
    }
}