import java.util.ArrayList;

public class SequentialSearchSET<Key> {
    private int N;
    private Node first;
    private class Node {
        Key key;
        Node next;

        public Node(Key key, Node next) {
            this.key = key;
            this.next = next;
        }
    }

    public boolean get(Key key) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) return true;
        }
        return null;
    }

    public void put(Key key) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) return;
        }
        first = new Node(key, first);
        N++;
    }

    public Key delete(Key key) {
        Node prev = null;
        for (Node x = first; x != null; prev = x, x = x.next) {
            if (key.equals(x.key)) {
                prev.next = x.next;
                N--;
                return key;
            }
        }
        return null;
    }

    public int size() {
        return N;
    }

    public Iterable<Key> keys() {
        List<Key> list = new ArrayList<Key>();
        for (Node x = first; x != null; x = x.next) {
            list.add(x.key);
        }
        return list;
    }
}