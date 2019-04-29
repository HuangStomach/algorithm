/**
 * 数组中的第K个最大元素
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int[] sorted = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            sorted[i] = nums[i - 1];
            swim(sorted, i);
        }

        for (int i = 0; i < k - 1; i++) {
            sorted[1] = sorted[nums.length - i];
            sorted[nums.length - i] = Integer.MIN_VALUE;
            sink(sorted, nums.length - i - 1);
        }
        return sorted[1];
    }

    private void swim(int[] sorted, int k) {
        while (k > 1 && sorted[k] > sorted[k / 2]) {
            int temp = sorted[k / 2];
            sorted[k / 2] = sorted[k];
            sorted[k] = temp;
            k = k / 2;
        }
    }

    private void sink(int[] sorted, int N) {
        int k = 1;
        while (k * 2 <= N) {
            int j = k * 2;
            if (j < N && sorted[j + 1] > sorted[j]) j++;
            if (sorted[k] > sorted[j]) break;
            int temp = sorted[k];
            sorted[k] = sorted[j];
            sorted[j] = temp;
            k = j;
        }
    }
}