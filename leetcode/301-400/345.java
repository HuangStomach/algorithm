/**
 * 反转字符串中的元音字母
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 */
class Solution {
    public String reverseVowels(String s) {
        boolean[] alpha = new boolean[256];

        alpha['a'] = alpha['A'] = alpha['e'] = alpha['E'] = true;
        alpha['i'] = alpha['I'] = alpha['o'] = alpha['O'] = true;
        alpha['u'] = alpha['U'] = true;

        char[] array = s.toCharArray();
        int start = 0;
        int end = array.length - 1;
        
        while (start < end) {
            while (start < end && !alpha[array[start]]) start ++;
            while (start < end && !alpha[array[end]]) end--;
            if (start < end) {
                char temp = array[start];
                array[start] = array[end];
                array[end] = temp;
                start ++;
                end --;
            }
        }
        return new String(array);
    }
}