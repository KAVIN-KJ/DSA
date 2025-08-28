import java.util.*;
public class UniquePairs {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int arr[][] = new int[m][n];
        HashMap<Integer,int[]> mpp = new HashMap<>();
        boolean used[][] = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                arr[i][j] = in.nextInt();
                mpp.put(arr[i][j],new int[]{i,j});
            }
        }
        int trgt = in.nextInt();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int req = trgt-arr[i][j];
                if(mpp.containsKey(req)){
                    int pos[] = mpp.get(req);
                    int x = pos[0];
                    int y = pos[1];
                    if(pos[0]!=i&&!used[i][j]&&!used[x][y]){
                        System.out.println("("+arr[i][j]+", "+arr[x][y]+")");
                        used[i][j] = true;
                        used[x][y] = true;
                    }
                }
            }
        }

        
    }
}
