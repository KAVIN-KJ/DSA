package ZohoPractice;
import java.util.*;
public class SudokuSolver {
    static final int n = 9;
    static int ans[][];
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ans = new int[n][n];
        int arr[][] = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j] = in.nextInt();
                ans[i][j] = arr[i][j];
            }
        }
        System.out.println();
        System.out.println();
        System.out.println();
        if(solve(arr)){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    System.out.print(arr[i][j]+" ");
                }
                System.out.println();
            }
        }
        
    }
    static boolean solve(int arr[][]){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]==0){
                    for(int x=1;x<=9;x++){
                        if(safe(i,j,x,arr)){
                            arr[i][j] = x;
                            if(solve(arr)){
                                ans[i][j] = x;
                                return true;
                            } 
                            arr[i][j] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    static boolean safe(int i, int j, int x, int[][] arr) {
        for(int y=0;y<n;y++){
            if(arr[i][y]==x||arr[y][j]==x) return false;
        }
        int rs = i - i%3;
        int cs = j - j%3;
        for(int a=0;a<3;a++){
            for(int b=0;b<3;b++){
                if(arr[rs+a][cs+b]==x) return false;
            }
        }
        return true;
    }
}
