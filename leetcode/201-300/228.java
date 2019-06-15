/**
 * 汇总区间
 * 给定一个无重复元素的有序整数数组，返回数组区间范围的汇总。
 */
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        if (nums.length == 0) return list;

        StringBuilder sb = new StringBuilder();

        int left = 0;
        sb.append(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] + 1 == nums[i]) {
                if (i == nums.length - 1) {
                    sb.append("->");
                    sb.append(nums[i]);
                }
            }
            else {
                if (i > left + 1) {
                    sb.append("->");
                    sb.append(nums[i - 1]);
                }
                list.add(sb.toString());
                sb.setLength(0);
                sb.append(nums[i]);
                left = i;
            }
        }
        if (sb.length() > 0) list.add(sb.toString());

        return list;
    }
}