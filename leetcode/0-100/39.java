/**
 * 组合总和
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 */
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        sum(candidates, target, 0, list, new ArrayList<>());
        return list;
    }

    public void sum(int[] candidates, int target, int start, List<List<Integer>> list, List<Integer> subList) {
        if (target < 0) return;
        if (target == 0) {
            list.add(new ArrayList<>(subList));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            subList.add(candidates[i]);
            sum(candidates, target - candidates[i], i, list, subList);
            subList.remove(subList.size() - 1);
        }
    }
}