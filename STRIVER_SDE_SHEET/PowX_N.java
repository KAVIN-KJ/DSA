package STRIVER_SDE_SHEET;

import java.util.Scanner;

public class PowX_N {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double x = in.nextDouble();
        int n = in.nextInt();
        double ans = 1.0;
        int nn = n;
        if(nn < 0) nn = n*-1;
        while(nn>0){
            if(nn%2==1){
                ans = ans * x;
                nn--;
            }
            else{
                x *= x;
                nn = nn/2;
            }
        }
        if(n<0) ans = (double)1.0 / (double)ans;
        System.out.println(ans);
        in.close();
    }
    
}
