import edu.princeton.cs.algs4.*;

class LRU<Key extends Comparable<Key>> {
    Node first;
    Node last;
    int N;
    ST<Key, Integer> st;

    private class Node {
        Key key;
        Node prev;
        Node next;

        Node (Key key, Node prev, Node next) {
            this.key = key;
            this.prev = prev;
            this.next = next;
        }
    }

    LRU() {
        st = new ST<Key, Integer>();
    }

    public Key get(Key key) {
        if (st.contains(key)) delete(key);
        st.put(key, 0);
        Node node = new Node(key, null, first);
        if (first != null) first.prev = node;

        first = node;
        if (last == null) last = node;
        N++;

        Node tmp = node.next;
        for (int i = 1; tmp != null; i++, tmp = tmp.next) {
            st.put(tmp.key, i);
        }
        return key;
    }

    private Key delete(Key key) {
        if (!st.contains(key)) return key;

        Node tmp = first;
        while (tmp.key != key) {
            st.put(tmp.key, st.get(tmp.key) + 1);
            tmp = tmp.next;
        }

        if (tmp.next == null) delete();
        else {
            tmp.prev.next = tmp.next;
            tmp.next.prev = tmp.prev;
        }
        N--;
        return key;
    }

    public Key delete() {
        Key key = last.key;
        Node prev = last.prev;
        if (prev != null) prev.next = null;
        last = prev;
        st.delete(key);
        N--;
        return key;
    }

    public void show() {
        Node tmp = first;
        while (tmp != null) {
            System.out.print(tmp.key + " ");
            tmp = tmp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LRU<String> lru = new LRU<String>();
        lru.get("A");
        lru.get("B");
        lru.get("C");
        lru.get("D");
        lru.show();
        lru.get("C");
        lru.show();
        lru.get("A");
        lru.show();
        lru.get("B");
        lru.show();
        System.out.println(lru.delete());
    }
}