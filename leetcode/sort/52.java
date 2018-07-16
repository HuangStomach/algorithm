class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            insert(nums1, m++, nums2[i]);
        }
    }

    private void insert(int[] nums, int m, int val) {
        int i = m;
        while (i > 0) {
            if (nums[i - 1] > val) {
                nums[i] = nums[i - 1];
            }
            else break;
            i--;
        }
        nums[i] = val;
    }
}
