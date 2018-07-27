import java.util.ArrayList;

class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int total = 0;
        for (int i = 0; i < n; i++) {
            total += nums[i];
        }

        return  (n + 1) * n / 2 - total;
    }
}
