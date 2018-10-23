import edu.princeton.cs.algs4.*;

public class LinearProbingHashST<Key, Value> {
    private int N;
    private int M;
    private Key[] keys;
    private Value[] vals;

    public LinearProbingHashST() {
        this(16);
    }

    public LinearProbingHashST(int M) {
        this.M = M;
        keys = (Key[]) new Object[this.M];
        vals = (Value[]) new Object[this.M];
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    private void resize(int cap) {
        LinearProbingHashST<Key, Value> t = new LinearProbingHashST(cap);
        for (int i = 0; i < M; i++) {
            if (keys[i] != null) t.put(keys[i], vals[i]);
        }
        this.keys = t.keys;
        this.vals = t.vals;
        this.M = t.M;
    }

    public void put(Key key, Value val) {
        if (N >= M / 2) resize(2 * M);

        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (keys[i].equals(key)) {
                vals[i] = val;
                return;
            }
        }
        keys[i] = key;
        vals[i] = val;
        N++;
    }
    
    public Value get(Key key) {
        for (int i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (keys[i].equals(key)) return vals[i];
        }
        return null;
    }

    public void delete(Key key) {
        if (!contains(key)) return;
        int i = hash(key);

        while (!key.equals(keys[i])) {
            i = (i + 1) % M;
        }

        keys[i] = null;
        vals[i] = null;
        i = (i + 1) % M;

        while (keys[i] != null) {
            Key keytoRedo = keys[i];
            Value valToRedo = vals[i];
            keys[i] = null;
            vals[i] = null;
            N--;
            put(keytoRedo, valToRedo);
            i = (i + 1) % M;
        }
        N--;
        if (N > 0 && N == M / 8) resize(M / 2);
    }

    public boolean contains(Key key) {
        if (key == null) return false;
        return get(key) != null;
    }
    
    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        for (int i = 0; i < M; i++)
            if (keys[i] != null) queue.enqueue(keys[i]);
        return queue;
    }
}