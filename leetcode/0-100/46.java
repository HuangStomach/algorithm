/**
 * 全排列
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 */
class Solution {
    private boolean[] flag;

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;
        
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
            if (!flag[i]) {
                temp.add(nums[i]);
                flag[i] = true;
                traceback(result, temp, nums);
                flag[i] = false;
                temp.remove(temp.size() - 1);
            }

        }
    }
}