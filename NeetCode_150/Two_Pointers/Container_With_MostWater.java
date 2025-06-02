import java.util.Scanner;

public class Container_With_MostWater {
    public static int maxArea(int[] height) {
        int maxa = 0;
        int lt = 0;
        int rt = height.length-1;
        while(lt<rt){
            int h = Math.min(height[lt],height[rt]);
            int area = h * (rt-lt);
            maxa = Math.max(maxa,area);
            while(lt<rt && height[lt]<=h) lt++;
            while(lt<rt && height[rt]<=h) rt--;
        }
        return maxa;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = in.nextInt();
        }
        in.close();
        System.out.println("Container with Most Water : "+maxArea(arr));
    }
}
