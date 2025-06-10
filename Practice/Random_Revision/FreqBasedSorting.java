package Random_Revision;
import java.util.*;

class pair {
    int val, freq;
    
    pair(int v) {
        this.val = v;
        this.freq = 1; // set to 1 initially, because it's seen once during creation
    }
    
    public void incr() {
        this.freq++;
    }
}

public class FreqBasedSorting {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] inputArr = new int[n];

        for (int i = 0; i < n; i++) {
            inputArr[i] = in.nextInt();
        }

        // Count frequency using a HashMap
        HashMap<Integer, pair> map = new HashMap<>();
        for (int val : inputArr) {
            if (!map.containsKey(val)) {
                map.put(val, new pair(val));
            } else {
                map.get(val).incr();
            }
        }

        // Transfer map values to array of pairs
        pair[] arr = map.values().toArray(new pair[0]);

        // Bubble Sort based on frequency
        int m = arr.length;
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < m - i - 1; j++) {
                if (arr[j].freq > arr[j + 1].freq) {
                    pair temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        // Output
        System.out.println("Sorted based on frequency:");
        for (pair p : arr) {
            System.out.println("Value: " + p.val + ", Frequency: " + p.freq);
        }

        in.close();
    }
}
