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
        int ltsize = arr.length/2;
        int rtsize = arr.length - ltsize;
        int lt[] = new int[ltsize];
        int rt[] = new int[rtsize];
        int j=0;
        for(int i=0;i<arr.length;i++){
            if(i<ltsize){
                lt[i] = arr[i];
            }
            else{
                rt[j] = arr[i];
                j++;
            }
        }
        mergeSort(lt);
        mergeSort(rt);
        merge(lt,rt,arr);
    }

    private static void merge(int[] lt, int[] rt, int[] arr) {
        int i=0,l=0,r=0;
        while(l<lt.length && r<rt.length){
            if(lt[l]>rt[r]){
                arr[i] = rt[r];
                r++;
                i++;
            }
            else{
                arr[i] = lt[l];
                l++;
                i++;
            }
        }
        while(l<lt.length){
            arr[i] = lt[l];
            l++;
            i++;
        }
        while(r<rt.length){
            arr[i] = rt[r];
            r++;
            i++;
        }
    }
}
