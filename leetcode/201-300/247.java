/**
 * 中心对称数 II
 * 中心对称数是指一个数字在旋转了 180 度之后看起来依旧相同的数字（或者上下颠倒地看）。
 * 找到所有长度为 n 的中心对称数。
 */
import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] change = { 0, 1, -1, -1, -1, -1, 9, -1, 8, 6 };

    public List<String> findStrobogrammatic(int n) {
        int index = 1;
        StringBuilder prefix = new StringBuilder();
        StringBuilder suffix = new StringBuilder();
        List<String> list = new ArrayList<>();
        dfs(list, index, n, prefix, suffix);
        return list;
    }

    public void dfs(List<String> list, int index, int n, StringBuilder prefix, StringBuilder suffix) {
        if (index == n / 2 + 1) {
            String tmp = suffix.reverse().toString();
            suffix.reverse();
            if (n % 2 == 0) {
                list.add(prefix.toString() + tmp);
            } else {
                list.add(prefix.toString() + "0" + tmp);
                list.add(prefix.toString() + "1" + tmp);
                list.add(prefix.toString() + "8" + tmp);
            }
            return;
        }

        for (int i = 0; i < 10; ++i) {
            if (n > 1 && index == 1 && i == 0) continue;

            if (change[i] != -1) {
                prefix.append(i);
                suffix.append(change[i]);
                
                dfs(list, index + 1, n, prefix, suffix);
                prefix.setLength(prefix.length() - 1);
                suffix.setLength(suffix.length() - 1);
            }
        }
    }
}