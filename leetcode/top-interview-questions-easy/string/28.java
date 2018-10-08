// 28

class Solution {
    public int strStr(String haystack, String needle) {
        int needleLength = needle.length();
        if (needleLength == 0) return 0;

        int length = haystack.length();
        if (haystack.length() == 0) return -1;

        for (int i = 0; i < length; i++) {
            if (haystack.charAt(i) != needle.charAt(0)) continue;
            if (length - i < needleLength) continue;

            for (int j = i; j <= length; j++) {
                if (j - i == needleLength) return i;
                if (haystack.charAt(j) != needle.charAt(j - i)) break;
            }
        }

        return -1;
    }
}