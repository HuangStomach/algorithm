import java.util.Iterator;

// 1.3.29

public class CircleQueue<Item> implements Iterable<Item> {
    private Node last;
    private int N = 0;
    private class Node {
        Item item;
        Node next;
    }
    
    public boolean isEmpty() {
        return last == null;
    }

    public int size() {
        return N;
    }

    public void enqueue(Item item) {
        Node old = last;
        last = new Node();
        last.item = item;
        if (old == null) {
            last.next = last;
        }
        else {
            last.next = old.next;
            old.next = last;
        }
        N++;
    }

    public Item dequeue() {
        Node first = last.next;
        if (last.next == last) {
            last = null;
        }
        else {
            last.next = last.next.next;
        }
        N--;
        return first.item;
    }

    public Iterator<Item> iterator() {
        return new CircleQueueIterator();
    }
}