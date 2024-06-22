public class MergeSort {
    public static void main(String[] args) {
        int arr[] = {8,7,3,4,6,5,1,9,2,0};
        mergeSort(arr);
        for(int i : arr){
            System.out.print(i+" ");
        }
    }

    private static void mergeSort(int[] arr) {
        
        if(arr.length<=1) return;
        int length = arr.length;
        int j=0;
        int lts=length/2; 
        int lt[] = new int[lts];
        int rt[] = new int[length-lts];
        for(int i=0;i<length;i++){
            if(i<lts){
                lt[i] = arr[i];
            }else{
                rt[j] = arr[i];
                j++;
            }
        }
        mergeSort(lt);
        mergeSort(rt);
        merge(lt, rt, arr);

    }

    private static void merge(int[] lt, int[] rt, int[] arr) {

        int lts = lt.length;
        int rts = rt.length;
        int i=0,l=0,r=0;
        while(l<lts && r<rts){
            if(lt[l] < rt[r]){
                arr[i] = lt[l];
                l++;
                i++;
            }
            else{
                arr[i] = lt[l];
                arr[i] = rt[r];
                r++;
                i++;
            }
        }
        while(l<lts){
            arr[i] = lt[l];
            l++;
            i++;
        }
        while(r<rts){
            arr[i] = rt[r];
            r++;
            i++;
        }
    }
}
