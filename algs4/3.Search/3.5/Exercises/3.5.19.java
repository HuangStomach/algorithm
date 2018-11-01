import edu.princeton.cs.algs4.*;

class SeparateChainingMultiST<Key, Value> {
    private int N;
    private int M;
    private SequentialSearchST<Key, Value>[] st;

    public SeparateChainingMultiST() {
        this(997);
    }

    public SeparateChainingMultiST(int M) {
        this.M = M;
        st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[M];
        for (int i = 0; i < M; i++) {
            st[i] = new SequentialSearchST();
        }
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    private void resize(int cap) {
        SeparateChainingMultiST<Key, Value> t = new SeparateChainingMultiST(cap);
        for (int i = 0; i < M; i++) {
            if (st[i] == null || st[i].size() == 0) continue;
            for (Key key : st[i].keys()) {
                t.put(key, st[i].get(key));
            }
        }
        this.st = t.st;
        this.M = t.M;
    }

    public Value get(Key key) {
        return (Value) st[hash(key)].get(key);
    }

    public Iterable<Value> getAll(Key key) {
        return st[hash(key)].getAll(key);
    }

    public void put(Key key, Value val) {
        if (N >= 8 * M) resize(2 * M);
        st[hash(key)].put(key, val);
        N = 0;
        for (int i = 0; i < M; i++) {
            if (st[i] != null) N += st[i].size();
        }
    }

    public void delete(Key key) {
        int i = hash(key);
        if (st[i].contains(key)) N--;
        st[i].delete(key);
        
        if (N > 0 && N <= 2 * M) resize(M / 2);
    }
    
    public boolean contains(Key key) {
        if (key == null) return false;
        return get(key) != null;
    }
    
    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        for (int i = 0; i < M; i++) {
            for (Key key : st[i].keys())
                queue.enqueue(key);
        }
        return queue;
    } 
}

public class SequentialSearchST<Key, Value> {
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

    public Iterable<Value> getAll(Key key) {
        Queue<Value> queue = new Queue<Value>();
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) queue.enqueue(x.val);
        }
        return queue;
    }

    public void put(Key key, Value val) {
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

    public int size() {
        return N;
    }

    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        for (Node x = first; x != null; x = x.next) {
            queue.enqueue(x.key);
        }
        return queue;
    }
}