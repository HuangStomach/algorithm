import java.util.Queue;

public class ArrayST<Key, Value> {
    private Key[] keys;
    private Value[] vals;
    private int N;

    public ArrayST() {
        ArrayST(5);
    }

    public ArrayST(int capacity) {
        keys = (Key[]) new Object[capacity];
        vals = (Value[]) new Object[capacity];
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public Value get(Key key) {
        if (isEmpty()) return null;
        int i = rank(key);
        if (i > 0 && keys[i].compareTo(key) == 0) return vals[i];
        else return null;
    }

    public void put(Key key, Value val) {
        int i = rank(key);
        if (i > 0 && keys[i].compareTo(key) == 0) {
            vals[i] = val;
            return;
        }
        
        keys[N] = key;
        vals[N] = val;
        N++;
        resize();
    }
    public Key delete(Key key) {
        if (isEmpty()) return null;
        int i = rank(key);
        if (i > 0 && keys[i].compareTo(key) == 0) {
            for (int j = i; j < N - 1; j++) {
                keys[j] = keys[j + 1];
                vals[j] = vals[j + 1];
            }
            N--;
            resize();
        }
        return null;
    }

    public int rank(Key key) {
        for (int i = 0; i < N; i++) {
            if (keys[i].equals(key)) return i;
        }
        return -1;
    }

    private void resize() {
        if (N <= keys.length / 2) return;
        int length = keys.length * 2;
        Key[] keys = (Key[]) new Comparable[length];
        Value[] vals = (Value[]) new Object[length];

        for (int i = 0; i < N; i ++) {
            keys[i] = this.keys[i];
            vals[i] = this.vals[i];
        }

        this.keys = keys;
        this.vals = vals;
    }
}