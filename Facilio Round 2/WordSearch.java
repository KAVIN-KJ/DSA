import java.util.*;
public class WordSearch {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        char arr[][] = new char[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                arr[i][j] = in.next().charAt(0);
            }
        }
        String s = in.next();
        System.out.println(solve(0,0,0,s,m,n,arr));
    }

    private static boolean solve(int i, int j, int k, String s, int m, int n, char[][] arr) {
        if(i<0||i>=m||j<0||j>=n || k>=s.length() || s.charAt(k)!=arr[i][j]) return false;

        System.out.println(s.charAt(k) +" ("+i+","+j+")");

        if(k==s.length()-1 && arr[i][j]==s.charAt(k)) return true;

        if(i==m-1 && j==n-1){

            if(s.charAt(k)==arr[i][j] && k==s.length()-1) return true;
            

            else return false;
        }

        return solve(i+1,j,k+1,s,m,n,arr) || solve(i,j+1,k+1,s,m,n,arr) || solve(i-1,j,k+1,s,m,n,arr) || solve(i,j-1,k+1,s,m,n,arr);
    }
}




