import java.util.ArrayList;

public class OrderedSequentialSearchST<Key extends Comparable<Key>, Value> {
    private int N;
    private Node first;
    private class Node {
        Key key;
        Value val;
        Node next;

        public Node(Key key, Value val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public Value get(Key key) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) return x.val;
        }
        return null;
    }

    public void put(Key key, Value val) {
        for (Node x = first; x != null; x = x.next) {
            if (key.compareTo(x.key) > 0) {
                node = new Node(key, val, x.next);
                x.next = node;
                return;
            }
        }
        first = new Node(key, val, first);
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

    public Key min() {
        return first.key;
    }

    public Key max() {
        for (Node x = first; x != null; x = x.next) {
            if (x.next = null) return x.key;
        }
        return null;
    }

    public Key select(int k) {
        return keys[k];
    }

    public Iterable<Key> keys() {
        List<Key> list = new ArrayList<Key>();
        for (Node x = first; x != null; x = x.next) {
            list.add(x.key);
        }
        return list;
    }
}