// 8

class Solution {
    public int myAtoi(String str) {
        if (str.isEmpty()) return 0;
        int sign = 1;
        int result = 0;
        int i = 0;
        int length = str.length();

        while (i < length && str.charAt(i) == ' ') {
            ++i;
        };

        if (i == length) return 0;

        if (str.charAt(i) == '+' || str.charAt(i) == '-') {
            sign = (str.charAt(i++) == '+') ? 1 : -1;
        }

        while (i < length && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > 7)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = 10 * result + (str.charAt(i++) - '0');
        }

        return result * sign;
    }
}
