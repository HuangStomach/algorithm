/**
 * 搜索二维矩阵
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int R = matrix.length;
        if (R == 0) return false;
        int C = matrix[0].length;
        if (C == 0) return false;

        int low = 0;
        int high = R - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int[] array = matrix[mid];
            if (array[0] > target) high = mid - 1;
            else if (array[C - 1] < target) low = mid + 1;
            else return binarySearch(array, target);
        }

        return false;
    }

    public boolean binarySearch(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int current = array[mid];
            if (current > target) high = mid - 1;
            else if (current < target) low = mid + 1;
            else return true;
        }
        return false;
    }
}
