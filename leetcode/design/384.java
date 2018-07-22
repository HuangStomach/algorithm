import java.util.Arrays;
import java.util.Random;

class Solution {
    private int[] nums;

    public Solution(int[] nums) {
        this.nums = nums;
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return this.nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int length = this.nums.length;
        int[] shuffle = Arrays.copyOf(this.nums, length);
        Random rn = new Random();
        for (int i = 0; i < length; i++) {
            int val = rn.nextInt(length);
            if (i == val) continue;
            int tmp = shuffle[i];
            shuffle[i] = shuffle[val];
            shuffle[val] = tmp;
        }
        return shuffle;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */