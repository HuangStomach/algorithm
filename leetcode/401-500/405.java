/**
 * 数字转换为十六进制数
 * 给定一个整数，编写一个算法将这个数转换为十六进制数。对于负整数，我们通常使用 补码运算 方法。
 */
class Solution {
    public String toHex(int num) {
        if (num == 0) return "0";
        StringBuffer ret = new StringBuffer();
        while (num!=0 && ret.length() < 8){
            int temp = num & 0xf;
            ret.append(temp >=10 ? Character.toString((char)('a' + temp - 10)) : temp);
            num >>= 4;
        }
        return ret.reverse().toString();
    }
}