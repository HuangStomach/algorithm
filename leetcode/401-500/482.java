/**
 * 密钥格式化
 * 给定一个密钥字符串S，只包含字母，数字以及 '-'（破折号）。N 个 '-' 将字符串分成了 N+1 组。给定一个数字 K，重新格式化字符串，除了第一个分组以外，每个分组要包含 K 个字符，第一个分组至少要包含 1 个字符。两个分组之间用 '-'（破折号）隔开，并且将所有的小写字母转换为大写字母。
 * 给定非空字符串 S 和数字 K，按照上面描述的规则进行格式化。
 */
class Solution {
    public String licenseKeyFormatting(String S, int K) {
        int len = S.length();
        char[] chs = S.toCharArray();
        final char[] ca = new char[(len / K + 1) * (K + 1)];
        int k = 0;
        int j = ca.length - 1;

        for (int i = len - 1; i >= 0; i--) {
            char ch = chs[i];
            if (ch == '-') continue;

            if (k == K) {
                ca[j--] = '-';
                k = 0;
            }
            if (ch >= 'a' && ch <= 'z') ch -= 32;
            ca[j--]=ch;
            k++;
        }
        
        return new String(ca, ++j, ca.length - j);
    }
}
