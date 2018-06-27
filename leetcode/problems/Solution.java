// TODO: 43
class Solution {
    public static String multiply(String num1, String num2) {
        String big;
        String small;
        if (num1.length() > num2.length()) {
            big = num1;
            small = num2;
        }
        else {
            big = num2;
            small = num1;
        }

        long result = 0;
        for (int i = 0; i < small.length(); i++) {
            for (int j = 0; j < big.length(); j++) {
                int unit = (int)Math.pow(10, (i + j));
                long product = (long)(small.charAt(small.length() - i - 1) - '0') 
                * (long)(big.charAt(big.length() - j - 1) - '0') * unit;
                System.out.println(unit);
                System.out.println(product);
                result += product;
            }
        }
        System.out.println(result);
        return Long.toString(result);
    }

    public static void main(String[] args) {
        multiply("123", "456");
    }
}