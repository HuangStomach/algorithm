import edu.princeton.cs.algs4.*;
import java.util.ArrayList;

class Chart {
    public static void main(String[] args) {

        String[] array = {"E", "A", "S", "Y", "Q", "U", "E", "S", "T", "I", "O", "N"};
        StdDraw.setXscale(0, array.length);
        StdDraw.setYscale(0, array.length);
        StdDraw.setPenRadius(.01);
        StdDraw.setPenColor(StdDraw.RED);
        SequentialSearchST st = new SequentialSearchST<String, Integer>();
        for (int i = 0; i < array.length; i++) {
            int j = st.put(array[i], 1);
            StdDraw.point(i, j);
        }
    }
}

class SequentialSearchST<Key, Value> {
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

    public Value get(Key key) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) return x.val;
        }
        return null;
    }

    public int put(Key key, Value val) {
        int i = 0;
        for (Node x = first; x != null; x = x.next) {
            i++;
            if (key.equals(x.key)) {
                x.val = val;
                return i;
            }
        }
        first = new Node(key, val, first);
        N++;
        return i;
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
        ArrayList<Key> list = new ArrayList<Key>();
        for (Node x = first; x != null; x = x.next) {
            list.add(x.key);
        }
        return list;
    }
}
