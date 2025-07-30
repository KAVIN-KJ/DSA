package Arrays_Series_Striver;

public class NextPermutation {
    public void nextPermutation(int arr[]) {
        int n = arr.length;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                for (int j = n - 1; j >= i + 1; j--) {
                    if (arr[j] > arr[i]) {
                        int temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                        break;
                    }
                }
                int lt = i + 1;
                int rt = n - 1;
                while (lt < rt) {
                    int temp = arr[lt];
                    arr[lt++] = arr[rt];
                    arr[rt--] = temp;
                }
                return;
            }
        }
        int lt = 0;
        int rt = n - 1;
        while (lt < rt) {
            int temp = arr[lt];
            arr[lt++] = arr[rt];
            arr[rt--] = temp;
        }
    }
}
