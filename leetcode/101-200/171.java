/**
 * Excel表列序号
 * 给定一个Excel表格中的列名称，返回其相应的列序号。
 */
class Solution {
    public int titleToNumber(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res = res * 26 + s.charAt(i) - '@';
        }
        return res;
    }
}