import java.util.ArrayList;

// 125
class Solution {
    public boolean isPalindrome(String s) {
        if (s.length() == 0) return true;
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < s.length(); i++) {
            int code = (int)s.charAt(i);
            if (code < 90 && code > 65) code += 32;
            if ((code < 122 && code > 97) || (code > 48 && code < 57)) {
                list.add(code);
            }
        }

        int length = list.size();
        for (int i = 0; i < length / 2; i++) {
            if (list.get(i) != list.get(length - i - 1)) return false;
        }
        return true;
    }
}