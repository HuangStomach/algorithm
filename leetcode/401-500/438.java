/**
 * 找到字符串中所有字母异位词
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 */
import java.util.HashMap;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();

        if (s == null || s.equals("") || s.length() < p.length()) return list;

        int[] hash = new int[256];
        for (int j = 0; j < p.length(); j++) {
           hash[p.charAt(j)]++;
        }

        int count = p.length();
        int left = 0;
        int right = 0;

        while (right < s.length()) {
           if (hash[s.charAt(right++)]-- >= 1) count--;
           if (count == 0) list.add(left);
           if ((right - left) == p.length() && hash[s.charAt(left++)]++ >= 0) count++;
        }

        return list;
    }
}