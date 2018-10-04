import java.util.Arrays;

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        for (int i = 0; i < numbers.length && numbers[i] <= target / 2; i++) {
            int j = target - numbers[i];
            int index = Arrays.binarySearch(numbers, i + 1, numbers.length, j);
            if (index > 0) {
                result[0] = i + 1;
                result[1] = index + 1;
                return result;
            } 
        }
        return result;
    }
}