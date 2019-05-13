/**
 * 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 */

class Solution {
    public int left = 0;
    public int right = 0;

    public String longestPalindrome(String s) {
        if (s == null || s.trim().length() < 2) return s;

        for (int i = 0; i < s.length(); i++) {
            doLongestPalindrome(s, i, i); // 回文中心为奇数的判断
            doLongestPalindrome(s, i, i + 1); // 回文中心为偶数的判断
        }
        return s.substring(left, right + 1);
    }
    
    // 由回文中心向两边扩散
    private void doLongestPalindrome(String s, int l, int r) {
        // 循环判断是否为回文
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }

        // 判断长度是否大于旧值，大于则进行新植替换旧值
        if (r - l - 1 > right - left + 1) {
            // 由于上面一步会使 l 和 r 多走一步，所以这里需要进行值的还原
            left = l + 1;
            right = r - 1;
        }
    }
}