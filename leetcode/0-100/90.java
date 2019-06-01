/**
 * 子集 II
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        subsets(nums, 0, list, new ArrayList<>());
        return list;
    }

    public void subsets(int[] nums, int start, List<List<Integer>> list, List<Integer> temp) {
        if (start == nums.length) return;

        for (int i = start; i < nums.length; i++){
            //不同点就是来个判重
            if (i > start && nums[i] == nums[i - 1]) continue;

            temp.add(nums[i]);
            list.add(new ArrayList<>(temp));
            subsets(nums, i + 1, list, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
