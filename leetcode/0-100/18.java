/**
 * 四数之和
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums.length < 4) return list;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {
            if (nums[i] >= 0 && target < 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int val = nums[i] + nums[j];

                int low = j + 1;
                int high = nums.length - 1;
                while (low < high) {
                    if (nums[low] + nums[high] + val == target) {
                        List<Integer> subList = new ArrayList<>();
                        subList.add(nums[i]);
                        subList.add(nums[j]);
                        subList.add(nums[low]);
                        subList.add(nums[high]);
                        list.add(subList);

                        while (low < high && nums[low] == nums[low + 1]) low++;   //注意去重
                        while (low < high && nums[high] == nums[high - 1]) high--;
                        low++;
                        high--;
                    }
                    else if (nums[low] + nums[high] + val < target) low++;
                    else high--;
                }
            }
        }

        return list;
    }
}
