/**
 * 递增的三元子序列
 * 给定一个未排序的数组，判断这个数组中是否存在长度为 3 的递增子序列。
 */

class Solution {
    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        if (nums.length < 3) return false;

        for (int num: nums) {
            if (first > num) first = num;
            else if (first < num && second > num) second = num;
            else if (num > second) return true;
        }
        return false;
    }

}
