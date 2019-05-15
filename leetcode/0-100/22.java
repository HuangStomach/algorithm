/**
 * 括号生成
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 */
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        generate(new char[n * 2], 0, 0, 0, res);
        return res;
    }
    
    // count1统计“(”的个数，count2统计“)”的个数
    public void generate(char[] chars, int pos, int countLeft, int countRight, List<String> res) {
        if (countLeft < countRight) return;
        if (countLeft > countRight && pos == chars.length) return;
        if (pos == chars.length) {
            res.add(new String(chars));
            return;
        }

        chars[pos] = '(';
        generate(chars, pos + 1, countLeft + 1, countRight, res);
        chars[pos] = ')';
        generate(chars, pos + 1, countLeft, countRight + 1, res);
    }
}
