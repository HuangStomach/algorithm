/**
 * 组合总和 III
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 */
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new ArrayList<>();
        if (n > 45 || k > 9 || n <= 0 || k <= 0) return list;
        sum(k, n, list, new ArrayList<>());
        return list;
    }

    public void sum(int k, int n, List<List<Integer>> list, List<Integer> temp) {
        if (k == 0 && n == 0) {
            list.add(new ArrayList<>(temp));
        }
        else if (k <= 0 || n <= 0) return;

        int start = temp.size() > 0 ? temp.get(temp.size() - 1) : 0;
        for (int i = start + 1; i <= 9; i ++) {
            temp.add(i);
            sum(k - 1, n - i, list, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
