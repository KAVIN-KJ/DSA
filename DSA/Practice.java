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

import java.util.ArrayList;

public class Practice {
     
    public static void main(String[] args) {
        int arr[] = {1,5,2,6,4,8,9,10};
        ArrayList<Integer> al = new ArrayList<>();
        printSubseq(0,arr,al);
        int k = 15;
        printSubseq_With_SumK(0,arr,al,k,0);
    }

    private static void printSubseq_With_SumK(int i,int[] arr, ArrayList<Integer> al, int k,int curr) {
         if(i>=arr.length){
            if(curr==k){
                System.out.println(al);
            }
            return;
         }
         al.add(arr[i]);
         printSubseq_With_SumK(i+1, arr, al, k, curr+arr[i]);
         al.remove(al.getLast());
         printSubseq_With_SumK(i+1, arr, al, k, curr);
     }

    private static void printSubseq(int i, int[] arr, ArrayList<Integer> al) {
        if(i>=arr.length){
            System.out.println(al);
            return;
        }
        al.add(arr[i]);
        printSubseq(i+1, arr, al);
        al.remove(al.getLast());
        printSubseq(i+1, arr, al);
    }
    
}
