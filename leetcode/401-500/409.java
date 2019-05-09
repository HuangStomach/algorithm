/**
 * 最长回文串
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 */
class Solution {
    public int longestPalindrome(String s) {
        char a[] = s.toCharArray();
        int b[] = new int[100];
        int count = 0;
        boolean flag = false;
        
        for (char c : a) b[c - 'A']++;
        
        for (int k : b) {
            if (k == 0) continue;
            int m = k / 2;
            int n = k % 2;
            if (n == 1) flag = true;
            count += 2 * m;
        }
        return flag ? count + 1 : count;
    }
}