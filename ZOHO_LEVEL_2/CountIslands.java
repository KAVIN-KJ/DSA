import java.util.*;
public class CountIslands {
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
        int count = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]==1){
                    dfs(i,j,arr);
                    count++;
                }
            }
        }
        System.out.println("The NUmber of Islands are : "+count);
    }

    private static void dfs(int i, int j, int[][] arr) {
        if(i<0||j<0||i>=arr.length||j>=arr[0].length){
            return;
        }
        if(arr[i][j]==0) return;
        arr[i][j] = 0;
        dfs(i+1,j,arr);
        dfs(i-1,j,arr);
        dfs(i,j+1,arr);
        dfs(i,j-1,arr);
    }
}
