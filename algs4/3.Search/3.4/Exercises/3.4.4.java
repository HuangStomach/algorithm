import edu.princeton.cs.algs4.*;

class SeparateChainingHashST<Key, Value> {
    private int N;
    private int M;
    private int a;
    private SequentialSearchST<Key, Value>[] st;

    public SeparateChainingHashST(int M, int a) {
        this.M = M;
        this.a = a;
        st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[M];
        for (int i = 0; i < M; i++) {
            st[i] = new SequentialSearchST();
        }
    }

    private int hash(Key key) {
        int index = key.toString().toUpperCase().charAt(0) - 64;
        return (a * index) % M;
    }


    public Value get(Key key) {
        return (Value) st[hash(key)].get(key);
    }

    public void put(Key key, Value val) {
        st[hash(key)].put(key, val);
        N = 0;
        for (int i = 0; i < M; i++) {
            if (st[i] != null) N += st[i].size();
        }
    }

    public boolean prefect() {
        int O = 0;
        for (int i = 0; i < M; i++) {
            if (st[i] != null && st[i].size() > 0) O++;
        }
        return O == N;
    }

    public static void main(String[] args) {
        String test = "S E A R C H X M P L";
        String[] keys = test.split("\\s+");
        int n = keys.length;

        for (int m = 11; m <= 100; m++) {
            for (int i = 1; i <= 100; i++) {
                SeparateChainingHashST<String, Boolean> st = new SeparateChainingHashST(m, i);
                for (int j = 1; j <= n; j++) {
                    st.put(keys[j - 1], true);
                }
                if (st.prefect()) {
                    System.out.println("a: " + i + " M: " + m);
                    return;
                }
            }
        }
    }
}