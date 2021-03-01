/** 
 * 504. 七进制数
 * 给定一个整数，将其转化为7进制，并以字符串形式输出。
 */
#include <string>

using namespace std;

class Solution {
public:
    string convertToBase7(int num) {
        if (num == 0) return "0";
        bool isNeg = num < 0;

        string s;
        num = abs(num);
        while (num / 7 != 0) {
            s.push_back(num % 7 + '0');
            num /= 7;
        }

        if (num % 7 > 0) s.push_back(num % 7 + '0');
        
        if (isNeg) s.append("-");
        reverse(s.begin(), s.end());
        return s;
    }
};