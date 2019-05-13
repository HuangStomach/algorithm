/**
 * 下一个更大元素 I
 * 给定两个没有重复元素的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2 中的下一个比其大的值。
 * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出-1。
 */
import java.util.HashMap;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
		int length = nums1.length;
		int[] res = new int[length];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
		for (int i = 0; i < nums2.length - 1; i++) {
			for (int j = i + 1; j < nums2.length; j++) {
				if (nums2[j] > nums2[i]) {
					map.put(nums2[i], nums2[j]);
					break;
				}
			}
        }
        
		for (int i = 0; i < length; i++) {
            res[i] = map.getOrDefault(nums1[i], -1);
        }
        
		return res;
	}
}