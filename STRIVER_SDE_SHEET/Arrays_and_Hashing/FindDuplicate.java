package Arrays_and_Hashing;
import java.util.Scanner;

public class FindDuplicate {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = in.nextInt();
        }
        int slow = arr[0];
        int fast = arr[0];
        do{
            slow = arr[slow];
            fast = arr[arr[fast]];
        }while(slow!=fast);

        fast = arr[0];
        while(slow != fast) {
            slow = arr[slow];
            fast = arr[fast];
        }
        System.out.println("Duplicate element : "+slow);
        in.close();
    }
}
