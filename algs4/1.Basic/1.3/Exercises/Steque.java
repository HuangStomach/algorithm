// 1.3.32
public class Steque<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int N;

    private class Node {
        Item item;
        Node next;
    }

    public int size() {
        return N;
    }

    public Boolean isEmpty() {
        return last == null;
    }

    public void push(Item item) {
        Node n = new Node();
        n.item = item;
        n.next = first;
        first = n;
        if (isEmpty()) first = last;
        N++;
    }

    public Item pop() {
        if (isEmpty()) return new Item();
        Node old = first;
        first = first.next;
        N--;
        return old.item;
    }

    public void enqueue(Item item) {
        Node old = last;
        last = new Node();
        last.item = item;
        last.next = null;

        if (isEmpty()) first = last;
        else old.next = last;
        N++;
    }
}