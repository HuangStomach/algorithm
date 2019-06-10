/**
 * 缺失的区间
 * 给定一个排序的整数数组 nums ，其中元素的范围在 闭区间 [lower, upper] 当中，返回不包含在数组中的缺失区间。
 */
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        long l = lower;
        long u = upper;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - l == 1) res.add(String.valueOf(l));
            else if (nums[i] - l > 1) res.add(l + "->" + (nums[i] - 1));
            l = (long) nums[i] + 1;
        }

        if (l == u) res.add(String.valueOf(l));
        else if (l < u) res.add(l + "->" + u);

        return res;
    }
}