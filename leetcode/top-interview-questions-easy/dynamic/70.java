public class Solution {
    public int climbStairs(int n) {
        if (n < 3) return n;
        
        int[] r = new int[n+1];
        r[1] = 1;
        r[2] = 2;

        for (int i = 3; i <= n; i++) {
            r[i] = r[i - 1] + r[i - 2];
        }

        return r[n];
    }
}
