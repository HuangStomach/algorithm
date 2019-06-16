/**
 * 为运算表达式设计优先级
 * 给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。你需要给出所有可能的组合的结果。有效的运算符号包含 +, - 以及 * 。
 */
class Solution {
    public Map<String, List<Integer>> map = new HashMap<>();

    // 记录已经计算出来的字符串对应的值，避免重复计算。
    public List<Integer> diffWaysToCompute(String input) {
        if (map.containsKey(input)) return map.get(input);

        List<Integer> list = new ArrayList<>();
        int len = input.length();

        for (int i = 0; i < len; i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') { // 出现运算符号，递归求解前半段和后半段。
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1, input.length()));

                for (int l : left) {
                    for (int r : right) {
                        switch (c) {
                        case '+':
                            list.add(l + r);
                            break;
                        case '-':
                            list.add(l - r);
                            break;
                        case '*':
                            list.add(l * r);
                            break;
                        }
                    }
                }
            }
        }

        if (list.size() == 0) list.add(Integer.valueOf(input));
        // 单独一个数字的情况 (可能出现多位数)
        map.put(input, list);
        return list;
    }
}