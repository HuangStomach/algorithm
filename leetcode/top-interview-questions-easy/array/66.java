class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            if (digits[i] > 9) {
                digits[i] = 0;
            }
            else {
                break;
            }
        }

        if (digits[0] == 0) {
            int[] tmp = new int[digits.length + 1];
            tmp[0] = 1;
            for (int i = 1; i < digits.length + 1; i++) {
                tmp[i] = digits[i - 1];
            }
            digits = tmp;
        }
        return digits;
    }
}