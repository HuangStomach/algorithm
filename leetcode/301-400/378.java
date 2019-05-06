/**
 * 有序矩阵中第K小的元素
 * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第k小的元素。
 * 请注意，它是排序后的第k小元素，而不是第k个元素。
 */
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int length = matrix.length * matrix.length;
        int[] sorted = new int[length + 1];

        int index = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                sorted[++index] = matrix[i][j];
                swim(sorted, index);
            }
        }

        for (int i = 0; i < k - 1; i++) {
            sorted[1] = sorted[length - i];
            sorted[length - i] = Integer.MIN_VALUE;
            sink(sorted, length - i - 1);
        }
        return sorted[1];
    }

    private void swim(int[] sorted, int k) {
        while (k > 1 && sorted[k] < sorted[k / 2]) {
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
            if (j < N && sorted[j + 1] < sorted[j]) j++;
            if (sorted[k] < sorted[j]) break;
            int temp = sorted[k];
            sorted[k] = sorted[j];
            sorted[j] = temp;
            k = j;
        }
    }
}