/**
 * 找不同
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 * 请找出在 t 中被添加的字母。
 */
import java.util.HashMap;

class Solution {
    public char findTheDifference(String s, String t) {
        char[] tArray = t.toCharArray();
        char[] sArray = s.toCharArray();
        char result = tArray[0];

        for (int i = 1; i < tArray.length; i++) result ^= tArray[i];
        for (int i = 0; i < sArray.length; i++) result ^= sArray[i];

        return result;
    }
}