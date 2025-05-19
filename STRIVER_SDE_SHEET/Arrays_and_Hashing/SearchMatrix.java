package Arrays_and_Hashing;

import java.util.Scanner;

public class SearchMatrix {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int arr[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        int trgt = in.nextInt();
        if (search(arr, trgt))
            System.out.println("Found !");
        else
            System.out.println("Not Found");
        in.close();
    }

    private static boolean search(int[][] arr, int trgt) {
        int m = arr.length;
        int n = arr[0].length;
        int low = 0;
        int high = (m*n)-1;
        while (low<high) {
            int mid = (low+high)/2;
            int temp = arr[mid/n][mid%n];
            if(trgt == temp) return true;
            else if(trgt < temp) high = mid-1;
            else low = mid+1;
        }
        return false;
    }
}
