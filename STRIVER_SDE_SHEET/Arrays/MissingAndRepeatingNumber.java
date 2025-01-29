package STRIVER_SDE_SHEET.Arrays;

import java.util.Scanner;

public class MissingAndRepeatingNumber {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        long n = in.nextInt();
        int arr[] = new int[(int)n];
        
        for(int i=0;i<n;i++){
            arr[i] = in.nextInt();
        }
        long s = 0;
        long s2 = 0;
        for(int i=0;i<n;i++){
            s += arr[i];   
            s2 += (long)arr[i] * (long)arr[i];
        }
        long sn = (n * (n+1))/2;
        long sn2 = ( n * (n+1) * (2*n+1) ) / 6;
        long val1 = s - sn;
        long val2 = (int)(s2-sn2);
        val2 = val2/val1;
        long x = (val1+val2)/2;
        long y = x - val1;
        System.out.println("Missing no : "+y);
        System.out.println("Repeated no : "+x);
        in.close();
    }
}