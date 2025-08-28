import java.util.*;
public class ZigZagPatern {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int m = in.nextInt();
        int n = s.length()/2;
        char arr[][] = new char[m][n];
        int x = 0;
        boolean vert = true;
        int i=0,j=0;
        while(x<s.length()){
            if(vert){
                while(i<m&&x<s.length()){
                    arr[i++][j] = s.charAt(x++);
                    System.out.println("loop1");
                }
                i = m-2;
                j++;
                vert = false;
            }
            else{
                while(i>=0&&j<n&&x<s.length()){
                    arr[i--][j++] = s.charAt(x++);
                    System.out.println("loop2");

                }
                if(x>0)
                x--;
                i++;
                j--;
                vert = true;
            }
                    System.out.println("loop outer");

        }
        for(i=0;i<m;i++){
            for(j=0;j<n;j++){
                System.out.print(arr[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
