package STRIVER_SDE_SHEET;

import java.util.Scanner;

public class UniquePaths {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();

        int ans = solve(m, n);
        System.out.println(ans);
        in.close();
    }

    private static int solve(int m, int n) {
        int ans = 1;
        int N = m+n-2;
        int r = m-1;
        for(int i=1;i<=r;i++){
            ans = ans*(N-r+i)/i;
        }
        return ans;
    }
}
