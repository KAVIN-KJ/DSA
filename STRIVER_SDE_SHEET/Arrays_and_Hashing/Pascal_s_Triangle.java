package Arrays_and_Hashing;
import java.util.Scanner;

/*
 *  1.) Print the element of Rth row and Cth column of the triangle -> (R-1)C (c-1)
 *  2.) Print the Rth row of the triangle
 *  3.) Print the entire pascal's triangle of height n -> use Method 2 for each row.
 * 
 * 
 */
public class Pascal_s_Triangle {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter row : ");
        int r = in.nextInt();
        System.out.println("Enter Column : ");
        int c = in.nextInt();
        int ans = findncr(r - 1, c - 1);
        System.out.println("Element at row " + r + " and column " + c + " is :" + ans);
        System.out.println("Enter the row to be printed : ");
        r = in.nextInt();
        printRow(r);
        System.out.println("Enter the size of the pascal's triangle : ");
        int n = in.nextInt();
        printPascal(n);
        in.close();

    }

    private static void printPascal(int n) {
        for(int i=1;i<=n;i++){
            printRow(i);
            System.out.println();
        }
    }

    private static void printRow(int r) {
       int ans = 1;
       System.out.print(ans+" ");
       for(int i=1;i<r;i++){
         ans = ans * (r-i);
         ans = ans / i;
         System.out.print(ans+" ");
       }
    }

    private static int findncr(int n, int r) {
        int ans = 1;
        for (int i = 0; i < r; i++) {
            ans *= n - i;
            ans /= (i + 1);
        }
        return ans;
    }

}