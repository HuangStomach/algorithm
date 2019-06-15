/**
 * 存在重复元素 III
 * 给定一个整数数组，判断数组中是否有两个不同的索引 i 和 j，使得 nums [i] 和 nums [j] 的差的绝对值最大为 t，并且 i 和 j 之间的差的绝对值最大为 ķ。
 */
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums.length == 0 || k == 0 || k == 10000) return false;
        if (k >= nums.length)  k = nums.length - 1;

        Set<Long> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) set.remove((long) nums[i - k - 1]);

            Iterator<Long> it = set.iterator();
            while (it.hasNext()) {
                long tmp = it.next();
                if (Math.abs(tmp - nums[i]) <= t) return true;
            }
            set.add((long) nums[i]);
        }
        return false;
    }
}