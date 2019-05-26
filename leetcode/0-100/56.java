/**
 * 合并区间
 * 给出一个区间的集合，请合并所有重叠的区间。
 */
import java.util.Stack;

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;

        Stack<int[]> stack = new Stack();
        sort(intervals, 0, intervals.length - 1);
        stack.push(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] current = stack.peek();
            if (intervals[i][0] > current[1]) stack.push(intervals[i]);
            else {
                stack.pop();
                current[0] = Math.min(current[0], intervals[i][0]);
                current[1] = Math.max(current[1], intervals[i][1]);
                stack.push(current);
            }
        }

        int size = stack.size();
        int[][] res = new int[size][2];
        for (int j = size - 1; j >= 0; j--) {
            res[j] = stack.pop();
        }
        return res;
    }

    public void sort(int[][] intervals, int low, int high) {
        if (high <= low) return;
        int[] current = intervals[low];
        int i = low;
        int j = high + 1;
        while (true) {
            while (intervals[++i][0] <= current[0]) if (i == high) break;
            while (intervals[--j][0] >= current[0]) if (j == low) break;
            if (i >= j) break;
            int[] temp = intervals[i];
            intervals[i] = intervals[j];
            intervals[j] = temp;
        }

        int[] temp = intervals[j];
        intervals[j] = intervals[low];
        intervals[low] = temp;
        sort(intervals, low, j - 1);
        sort(intervals, j + 1, high);
    }
}