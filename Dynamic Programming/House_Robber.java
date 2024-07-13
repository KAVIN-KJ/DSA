import java.util.ArrayList;

public class House_Robber {
    public static void main(String[] args) {
        int arr[] = {2,3,2};
        ArrayList<Integer> al1 = new ArrayList<>();
        ArrayList<Integer> al2 = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            if(i>0) al1.add(arr[i]);
            if(i<arr.length-1) al2.add(arr[i]);
        }
        System.out.println(Math.max(robHouse(al1),robHouse(al2)));
    }
    public static int robHouse(ArrayList<Integer> al){
        int prev=al.get(0);
        int prev2 = 0;
        if(al.size()==1) return al.get(0);
        for(int i=1;i<al.size();i++){
            int include = al.get(i)+prev2;
            int exclude = prev;
            int curr = Math.max(include,exclude);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}
