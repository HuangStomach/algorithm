import edu.princeton.cs.algs4.*;
import java.util.Arrays;

class Free {
    public static void main(String[] args) {
        int N = 14;
        Task[] list = new Task[N];
        int k = 0;
        while (!StdIn.isEmpty()) {
            String str = StdIn.readString();
            String[] array = str.split(":");
            Task task = new Task(Integer.parseInt(array[1]), Integer.parseInt(array[2]));
            list[k++] = task;
        }
        Arrays.sort(list);

        int end = list[0].end;
        int[] busy = {list[0].start, end};
        MaxPQ<Integer> busyPQ = new MaxPQ<Integer>();
        busyPQ.insert(0);
        MaxPQ<Integer> freePQ = new MaxPQ<Integer>();
        freePQ.insert(0);
        for (int i = 1; i < N; i++) {
            Task current = list[i];
            Task prev = list[i - 1];
        
            if (current.start <= end) {
                end = Math.max(list[i].end, end);
                if (end <= current.end) busy[1] = current.end;
            }
            else {
                freePQ.insert(current.start - prev.end);
                busyPQ.insert(busy[1] - busy[0]);
                busy[0] = current.start;
                busy[1] = current.end;
            }
        }
        busyPQ.insert(busy[1] - busy[0]);

        System.out.println("最长空闲时间为: " + freePQ.delMax());
        System.out.println("最长繁忙时间为: " + busyPQ.delMax());
    }
}

class Task implements Comparable<Task> {
    public int start;
    public int end;

    Task(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int compareTo(Task that) {
        return this.start - that.start;
    }
}

class MaxPQ<Key extends Comparable<Key>> {
    private Node head;
    private int N = 0;
    private class Node {
        Key val;
        Node next;
        Node(Key val) {
            this.val = val;
        }
    }

    public MaxPQ() {
        head = null;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void insert(Key v) {
        if (head == null) {
            head = new Node(v);
        }
        else {
            Node top = head;
            while (top != null) {
                if (top.val.compareTo(v) < 0) {
                    Node node = new Node(v);
                    node.next = top.next;
                    top.val = v;
                    top.next = node;
                    break;
                }

                if (top.next == null) {
                    Node node = new Node(v);
                    top.next = node;
                    break;
                }

                top = top.next;
            }
        }
        N++;
    }

    public Key delMax() {
        Key val = head.val;
        head = head.next;
        N--;
        return val;
    }
}
