/**
 * 求众数 II
 * 给定一个大小为 n 的数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
 */
import java.util.List;

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int x = 0;
        int cx = 0;
        int y = 0;
        int cy = 0;
        int count = 0;

        for (int num : nums) {
            if ((cx == 0 || num == x) && num != y) {
                cx++;
                x = num;
            }
            else if (cy == 0 || num == y) {
                cy++;
                y = num;
            }
            else {
                cx--;
                cy--;
            }
        }

        for (int num : nums) {
            if (x == num) count++;
        }

        if (count > nums.length / 3) list.add(x);
        count = 0;

        for (int num : nums) {
            if (y == num) count++;
        }

        if (count > nums.length / 3 && x != y) list.add(y);

        return list;
    }
}