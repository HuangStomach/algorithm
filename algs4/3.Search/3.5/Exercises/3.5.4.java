import edu.princeton.cs.algs4.*;

public class HashSTint {
    private int N;
    private int M;
    private int[] keys;

    public HashSTint() {
        this(16);
    }

    public HashSTint(int M) {
        this.M = M;
        keys = new int[this.M];
    }

    private int hash(int key) {
        return (key & 0x7fffffff) % M;
    }

    private void resize(int cap) {
        HashSTint t = new HashSTint(cap);
        for (int i = 0; i < M; i++) {
            if (keys[i] > 0) t.put(keys[i]);
        }
        this.keys = t.keys;
        this.M = t.M;
    }

    public void put(int key) {
        if (N >= M / 2) resize(2 * M);

        int i;
        for (i = hash(key); keys[i] > 0; i = (i + 1) % M) {
            if (keys[i] == key) return;
        }
        keys[i] = key;
        N++;
    }
    
    public boolean get(int key) {
        for (int i = hash(key); keys[i] > 0; i = (i + 1) % M) {
            if (keys[i] == key) return true;
        }
        return false;
    }

    public void delete(int key) {
        if (!get(key)) return;
        int i = hash(key);

        while (key != keys[i]) {
            i = (i + 1) % M;
        }

        keys[i] = null;
        i = (i + 1) % M;

        while (keys[i] > 0) {
            int keytoRedo = keys[i];
            keys[i] = null;
            N--;
            put(keytoRedo);
            i = (i + 1) % M;
        }
        N--;
        if (N > 0 && N == M / 8) resize(M / 2);
    }
    
    public Iterable<Integer> keys() {
        Queue<Integer> queue = new Integer<Integer>();
        for (int i = 0; i < M; i++)
            if (keys[i] > 0) queue.enqueue(keys[i]);
        return queue;
    }
}