/**
 * 天际线问题
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> result = new ArrayList<>();
        List<int[]> height = new ArrayList<>();
        
        // 将矩形拆分为，左上角坐标和右上角坐标，同时为了区分二者，将左上角的纵坐标设为负值
        for (int[] building: buildings) {
            height.add(new int[]{building[0], -building[2]});
            height.add(new int[]{building[1], building[2]});
        }

        // 按照 优先横坐标从小到大（x轴从左到右），其次纵坐标从小到大 排序
        Collections.sort(height, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0]) return a[0] - b[0];
                else return a[1] - b[1];
            }
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>((x,y) -> y - x);
        // 首先将地平线加入
        pq.offer(0);
        // 记录上一次最大高度
        int prev = 0;

        // 遍历
        for (int[] h: height) {
            // 加入左上角坐标
            if (h[1] < 0) pq.offer(-h[1]);
            else pq.remove(h[1]); //如果此时遇到右上角坐标，那么意味着这个矩形已经处理完了，将左上角坐标移除即可
            
            // 当前最大高度
            int cur = pq.peek();

            // 两次最大高度不一致，说明前一个最大高度被移除，或者新加入了更高的building
            if (prev != cur) {
                //添加拐点
                List<Integer> list = new ArrayList<Integer>();
                list.add(h[0]);
                list.add(cur);
                result.add(list);
                //更新最大高度
                prev = cur;
            }
        }
        return result;
    }
}