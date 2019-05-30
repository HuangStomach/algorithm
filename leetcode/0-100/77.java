/**
 * 组合
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 */
import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        if (k == 0 || n == 0 || k > n) return list;
        combineList(n, k, 1, list, new ArrayList<>());
        return list;
    }

    public void combineList(int n, int k, int start, List<List<Integer>> list, List<Integer> temp) {
        if (k == 0) {
            list.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i <= n - k + 1; i++) { // 剪枝 因为如果剩余的数不够k个也就不用再遍历了
            temp.add(i);
            combineList(n, k - 1, i + 1, list, temp);
            temp.remove(temp.size() - 1);
        }
    }
}