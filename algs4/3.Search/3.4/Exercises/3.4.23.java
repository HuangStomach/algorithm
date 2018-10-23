import edu.princeton.cs.algs4.*;

class SeparateChainingHashST<Key, Value> {
    private int N;
    private int M;
    private SequentialSearchST<Key, Value>[] st;

    public SeparateChainingHashST() {
        this(997);
    }

    public SeparateChainingHashST(int M) {
        this.M = M;
        st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[M];
        for (int i = 0; i < M; i++) {
            st[i] = new SequentialSearchST();
        }
    }

    private int hash(Key key) {
        String s = key.toString();
        int hash = 0;
        for (int i = 0; i < s.length(); i++) {
            hash = (256 * hash + s.charAt(i)) % 255;
        }
        return hash;
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
        SeparateChainingHashST<String, Boolean> st = new SeparateChainingHashST();
        String test = "A B C D E F G H I J K L M N O P";
        String[] keys = test.split("\\s+");
        
        for (int i = 0; i < 100; i++) {
            StdRandom.shuffle(keys);
            st.put(String.join("", keys), true);
        }

        st.print();
    }
}