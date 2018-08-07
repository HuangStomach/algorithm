/**
 * 每次都要使 n - 1个元素 + 1 实际上就是最大的元素 - 1
 * 也就是要把所有元素都减到和最小元素一样小
 * 所以每个元素都要做和最小元素的差
 * 相当于所有元素的和 减去元素个数个最小元素的差
 */

class Solution {
    public int minMoves(int[] nums) {
        int sum = nums[0];
        int min = nums[0];
        for (int i = 1; i < nums.length; i++){
            min = Math.min(nums[i], min);
            sum += nums[i];
        }
        return sum - min * nums.length;
    }
}
