import java.util.Random;

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

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public Value get(Key key) {
        return (Value) st[hash(key)].get(key);
    }

    public void put(Key key, Value val) {
        // if (N >= 8 * M) resize(2 * M);
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
        
        // if (N > 0 && N <= 2 * M) resize(M / 2);
    }
    
    public boolean contains(Key key) {
        if (key == null) return false;
        return get(key) != null;
    }

    public int maxLen() {
        int max = 0;
        for (int i = 0; i < M; i++) {
            if (st[i].size() > max) max = st[i].size();
        }
        return max;
    }

    public int minLen() {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < M; i++) {
            if (st[i].size() < min) min = st[i].size();
        }
        return min;
    }

    public static void main(String[] args) {
        Random random = new Random();
        for (int n = 1000; n <= 1000000; n *= 10) {
            SeparateChainingHashST<Integer, Boolean> st = new SeparateChainingHashST(n / 100);
            for (int i = 0; i < n; i++) {
                st.put(random.nextInt(), true);
            }
            System.out.println("长度为" + n + "链表最长为" + st.maxLen() + " 最短为" + st.minLen());
        }
    }
}