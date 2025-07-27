package Arrays_Series_Striver;

/*
 * 
IMPORTANT TIP :
    90 = transpose + reverse row
    180 = reverse row + reverse column
    270 = transpose + reverse col
 */


public class RotateMatrix {
    public void rotate(int[][] arr) {
        int n = arr.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
        for(int i=0;i<n;i++){
            int lt = 0;
            int rt = n-1;
            while(lt<rt){
                int temp = arr[i][lt];
                arr[i][lt] = arr[i][rt];
                arr[i][rt] = temp;
                lt++;
                rt--;
            }
        }
    }
}
