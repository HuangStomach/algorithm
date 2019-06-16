/**
 * 为运算表达式设计优先级
 * 给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。你需要给出所有可能的组合的结果。有效的运算符号包含 +, - 以及 * 。
 */
class Solution {
    public Map<String, List<Integer>> map = new HashMap<>();

    public List<Integer> diffWaysToCompute(String input) {
        if (map.containsKey(input)) return map.get(input);

        List<Integer> list = new ArrayList<>();
        int len = input.length();

        for (int i = 0; i < len; i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
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
        map.put(input, list);
        return list;
    }
}