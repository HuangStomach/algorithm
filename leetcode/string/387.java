import java.util.LinkedHashMap;

// 387
class Solution {
    public int firstUniqChar(String s) {
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), i);
            }
            else {
                map.put(s.charAt(i), -1);
            }
        }

        for (Map.Entry<Character,Integer> entry :map.entrySet()){
            if (entry.getValue() != -1) {
                return entry.getValue();
            }
        }
        return -1;
    }
}