package Trees;
import java.util.ArrayList;
import java.util.List;



/*
 * 
 * 
        You are given the root of a binary search tree and an array queries of size n consisting of positive integers.

        Find a 2D array answer of size n where answer[i] = [mini, maxi]:

        mini is the largest value in the tree that is smaller than or equal to queries[i]. If a such value does not exist, add -1 instead.
        maxi is the smallest value in the tree that is greater than or equal to queries[i]. If a such value does not exist, add -1 instead.
        Return the array answer.
 * 
 * 
 */


public class ClosestNodesToQueries {
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<Integer> lst = new ArrayList<>();
        traverse(root,lst);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i : queries){
            ans.add(find(lst,i));
        }
        return ans;
    }

    static void traverse(TreeNode root,List<Integer> lst){
        if(root==null) return;
        traverse(root.left,lst);
        lst.add(root.val);
        traverse(root.right,lst);
    }

    static List<Integer> find(List<Integer> lst,int x){
        int min = -1;
        int max = -1;

        List<Integer> ans = new ArrayList<>();

        int st = 0;
        int nd = lst.size()-1;

        while(st<=nd){
            int mid = (st+nd)/2;
            int tp = lst.get(mid);
            if(tp<=x){
                min = tp;
                st = mid+1;
            }
            else{
                nd = mid-1;
            }
        }

        st = 0;
        nd = lst.size()-1;

        while(st<=nd){
            int mid = (st+nd)/2;
            int tp = lst.get(mid);
            if(tp>=x){
                max = tp;
                nd = mid-1;
            }
            else{
                st = mid+1;
            }
        }

        ans.add(min);
        ans.add(max);

        return ans;
        
    }
}
