/**
 * 最大数
 * 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
 */
import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String largestNumber(int[] nums) {
        String[] strings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strings[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s2 + s1).compareTo(s1 + s2);
            }
        });
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            stringBuilder.append(strings[i]);
        }
        while ('0' == stringBuilder.charAt(0)) {
            stringBuilder.deleteCharAt(0);
            if (0 == stringBuilder.length()) return "0";
        }
        return stringBuilder.toString();
    }
}