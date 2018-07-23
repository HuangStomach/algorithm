public class MaxPQ<Key extends Comparable<Key>> {
    private Node head;
    private int N = 0;

    public MaxPQ() {
        head = null;
        pq = (Key[]) new Comparable();
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void insert(Key v) {
        if (head == null) {
            head = new Node();
            head.val = v;
        }
        else {
            Node top = head;
            while (top != null) {
                if (top.val.compareTo(v) < 0) {
                    Node node = new Node();
                    node.val = top.val;
                    node.next = top.next;
                    top.val = v;
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

    private class Node {
        Key val;
        Node next;
    }
}