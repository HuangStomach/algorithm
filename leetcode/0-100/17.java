/**
 * 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */
import java.util.ArrayList;
import java.util.List;

class Solution {
    public String[] keyboard;

    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits.length() == 0) return list;

        keyboard = new String[]{
            "", "", "abc", "def",
            "ghi", "jkl", "mno",
            "pqrs", "tuv", "wxyz"
        };
        
        list.add("");
        for (int i = 0; i < digits.length(); i++) {
            int j = digits.charAt(i) - '0';
            append(j, list);
        }
        return list;
    }

    public List<String> append(int num, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            String str = list.remove(0);
            String keys = keyboard[num];
            for (int j = 0; j < keys.length(); j++) {
                list.add(str + Character.toString(keys.charAt(j)));
            }
        }
        return list;
    }
}