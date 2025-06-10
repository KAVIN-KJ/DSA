import java.util.*;

public class BinaryOnes {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n+1];
        for(int i=1;i<=n;i++){
            arr[i] = binaryOnes(i);
        }
        in.close();
        for(int i=0;i<=n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    static int binaryOnes(int n){
        int count = 0;
        while(n>0){
            if(n%2==1){
                count++;
            }
            n/=2;
        }
        return count;
    }
}



/*
 x = 17;
 17/2 = 8;1
 8/2 = 4;0
 4/2 = 2;0
 2/2 = 1;0
 1/2 = 0;1
 
 1 2 4 8 16
 1 0 0 0 1
 */