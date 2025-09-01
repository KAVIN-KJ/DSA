package ZohoPractice;
public class josephusproblem {
    public int josephus(int n, int k) {
        int res = 0; // base case: f(1,k) = 0
        for (int i = 2; i <= n; i++) {
            res = (res + k) % i;
        }
        return res;
    }
}
