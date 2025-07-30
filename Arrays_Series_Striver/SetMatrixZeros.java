package Arrays_Series_Striver;

public class SetMatrixZeros {
    public void setZeroes(int[][] arr) {
        int r = arr.length;
        int c = arr[0].length;
        int row[] = new int[r];
        int col[] = new int[c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(arr[i][j]==0){
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(row[i]==1||col[j]==1) arr[i][j] = 0;
            }
        }
    }
}
