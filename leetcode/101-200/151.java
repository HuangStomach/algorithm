/**
 * 翻转字符串里的单词
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 */
class Solution {
    public String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        StringBuilder sb = new StringBuilder();

        for (char c: s.toCharArray()) {
            if (c == ' ') {
                if (sb.length() > 0) {
                    sb.append(' ');
                    result.insert(0, sb.toString());
                    sb.setLength(0);
                }
            }
            else {
                sb.append(c);
            }
        }

        if (sb.length() > 0) {
            sb.append(' ');
            result.insert(0, sb.toString());
        }
        if (result.length() > 0) result.setLength(result.length() - 1);
        return result.toString();
    }
}