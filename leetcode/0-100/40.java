/**
 * 组合总和 II
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用一次。
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
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
            if (i > start && candidates[i - 1] == candidates[i]) continue;
            int val = candidates[i];
            subList.add(val);
            sum(candidates, target - val, i + 1, list, subList);
            subList.remove(subList.size() - 1);
        }
    }
}