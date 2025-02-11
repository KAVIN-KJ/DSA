package GreedyAlgorithms;

import java.util.*;

class meet {
    int st;
    int nd;

    meet(int s, int e) {
        this.st = s;
        this.nd = e;
    }
}

class MaximumMeetings {
    public static int maxMeetings(int start[], int end[]) {
            // add your code here
            int n = start.length;
            meet arr[] = new meet[n];
            for (int i = 0; i < n; i++) {
                arr[i] = new meet(start[i], end[i]);
            }
            Arrays.sort(arr, (i, j) -> Integer.compare(i.nd, j.nd));
            int freeingTime = arr[0].nd;
            int count = 1;
            for (int i = 1; i < n; i++) {
                if (arr[i].st > freeingTime) {
                    count++;
                    freeingTime = arr[i].nd;
                }
            }
            return count;
        }
    
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            int start[] = new int[n];
            int end[] = new int[n];
            System.out.println("Enter starting and ending time of a meeting : ");
            for(int i=0;i<n;i++){
                start[i] = in.nextInt();
                end[i] = in.nextInt();
            }
            int maxMeetings = maxMeetings(start,end);
            System.out.println("Maximum meetings that can be attended is : "+maxMeetings);
        in.close();
    }
}