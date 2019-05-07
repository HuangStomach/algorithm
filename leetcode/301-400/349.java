/**
 * 两个数组的交集
 * 给定两个数组，编写一个函数来计算它们的交集。
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            if (i < (nums1.length - 1) && nums1[i] == nums1[i + 1]) continue;
            if (Arrays.binarySearch(nums2, nums1[i]) >= 0) {
                list.add(nums1[i]);
            }
        }

        int[] array = new int[list.size()];
        int i = 0;
        for (int j: list) {
            array[i++] = j;
        }
        return array;
    }
}