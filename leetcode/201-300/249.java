/**
 * 移位字符串分组
 * 给定一个字符串，对该字符串可以进行 “移位” 的操作，也就是将字符串中每个字母都变为其在字母表中后续的字母，比如："abc" -> "bcd"。这样，我们可以持续进行 “移位” 操作，从而生成如下移位序列：
 * "abc" -> "bcd" -> ... -> "xyz"
 * 给定一个包含仅小写字母字符串的列表，将该列表中所有满足 “移位” 操作规律的组合进行分组并返回。
 */
class Solution {
    public List<List<String>> groupStrings(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList();
        }
        Map<String, List> map = new HashMap<>();
        String offset = "";
        for (String s : strs) {
            char[] ch = s.toCharArray();
            for (int i = 0; i < ch.length - 1; i++) {
                offset += computeDistance(ch[i], ch[i + 1]) + ",";
            }
            if (offset.length() > 0) {
                offset.substring(0, offset.length() - 1);
            }
            if (!map.containsKey(offset)) {
                map.put(offset, new ArrayList());
            }
            map.get(offset).add(s);
            offset = "";
        }
        return new ArrayList(map.values());
    }

    public static int computeDistance(char ch1, char ch2) {
        if (ch2 - ch1 > 0) {
            return ch2 - ch1;
        }
        return 26 + ch2 - ch1;
    }
}
