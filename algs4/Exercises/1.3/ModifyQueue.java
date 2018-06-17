import edu.princeton.cs.algs4.*;

// 1.3.19
// 1.3.20
public class TestQueue {
    public static void delete(Queue<Integer> q, int k) {
        int index = 1;
        
        if (k == 1) {
            q.dequeue();
            return;
        }
        q.forEach(node -> {
            if (index == k - 1) {
                node.next = node.next.next;
            }
            index++;
        });
    }

    public static void main(String[] args) {
        Queue<Integer> q = new Queue<Integer>();
        for (int i = 0; i < 100; i++) {
            q.enqueue(i);
        }
    }
}
