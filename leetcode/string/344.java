// 344

class Solution {
    public String reverseString(String s) {
        char[] array = s.toCharArray();
        int n = array.length / 2;
        for (int i = 0; i < n; i++) {
            char tmp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = tmp;
        }

        return new String(array);
    }
}