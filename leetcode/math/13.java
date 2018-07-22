import java.util.HashMap;

class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int val = 0;
        int length = s.length();
        for (int i = 0; i < s.length(); i++) {
            int j = map.get(s.charAt(i));
            if (i < length - 1) {
                int k = map.get(s.charAt(i + 1));
                if (j < k) {
                    val += k - j;
                    i++;
                    continue;
                }
            }
            val += j;
        }
        return val;
    }
}