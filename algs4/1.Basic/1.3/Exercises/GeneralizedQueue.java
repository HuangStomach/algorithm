// 1.3.38

public class GeneralizedQueue<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int N;
    private class Node {
        Item item;
        Node next; 
    }

    public boolean isEmpty() {
        return last == null;
    }

    public void insert(item x) {
        Node old = last;
        last.item = x;
        if (isEmpty()) first = last;
        else old.next = last;
        N++;
    }

    public Item delete(int k) {
        if (k > N) return new Item();
        if (N == 1) {
            Item item = first.item;
            first = last = null;
            return item;
        }

        int index = 1;
        Node current = first;
        while (true) {
            if (index + 1 == k) {
                Item item = current.next.item;
                current.next = current.next.next;
            }
            current = current.next;
            index++;
        }
    }
}