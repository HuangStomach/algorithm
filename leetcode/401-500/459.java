/**
 * 重复的子字符串
 * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
 */
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int length = s.length();
        for (int i = 1; i <= length / 2; i++) {
            if (length % i > 0) continue;

            String sub = s.substring(0, i);
            boolean flag = true;
            for (int j = i; j < length - i; j += i) {
                if (!s.substring(j, j + i).equals(sub)) {
                    flag = false;
                    break;
                }
            }
            if (flag) return true;
        }
        return false;
    }
}