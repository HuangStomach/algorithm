/**
 * 复原IP地址
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 */
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();
        restore(s, 0, list, new ArrayList<>());
        return list;
    }

    public void restore(String s, int start, List<String> list, List<String> temp) {
        if (temp.size() == 4) {
            if (start != s.length()) return;
            StringBuilder sb = new StringBuilder();
            for (String str: temp) {
                sb.append(str);
                sb.append(".");
            }
            sb.setLength(sb.length() - 1);
            list.add(sb.toString());
        }

        for (int i = 1; i <= 3; i++) {
            int newLength = s.length() - start - i;
            if (newLength < 0 || newLength < 3 - temp.size() || newLength > (4 - temp.size()) * 3) continue;
            if (i > 1 && s.charAt(start) == '0') continue;

            String sub = s.substring(start, start + i);
            int val = Integer.parseInt(sub);
            if (val >= 0 && val < 256) {
                temp.add(sub);
                restore(s, start + i, list, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }
}