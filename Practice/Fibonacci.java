package Practice;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        // System.out.println(fibonacci(n));w
        for(int i=1;i<=n;i++){
            System.out.print(fibonacci(i)+" ");
        }
    }

    private static int fibonacci(int n) {
        if(n<=1) return n;
        
        return fibonacci(n-1) + fibonacci(n-2);
    }
}
