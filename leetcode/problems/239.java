/**
 * 滑动窗口最大值
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口 k 内的数字。滑动窗口每次只向右移动一位。
 * 返回滑动窗口最大值。
 */
import java.util.LinkedList;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length < 2) return nums;
        // 双向队列 保存当前窗口最大值的数组位置 保证队列中数组位置的数按从大到小排序
        LinkedList<Integer> list = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            while (!list.isEmpty() && nums[list.peekLast()] <= nums[i]) {
                list.pollLast();
            }

            list.addLast(i);
            
            if (list.peek() < i - k + 1) {
                list.poll();
            }

            if (i - k + 1 >= 0){
                res[i - k + 1] = nums[list.peek()];
            }
        }
        return res;
    }
}
