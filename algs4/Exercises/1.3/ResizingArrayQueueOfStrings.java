import java.util.Iterator;

// 1.3.14

public class ResizingArrayQueueOfStrings<String> implements Iterable<String> {
    private Node first;
    private Node last;
    private int N = 0;
    private class Node {
        String str;
        Node next;
    }
    private void resize(int size) {
        String[] temp = new String[size];
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

    public void enqueue(String str) {
        Node old = last;
        last = new Node();
        last.str = str;
        last.next = null;
        if (isEmpty()) first = last;
        else old.next = last;
        N++;
    }

    public String dequeue() {
        if (isEmpty()) return String.empty();
        String str = first.str;
        first = first.next();
        if (isEmpty()) last = null;
        N--;
        return str;
    }

    public Iterator<String> iterator() {
        return new ResizingArrayQueueOfStringsIterator();
    }

    private class ResizingArrayQueueOfStringsIterator implements Iterator<String> {
        private Node current = null;
        public boolean hasNext() { return i > 0; }
        public String next() { 
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