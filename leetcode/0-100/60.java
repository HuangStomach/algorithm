/**
 * 第k个排列
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 */
import java.util.ArrayList;
import java.util.List;

class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> num = new ArrayList<>();
        for (int i = 1; i <= n; i++) num.add(i);
        int[] factorial = new int[n];
        factorial[0] = 1;
        for (int i = 1; i < n; i++) factorial[i] = i * factorial[i - 1];
        n--;
        StringBuilder res = new StringBuilder();
        while (n >= 0){
            int t = factorial[n];
            int loc = (int) (Math.ceil((double) k / (double) t)) - 1;
            if (loc == -1) loc = num.size() - 1;
            res.append(num.get(loc));
            num.remove(loc);
            k %= t;
            n--;
        }
        return res.toString();
    }
}