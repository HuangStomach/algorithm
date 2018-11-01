import edu.princeton.cs.algs4.*;

class SeparateChainingMultiSET<Key> {
    private int N;
    private int M;
    private SequentialSearchST<Key, Boolean>[] st;

    public SeparateChainingMultiSET() {
        this(997);
    }

    public SeparateChainingMultiSET(int M) {
        this.M = M;
        st = (SequentialSearchST<Key>[]) new SequentialSearchST[M];
        for (int i = 0; i < M; i++) {
            st[i] = new SequentialSearchST();
        }
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    private void resize(int cap) {
        SeparateChainingMultiSET<Key> t = new SeparateChainingMultiSET(cap);
        for (int i = 0; i < M; i++) {
            if (st[i] == null || st[i].size() == 0) continue;
            for (Key key : st[i].keys()) t.put(key);
        }
        this.st = t.st;
        this.M = t.M;
    }

    public void put(Key key) {
        if (N >= 8 * M) resize(2 * M);
        st[hash(key)].put(key, true);
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
        return st[hash(key)].get(key) != null;
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
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
