/**
 * Print_Subsequences_With_Sum_K
 */
import java.util.*;
public class Print_Subsequences_With_Sum_K {
public static void main(String[] args) {
    int arr[] = {1,2,3,4,5,6,7,8,9,10};
    int k = 13;
    ArrayList<Integer> al = new ArrayList<>();
    System.out.println("Subsequences : ");
    printSubsequences(0,arr,al,k,0);
    
}

private static void printSubsequences(int i, int[] arr, ArrayList<Integer> al, int k,int curr) {
    if(i>=arr.length){
        if(curr==k){
            System.out.println(curr);
            System.out.println(al);
        }
        return;
    }

    al.add(arr[i]);
    printSubsequences(i+1, arr, al, k, arr[i]+curr);
    al.remove(al.getLast());
    printSubsequences(i+1, arr, al, k, curr);

}
   
}