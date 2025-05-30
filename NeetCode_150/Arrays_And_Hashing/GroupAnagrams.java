import java.util.*;

class Solution {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> mpp = new HashMap<>();
        for(String s: strs){
            char chars[] = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if(!mpp.containsKey(key)){
                mpp.put(key,new ArrayList<>());
            }
            mpp.get(key).add(s);
        }
        return new ArrayList<>(mpp.values());
    }
}

public class GroupAnagrams {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String arr[] = new String[n];
        for(int i = 0;i<n;i++)
            arr[i] = in.nextLine();
        List<List<String>> ans = Solution.groupAnagrams(arr);
        for(List<String> ls : ans){
            for(String str : ls){
                System.out.print(str+" ");
            }
            System.out.println();
        }
        in.close();
    }

}