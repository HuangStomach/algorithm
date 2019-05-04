/**
 * 寻找重复数
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 */
class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        int t = 0;

        // 因为存在重复数，所以一定是存在环的，找到位于环中的一个数
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) break;
        }

        // 然后开始遍历环，在环中找到重复的数字
        while (true) {
            slow = nums[slow];
            t = nums[t];
            if (slow == t) break;
        }

        return slow;
    }
    
    // 或者进行二分搜索，判断左右的数值是否都不和自己重复，缩小查询范围
}
