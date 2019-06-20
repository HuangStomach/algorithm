/**
 * 会议室 II
 * 给定一个会议时间安排的数组，每个会议时间都会包括开始和结束的时间 [[s1,e1],[s2,e2],...] (si < ei)，为避免会议冲突，同时要考虑充分利用会议室资源，请你计算至少需要多少间会议室，才能满足这些会议安排。
 */
import java.util.PriorityQueue;

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        int res = 0;
        for (int i = 0; i < intervals.length; i++) {
            minQueue.offer(intervals[i][1]);
            if (intervals[i][0] < minQueue.peek()) {
                res++;
            } else {
                minQueue.poll();
            }
        }
        return res;
    }
}
