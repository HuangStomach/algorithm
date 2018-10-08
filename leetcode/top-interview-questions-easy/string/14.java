class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = "";
        String first = strs[0];
        for (int i = 0; i < first.length(); i++) {
            String str = prefix + first.charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].indexOf(str) == 0) continue;
                else return prefix;
            }
            prefix = str;
        }
        return prefix;
    }
}