
import java.util.*;
//  MERGE SORT

// public class Practice {
//     public static void main(String[] args) {
//         int arr[] = {1,2,6,5,3,9,8,4,7};
//         mergeSort(arr);
//         for(int i:arr) System.out.print(i+" ");

//     }

//     private static void mergeSort(int[] arr) {
//         if(arr.length<=1) return;
//         int lt[] = new int[arr.length/2];
//         int rt[] = new int[arr.length-lt.length];
//         int j=0;
//         for(int i=0;i<arr.length;i++){
//             if(i<lt.length){
//                 lt[i] = arr[i];
//             }
//             else{
//                 rt[j] = arr[i];
//                 j++;
//             }
//         }
//        mergeSort(lt);
//        mergeSort(rt);
//        merge(lt,rt,arr);
//     }

//     private static void merge(int[] lt, int[] rt, int[] arr) {
//         int i=0,j=0,x=0;
//         while(i<lt.length && j<rt.length){
//             if(lt[i] < rt[j]){
//                 arr[x] = lt[i];
//                 i++;
//                 x++;
//             }
//             else {
//                 arr[x] = rt[j];
//                 j++;
//                 x++;
//             }
//         }
//         while(i<lt.length){
//             arr[x] = lt[i];
//             i++;
//             x++;
//         }
//         while(j<rt.length){
//             arr[x] = rt[j];
//             j++;
//             x++;
//         }
//     }
// }

// PRINT SUBSEQUENCES

// import java.util.ArrayList;

// public class Practice {
     
//     public static void main(String[] args) {
//         int arr[] = {1,5,2,6,4,8,9,10};
//         ArrayList<Integer> al = new ArrayList<>();
//         printSubseq(0,arr,al);
//         int k = 15;
//         printSubseq_With_SumK(0,arr,al,k,0);
//     }

//     private static void printSubseq_With_SumK(int i,int[] arr, ArrayList<Integer> al, int k,int curr) {
//          if(i>=arr.length){
//             if(curr==k){
//                 System.out.println(al);
//             }
//             return;
//          }
//          al.add(arr[i]);
//          printSubseq_With_SumK(i+1, arr, al, k, curr+arr[i]);
//          al.remove(al.getLast());
//          printSubseq_With_SumK(i+1, arr, al, k, curr);
//      }

//     private static void printSubseq(int i, int[] arr, ArrayList<Integer> al) {
//         if(i>=arr.length){
//             System.out.println(al);
//             return;
//         }
//         al.add(arr[i]);
//         printSubseq(i+1, arr, al);
//         al.remove(al.getLast());
//         printSubseq(i+1, arr, al);
//     }
    
// }


// TRAINING NINJA


// public class Practice {

//     public static void main(String[] args) {
//         Scanner in = new Scanner(System.in);
//         int days = in.nextInt();
//         int task = in.nextInt();
//         int tasks[][] = new int[days][task];
//         for(int i=0;i<days;i++){
//             for(int j=0;j<task;j++){
//                 tasks[i][j] = in.nextInt();
//             }
//         }
//         int dp[][] = new int[days][task];
//         for(int i=0;i<days;i++){
//             for(int j=0;j<task;j++){
//                 dp[i][j] = -1;
//             }
//         }
//         int ans = trainNinja(days-1,-1,tasks,dp);
//         System.out.println(ans);
//     }
//     private static int trainNinja(int day, int last, int[][] tasks, int[][] dp) {
//         if(day==0){
//             int max=0;
//             for(int i=0;i<tasks[day].length;i++){
//                 if(i!=last)
//                 max = Math.max(max,tasks[day][i]);
//             }
//             return max;
//         }
//         if(last!=-1&&dp[day][last]!=-1) return dp[day][last];
//         int max=0;
//         for(int i=0;i<tasks[day].length;i++){
//             if(i!=last){
//                 int points = tasks[day][i] + trainNinja(day-1, i, tasks, dp);
//                 max = Math.max(points,max);
//             }
//         }
//         if(last!=-1) dp[day][last] = max;
//         return max;
//     }   
// }

//  INSERTION SORT

// public class Practice {

//     public static void main(String[] args) {
//         int arr[] = {9,1,4,2,3,7,6,8,0,5};
//         insertSort(arr);
//         for(int i : arr){
//             System.out.print(i+" ");
//         }
//     }

//     private static void insertSort(int[] arr) {
//         int n = arr.length;
//         for(int i=1;i<n;i++){ 
//             int j = i-1;
//             int temp = arr[i];
            
//             while(j>=0&&arr[j]>temp){ 
//                 arr[j+1]=arr[j];
//                 j--; 
//             }
//             arr[j+1]=temp;       
//          }
//     }

    
// }


public class Practice {

    public static void main(String args[]) {
        int x = 10;
        System.out.print(x + " ");
    }

    static {
        int x = 20;
        System.out.print(x + " ");
    }

}