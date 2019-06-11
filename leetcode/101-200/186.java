/**
 * 翻转字符串里的单词 II
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 */
class Solution {
    public void reverseWords(char[] str) {
        if (str.length == 0) return;

        int start = 0;
        for (int i = 0; i <= str.length; i++) {
            if (str[i] == ' ' || i == str.length - 1) {
                if (i == str.length - 1) i++;
                int length = i - start;
                for (int j = 0; j < length / 2; j++) {
                    char temp = str[start + j];
                    str[start + j] = str[start + length - j - 1];
                    str[start + length - j - 1] = temp;
                }
                start = i + 1;
            }
        }

        for (int i = 0; i < str.length / 2; i++) {
            char temp = str[i];
            str[i] = str[str.length - i - 1];
            str[str.length - i - 1] = temp;
        }
    }
}