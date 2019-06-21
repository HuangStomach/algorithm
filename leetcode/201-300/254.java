/**
 * 因子的组合
 * 整数可以被看作是其因子的乘积。
 * 8 = 2 x 2 x 2;
 *   = 2 x 4.
 * 请实现一个函数，该函数接收一个整数 n 并返回该整数所有的因子组合。
 */
class Solution {
    public List<List<Integer>> getFactors(int n) {
        return helper(n, 2);
    }

    private List<List<Integer>> helper(int n, int start) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = start; i * i <= n; i++) {
            if (n % i != 0) continue;

            int y = n / i;
            List<List<Integer>> temp = helper(y, i);
            for (List<Integer> ele : temp) {
                ele.add(i);
                result.add(ele);
            }
            List<Integer> e = new ArrayList<>();
            e.add(i);
            e.add(y);
            result.add(e);
        }

        return result;
    }
}