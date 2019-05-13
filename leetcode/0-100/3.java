/**
 * 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 */

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;
        int[] index = new int[128]; 
        
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i); // 记录该字符串出现的位置 如果没有出现过是0
            ans = Math.max(ans, j - i + 1); // 记录以这个字符串开头的字符串的长度（最大）
            index[s.charAt(j)] = j + 1; // 记录该字符串出现的位置
        }
        return ans;
    }
}