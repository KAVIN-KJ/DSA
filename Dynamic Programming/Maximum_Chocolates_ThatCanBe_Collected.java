import java.util.Scanner;

public class Maximum_Chocolates_ThatCanBe_Collected {
    public static void main(String[] args) {
         Scanner in = new Scanner(System.in);
        int m=in.nextInt();
        int n=in.nextInt();
        int arr[][] = new int[m][n];            
        int dp[][] = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                arr[i][j] = in.nextInt();
                dp[i][j] = -1;
            }
        }
        int ans = maxCandy(0,0,n-1,arr);
        System.out.println(ans);
        in.close();
    }


// RECURSION
    private static int maxCandy(int i, int j1, int j2, int[][] arr) {
        if(j1<0||j1>=arr[0].length||j2<0||j2>=arr[0].length) return (int)-1e9;
        if(i==arr.length-1){
            if(j1==j2) return arr[i][j1];
            else return arr[i][j1]+arr[i][j2];
        }
        int ans=0;
        for(int d1=-1;d1<=1;d1++){
            for(int d2=-1;d2<=1;d2++){
                if(j1+d1>=0&&j1+d1<arr[0].length&&j2+d2>=0&&j2+d2<arr[0].length){
                    if(j1==j2) ans = Math.max(ans,arr[i][j1] + maxCandy(i, j1+d1, j2+d2, arr));
                    else ans =Math.max(ans,(arr[i][j1]+arr[i][j2]+maxCandy(i, j1+d1, j2+d2, arr))); 
                }
            }
        }
        return ans;
    }
}
