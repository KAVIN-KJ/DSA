package ARRAYS;

public class SearchAMatrix {
    class Solution {
    public boolean searchMatrix(int[][] arr, int trgt) {
        int m = arr.length;
        int n = arr[0].length;
        int lt = 0;
        int rt = (m*n) - 1;
        while(lt<=rt){
            int mid = (lt+rt)/2;
            int r = mid/n;
            int c = mid%n;
            int num = arr[r][c];
            if(num>trgt){
                rt = mid-1;
            }
            else if(num<trgt){
                lt = mid+1;
            }
            else{
                return true;
            }
        }
        return false;
    }
}
}
