/**
 * 单词模式
 * 给定一种 pattern(模式) 和一个字符串 str ，判断 str 是否遵循相同的模式。
 * 这里的遵循指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应模式。
 */
import java.util.HashMap;

class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] strs = str.trim().split(" ");
        if (pattern.length() != strs.length) return false;
        HashMap<Character, String> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            if (!map.containsKey(pattern.charAt(i))) {
                if (map.containsValue(strs[i])) return false;
                map.put(pattern.charAt(i), strs[i]);
            }

            if (!map.get(pattern.charAt(i)).equals(strs[i])) return false;
        }
        return true;
    }
}