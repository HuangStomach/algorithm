class Solution {
    public int removeElement(int[] nums, int val) {
        int length = nums.length;
        for (int i = length - 1; i >= 0; i--) {
            if (nums[i] != val) continue;
            
            if (i + 1 != length) {
                nums[i] = nums[length - 1];
            }
            length--;
        }
        return length;
    }
}