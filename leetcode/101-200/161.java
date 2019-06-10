/**
 * 相隔为 1 的编辑距离
 * 给定两个字符串 s 和 t，判断他们的编辑距离是否为 1。
 * 注意：
 * 满足编辑距离等于 1 有三种可能的情形：
 * 往 s 中插入一个字符得到 t
 * 从 s 中删除一个字符得到 t
 * 在 s 中替换一个字符得到 t
 */
class Solution {
    public boolean isOneEditDistance(String s, String t) {
        char[] ss = s.toCharArray();
        char[] ts = t.toCharArray();
        if (ss.length == 0 && ts.length == 0) return false;

        int diff = Math.abs(ss.length - ts.length);
        if (diff > 1) return false;
        
        boolean wrong = false;
        int i = 0;
        int j = 0;

        while (i < ss.length && j < ts.length) {
            if (diff == 0) {
                if (ss[i] != ts[j]) {
                    if (wrong) return false;
                    wrong = true;
                }
                i++;
                j++;
            }
            else {
                if (ss[i++] == ts[j++]) continue;
    
                if (ss.length > ts.length) j--;
                else i--;
    
                wrong = true;
                diff = 0;
            }
        }

        if (ss.length - ts.length == 0 && !wrong) return false;
        return true;
    }
}