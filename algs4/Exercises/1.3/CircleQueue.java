import java.util.Iterator;

// 1.3.29

public class CircleQueue<Integer> implements Iterable<Integer> {
    private Node first;
    private Node last;
    private int N = 0;
    private class Node {
        Integer num;
        Node next;
    }
    
    private void resize(int size) {
        Integer[] temp = new Integer[size];
        for (int i = 1; i < a.length; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public void enqueue(Integer num) {
        Node old = last;
        last = new Node();
        last.num = num;
        last.next = null;
        if (isEmpty()) first = last;
        else old.next = last;
        N++;
    }

    public Integer dequeue() {
        if (isEmpty()) return Integer.empty();
        Integer num = first.num;
        first = first.next();
        if (isEmpty()) last = null;
        N--;
        return num;
    }

    public Iterator<Integer> iterator() {
        return new CircleQueueIterator();
    }

    private class CircleQueueIterator implements Iterator<Integer> {
        private Node current = null;
        public boolean hasNext() { return i > 0; }
        public Integer next() { 
            if (current == null) {
                current = first;
                return current;
            }
            current = current.next;
            return current;
        }
        public void remove() {}
    }
}