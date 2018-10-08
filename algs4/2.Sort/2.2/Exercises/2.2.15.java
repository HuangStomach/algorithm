import edu.princeton.cs.algs4.*;

class MergeQueueBU {
    public static void main(String[] args) {
        // N个元素的单元素队列组成的队列
        Queue<Queue<Integer>> queue = new Queue<Queue<Integer>>();
        
        while (queue.size() == 1) {
            Queue<Integer> q1 = queue.dequeue();
            Queue<Integer> q2 = queue.dequeue();
            queue.enqueue(merge(q1, q2));
        }
    }

    public static Queue<Integer> merge(Queue<Integer> q1, Queue<Integer> q2) {
        Queue<Integer> queue = new Queue<Integer>();

        while(q1.size() > 0 && q2.size() > 0) {
            if (q1.size() == 0) queue.enqueue(q2.dequeue());
            else if (q2.size() == 0) queue.enqueue(q2.dequeue());
            else if (q1.peek().compareTo(q2.peek()) < 0) queue.enqueue(q1.dequeue());
            else queue.enqueue(q2.dequeue());
        }
        return queue;
    }
}