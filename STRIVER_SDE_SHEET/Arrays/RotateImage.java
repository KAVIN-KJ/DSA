// GIVEN AN N * N MATRIX ... RETURN THE ROTATED MATRIX BY 90 DEGREES
package Arrays;

import java.util.Scanner;

public class RotateImage {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        System.out.println();
        bruteForce(arr, n);
        System.out.println();
        optimal(arr, n);
        in.close();
    }

    private static void optimal(int[][] arr, int n) {
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
        for(int i=0;i<n;i++){
            int lt=0;
            int rt=n-1;
            while(lt<rt){
                int temp = arr[i][lt];
                arr[i][lt] = arr[i][rt];
                arr[i][rt] = temp;
                lt++;
                rt--;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void bruteForce(int[][] arr, int n) {
        int ans[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans[j][(n - i) - 1] = arr[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}
