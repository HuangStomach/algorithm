/**
 * 全排列 II
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 */
import java.util.Arrays;

class Solution {
    private boolean[] flag;

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;

        Arrays.sort(nums);
        flag = new boolean[nums.length];
        traceback(result, new ArrayList<>(), nums);
        return result;
    }

    private void traceback(List<List<Integer>> result, List<Integer> temp, int[] nums) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (flag[i]) continue;
            if (i > 0 && !flag[i - 1] && nums[i - 1] == nums[i]) continue;
            
            temp.add(nums[i]);
            flag[i] = true;
            traceback(result, temp, nums);
            flag[i] = false;
            temp.remove(temp.size() - 1);
        }
    }
}