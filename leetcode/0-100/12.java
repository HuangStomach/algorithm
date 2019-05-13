/**
 * 整数转罗马数字
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 * 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
 */
class Solution {
    public String intToRoman(int num) {
        //用数组定义字典
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1}; 
        String[] strs = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        
        //定义一个字符串
        StringBuilder res = new StringBuilder();
        
        for (int i = 0; i < values.length; i++){
            int a = num / values[i];
            if (a == 0) continue;
            for (int j = a; j > 0; j--) res.append(strs[i]);
            num -= (a * values[i]);
            if (num == 0) break;
        }
        return res.toString();
    }
}