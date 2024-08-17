public class MergeSort {
    public static void main(String[] args) {
        int arr[] = { 8, 7, 3, 4, 6, 5, 1, 9, 2, 0 };
        mergeSort(arr);
        System.out.println();
        System.out.println();
        System.out.println();

        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println();
        System.out.println();

    }

    private static void mergeSort(int[] arr) {
        if (arr.length <= 1)
            return;

        int lts = arr.length / 2;
        int rts = arr.length - lts;

        int ltarr[] = new int[lts];
        int rtarr[] = new int[rts];
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i < lts) {
                ltarr[i] = arr[i];
            } else {
                rtarr[j] = arr[i];
                j++;
            }
        }

        mergeSort(ltarr);
        mergeSort(rtarr);
        merge(ltarr, rtarr, arr);

    }

private static void merge(int[] ltarr, int[] rtarr, int[] arr) {
    int lts = ltarr.length;
    int rts = rtarr.length;
    int i=0,l=0,r=0;
    while(l<lts && r<rts){
        if(ltarr[l]<rtarr[r]){
            arr[i] = ltarr[l];
            l++;
            i++;
        }
        else{
            arr[i] = rtarr[r];
            r++;
            i++;
        }
    }
    while (l<lts) {
        arr[i] = ltarr[l];
        i++;
        l++;
    }
    while(r<rts){
        arr[i] = rtarr[r];
        i++;
        r++;
    }
}

}