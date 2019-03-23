/**
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 */
class Solution {
    public int[] sortedSquares(int[] A) {
        if (A.length == 0) return A;
        
        if (A.length == 1) {
            A[0] = (int)Math.pow(A[0], 2);
            return A;
        }

        int[] B = new int[A.length];
        int i = 0;
        int j = A.length - 1;
        int k = A.length - 1;
        while (i <= j) {
            int a = (int)Math.pow(A[i], 2); 
            int b = (int)Math.pow(A[j], 2);
            if (a > b) {
                if (k >= 0) B[k--] = a;
                i++;
            }
            else {
                if (k >= 0) B[k--] = b;
                j--;
            }
        }
        return B;
    }
}