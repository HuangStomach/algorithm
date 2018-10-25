import edu.princeton.cs.algs4.*;
// 内存使用和交换操作比较多
class SeparateChainingHashST<Key extends Comparable<Key>, Value> {
    private int N;
    private int M;
    private RedBlackBST<Key, Value>[] st;

    public SeparateChainingHashST() {
        this(997);
    }

    public SeparateChainingHashST(int M) {
        this.M = M;
        st = (RedBlackBST<Key, Value>[]) new RedBlackBST[M];
        for (int i = 0; i < M; i++) {
            st[i] = new RedBlackBST();
        }
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    private void resize(int cap) {
        SeparateChainingHashST<Key, Value> t = new SeparateChainingHashST(cap);
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

    public void print() {
        for (int i = 0; i < M; i++) {
            if (st[i] == null || st[i].size() == 0) continue;
            for (Key key: st[i].keys()) {
                System.out.print(key + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        String test = "E A S Y Q U T I O N";
        String[] keys = test.split("\\s+");
        int n = keys.length;
        
        SeparateChainingHashST<String, Boolean> st = new SeparateChainingHashST(4);
        for (int i = 0; i < n; i++) {
            st.put(keys[i], true);
        }

        st.print();
    }
}