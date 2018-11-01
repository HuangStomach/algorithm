import edu.princeton.cs.algs4.*;

public class BinarySearchSET<Key extends Comparable<Key>> {
    private Key[] keys;
    private int N;

    public BinarySearchSET() {
        this(5);
    }

    public BinarySearchSET(int capacity) {
        keys = (Key[]) new Comparable[capacity];
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public boolean get(Key key) {
        if (isEmpty()) return null;
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) return true;
        else return null;
    }

    public void put(Key key) {
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) return;

        for (int j = N; j > i; j--) {
            keys[j] = keys[j - 1];
        }
        keys[i] = key;
        N++;
        resize();
    }

    public Key min() {
        return keys[0];
    }

    public Key max() {
        return keys[N - 1];
    }

    public Key select(int k) {
        return keys[k];
    }

    public Key ceiling(Key key) {
        int i = rank(key);
        return keys[i];
    }

    // public Key floor(Key key)

    // public Key delete(Key key)

    public int rank(Key key) {
        int low = 0;
        int high = N - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0) high = mid - 1;
            else if (cmp > 0) low = mid + 1;
            else return mid;
        }
        return low;
    }

    public Iterable<Key> keys(Key low, Key high) {
        Queue<Key> q = new Queue<Key>();
        for (int i = rank(low); i < rank(high); i++) {
            q.enqueue(keys[i]);
            if (ceiling(high) != null) {
                q.enqueue(keys[rank(high)]);
            }
        }
        return q;
    }

    private void resize() {
        if (N <= keys.length / 2) return;
        int length = keys.length * 2;
        Key[] keys = (Key[]) new Comparable[length];

        for (int i = 0; i < N; i ++) {
            keys[i] = this.keys[i];
        }

        this.keys = keys;
    }
}