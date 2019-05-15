/**
 * 三数之和
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums.length < 3) return list;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if (val > 0) break;
            if (i > 0 && val == nums[i - 1]) continue;

            int low = i + 1;
            int high = nums.length - 1;
            while (low < high) {
                if (nums[low] + nums[high] == -val) {
                    if (low == i + 1 || high == nums.length - 1) {
                        List<Integer> subList = new ArrayList<>();
                        subList.add(nums[i]);
                        subList.add(nums[low]);
                        subList.add(nums[high]);
                        list.add(subList);
                        low++;
                        high--;
                    }
                    else if (nums[low] == nums[low - 1]) low++;
                    else if (nums[high] == nums[high + 1]) high--;
                    else {
                        List<Integer> subList = new ArrayList<>();
                        subList.add(nums[i]);
                        subList.add(nums[low]);
                        subList.add(nums[high]);
                        list.add(subList);
                        low++;
                        high--;
                    }
                }
                else if (nums[low] + nums[high] < -val) low++;
                else high--;
            }
        }

        return list;
    }
}
