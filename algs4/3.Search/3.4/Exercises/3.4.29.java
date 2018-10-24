import edu.princeton.cs.algs4.*;

class LinearProbingHashST<Key, Value> {
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

    private int hashA(Key key) {
        int index = key.toString().toUpperCase().charAt(0);
        return (11 * index) % M;
    }

    private int hashB(Key key) {
        int index = key.toString().toUpperCase().charAt(0);
        return (17 * index) % M;
    }

    public void put(Key key, Value val) {
        // if (N >= M / 2) resize(2 * M);

        int i, j;
        for (i = hashA(key), j = hashB(key); keys[i] != null && keys[j] != null; i = (i + 3) % M, j = (j + 3) % M) {
            if (keys[i].equals(key)) {
                vals[i] = val;
                return;
            }
            if (keys[j].equals(key)) {
                vals[j] = val;
                return;
            }
        }
        int k;
        if (keys[i] == null) k = i;
        else k = j;

        keys[k] = key;
        vals[k] = val;
        N++;
    }
    
    public Value get(Key key) {
        int i, j;
        for (i = hashA(key), j = hashB(key); keys[i] != null && keys[j] != null; i = (i + 3) % M, j = (j + 3) % M) {
            if (keys[i].equals(key)) return vals[i];
            if (keys[j].equals(key)) return vals[j];
        }
        return null;
    }

    public void delete(Key key) {
        if (!contains(key)) return;

        int i, j;
        int k = 0;
        for (i = hashA(key), j = hashB(key); keys[i] != null && keys[j] != null; i = (i + 3) % M, j = (j + 3) % M) {
            if (keys[i].equals(key)) {
                k = i;
                return;
            }
            if (keys[j].equals(key)) {
                k = j;
                return;
            }
        }

        keys[k] = null;
        vals[k] = null;
        k = (k + 3) % M;

        while (keys[k] != null) {
            Key keytoRedo = keys[k];
            Value valToRedo = vals[k];
            keys[k] = null;
            vals[k] = null;
            N--;
            put(keytoRedo, valToRedo);
            k = (k + 3) % M;
        }
        N--;
        // if (N > 0 && N == M / 8) resize(M / 2);
    }

    public boolean contains(Key key) {
        if (key == null) return false;
        return get(key) != null;
    }

    public void print() {
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] == null) System.out.print(". ");
            else System.out.print(keys[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String test = "E A S Y Q U T I O N";
        String[] keys = test.split("\\s+");
        int n = keys.length;
        
        LinearProbingHashST<String, Boolean> st = new LinearProbingHashST(11);
        for (int i = 0; i < n; i++) {
            st.put(keys[i], true);
            st.print();
            System.out.println("----");
        }
    }
}

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

    private int hashA(Key key) {
        int index = key.toString().toUpperCase().charAt(0);
        return (11 * index) % M;
    }

    private int hashB(Key key) {
        int index = key.toString().toUpperCase().charAt(0);
        return (17 * index) % M;
    }

    public void put(Key key, Value val) {
        // if (N * 2 >= M) resize(2 * M);
        var stA = st[hashA(key)];
        var stB = st[hashB(key)];
        
        if (stA.size() >= stB.size()) stB.put(key, val);
        else stA.put(key, val);
        
        N = 0;
        for (int i = 0; i < M; i++) {
            if (st[i] != null) N += st[i].size();
        }
    }

    public void delete(Key key) {
        int i = hashB(key);
        int j = hashB(key);
        if (st[i].contains(key)) {
            N--;
            st[i].delete(key);
        }
        if (st[j].contains(key)) {
            N--;
            st[j].delete(key);
        }
        
        // if (N > 0 && N <= 2 * M) resize(M / 2);
    }
    
    public boolean contains(Key key) {
        if (key == null) return false;
        return get(key) != null;
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
        
        SeparateChainingHashST<String, Boolean> st = new SeparateChainingHashST(3);
        for (int i = 0; i < n; i++) {
            st.put(keys[i], true);
            st.print();
            System.out.println("----");
        }
    }
}