/**
 * Print_Subsequences
 */
import java.util.*;
public class Print_Subsequences {

    public static void main(String[] args) {
        int arr[] = {3,1,2};
        ArrayList<Integer> list = new ArrayList<>();
        PrintSubsequences(0,arr,list);
    }

    private static void PrintSubsequences(int i, int[] arr, ArrayList<Integer> list) {
        if(i==arr.length){
            System.out.println(list);
            return;
        }
        list.add(arr[i]);
        PrintSubsequences(i+1, arr, list);
        list.remove(list.getLast());
        PrintSubsequences(i+1, arr, list);
    }
}