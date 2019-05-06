/**
 * 数据流的中位数
 * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 * 例如，
 *   [2,3,4] 的中位数是 3
 *   [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 *   设计一个支持以下两种操作的数据结构：
 *   void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 *   double findMedian() - 返回目前所有元素的中位数。
 */
import java.util.PriorityQueue;

class MedianFinder {
    PriorityQueue<Integer> max;
    PriorityQueue<Integer> min;

    /** initialize your data structure here. */
    public MedianFinder() {
        max = new PriorityQueue<>((x,y) -> y-x);
        min = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        max.offer(num);
        min.offer(max.poll());

        if (max.size() < min.size()) {
            max.offer(min.poll());
        }
    }
    
    public double findMedian() {
        return min.size() == max.size() ? (max.peek() + min.peek()) / 2.0 : max.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */