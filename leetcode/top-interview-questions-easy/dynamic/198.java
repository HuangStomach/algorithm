import java.util.ArrayList;

class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(nums[0]);
        list.add(Math.max(nums[0], nums[1]));
        for (int i = 2; i < nums.length; i++) {
            list.add(Math.max(nums[i] + list.get(i - 2), list.get(i - 1)));
        }
        return list.get(nums.length - 1);
    }
}
