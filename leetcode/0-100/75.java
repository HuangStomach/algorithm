/**
 * 颜色分类
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 */
class Solution {
    public void sortColors(int[] nums) {
        if (nums.length == 0) return;

        int white = 0; // 1
        int blue = 0; // 2
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 2) blue++;
            else if (nums[i] == 1) white++;
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (blue > 0) {
                nums[i] = 2;
                blue--;
            }
            else if (white > 0) {
                nums[i] = 1;
                white--;
            }
            else nums[i] = 0;
        }
    }
}