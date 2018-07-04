import edu.princeton.cs.algs4.*;
class MergeQueue {
    public static void main(String[] args) {
        Queue<Integer> q1 = new Queue<Integer>();
        Queue<Integer> q2 = new Queue<Integer>();

        Queue<Integer> queue = new Queue<Integer>();

        while(q1.size() > 0 && q2.size() > 0) {
            if (q1.size() == 0) queue.enqueue(q2.dequeue());
            else if (q2.size() == 0) queue.enqueue(q2.dequeue());
            else if (q1.peek().compareTo(q2.peek()) < 0) queue.enqueue(q1.dequeue());
            else queue.enqueue(q2.dequeue());
        }
    }
}