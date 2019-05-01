/**
 * 前K个高频元素
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 */
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i: nums) {
            int times = map.getOrDefault(i, 0);
            map.put(i, times + 1);
        }
        
        PriorityQueue<Integer> max = new PriorityQueue<>(map.size(), new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return map.get(b) - map.get(a);
            }
        });

        for (int i: map.keySet()) {
            max.offer(i);
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(max.poll());
        }
        return list;
    }
}