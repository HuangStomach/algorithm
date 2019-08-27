// 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
// update(i, val) 函数可以通过将下标为 i 的数值更新为 val，从而对数列进行修改。

#include <vector>

using std::vector;

class NumArray {
public:
    vector<int> C;
    vector<int> nums;

    NumArray(vector<int> &nums) : nums(nums) {
        for (int i = 0; i <= nums.size(); ++i) {
            C.push_back(0);
        }
        for (int i = 0; i < nums.size(); ++i) {
            add(i, nums[i]);
        }
    }

    int lowbit(int x) {
        return x & (-x);
    }

    void add(int i, int val) {
        for (int k = i + 1; k <= nums.size(); k += lowbit(k)) {
            C[k] += val;
        }
    }

    void update(int i, int val) {
        int add = val - nums[i];
        nums[i] = val;
        for (int k = i + 1; k <= nums.size(); k += lowbit(k)) {
            C[k] += add;
        }
    }

    int getSum(int i) {
        int sum = 0;
        for (int k = i; k > 0; k -= lowbit(k)) {
            sum += C[k];
        }
        return sum;
    }

    int sumRange(int i, int j) {
        return getSum(j + 1) - getSum(i);
    }
};

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray* obj = new NumArray(nums);
 * obj->update(i,val);
 * int param_2 = obj->sumRange(i,j);
 */