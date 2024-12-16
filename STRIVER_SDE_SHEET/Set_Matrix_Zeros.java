package STRIVER_SDE_SHEET;
import java.util.*;
public class Set_Matrix_Zeros {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int arr[][] = new int[n][n];
        int row[] = new int[m];
        int col[] = new int[n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                arr[i][j] = in.nextInt();
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]==0){
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(row[i]==1 || col[j]==1) arr[i][j] = 0;
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        in.close();
    }
}