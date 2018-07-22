import java.util.HashMap;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(); 
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == null) map.put(nums[i], 1);
            else if (map.get(nums[i]) == 1) return true;
        }
        return false;
    }
}