/** 
 * 只出现一次的数字 III
 * 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。
 */
#include <vector>

using namespace std;

class Solution {
public:
	vector<int> singleNumber(vector<int> &nums) {
		int Xor = 0;
		for (int c : nums) Xor ^= c; // 全部异或的值

		int DiffNum = Xor & (~Xor + 1); // 取最低为为 1 的值
		int a = 0, b = 0;

		for (int c : nums) {
			if (c & DiffNum) a ^= c;
			else b ^= c;
		}
		return {a, b};
	}
};