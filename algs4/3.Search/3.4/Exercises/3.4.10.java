import edu.princeton.cs.algs4.*;

class SeparateChainingHashST<Key, Value> {
    private int N;
    private int M;
    private SequentialSearchST<Key, Value>[] st;

    public SeparateChainingHashST(int M) {
        this.M = M;
        st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[M];
        for (int i = 0; i < M; i++) {
            st[i] = new SequentialSearchST();
        }
    }

    private int hash(Key key, int k) {
        return (11 * k) % M;
    }

    public Value get(Key key, int k) {
        return (Value) st[hash(key, k)].get(key);
    }

    public void put(Key key, Value val, int k) {
        st[hash(key, k)].put(key, val);
        N = 0;
        for (int i = 0; i < M; i++) {
            if (st[i] != null) N += st[i].size();
        }
    }

    public static void main(String[] args) {
        String test = "E A S Y Q U T I O N";
        String[] keys = test.split("\\s+");
        int n = keys.length;
        
        SeparateChainingHashST<String, Boolean> sta = new SeparateChainingHashST(16);
        for (int i = 1; i <= n; i++) {
            sta.put(keys[i], true, i);
        }
        
        SeparateChainingHashST<String, Boolean> stb = new SeparateChainingHashST(16);
        for (int i = 1; i <= n; i++) {
            stb.put(keys[i], true, i);
        }
    }
}