import edu.princeton.cs.algs4.*;

class Test {
    public static void main(String[] args) { 
        String test = "A B C D E F G H I J K L M N";
        String[] keys = test.split("\\s+");
        int n = keys.length;

        BinarySearchST<String, Integer> st = new BinarySearchST<String, Integer>();
        for (int i = 0; i < n; i++) {
            st.put(keys[i], i);
        }
        for (String s : st.keys()) 
            StdOut.println(s + " " + st.get(s)); 
        StdOut.println();

        while (!st.isEmpty()) {
            st.delete(st.min());
        }

        for (int i = n - 1; i >= 0; i--) {
            st.put(keys[i], i);
        }
        for (String s : st.keys()) 
            StdOut.println(s + " " + st.get(s)); 
        StdOut.println();

        while (!st.isEmpty()) {
            st.delete(st.min());
        }

        for (int i = 0; i < n; i++) {
            st.put("A", i);
        }
        for (String s : st.keys()) 
            StdOut.println(s + " " + st.get(s)); 
        StdOut.println();

        while (!st.isEmpty()) {
            st.delete(st.min());
        }
    }
}


class BinarySearchST<Key extends Comparable<Key>, Value> {
    private Key[] keys;
    private Value[] vals;
    private int N;

    public BinarySearchST() {
        this(5);
    }

    public BinarySearchST(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        vals = (Value[]) new Object[capacity];
    }

    public int size() {
        return N;
    }

    public int size(Key low, Key high) {
        int min = rank(low);
        if (keys[min] != low) return 0;
        int max = rank(high);
        if (keys[max] != high) return 0;
        return max - min;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public Value get(Key key) {
        if (isEmpty()) return null;
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) return vals[i];
        else return null;
    }

    public void put(Key key, Value val) {
        if (N > 0 && keys[N - 1].compareTo(key) < 0) {
            keys[N] = key;
            vals[N] = val;
            N++;
            resize();
            return;
        }

        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) {
            vals[i] = val;
            return;
        }

        for (int j = N; j > i; j--) {
            keys[j] = keys[j - 1];
            vals[j] = vals[j - 1];
        }
        keys[i] = key;
        vals[i] = val;
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

    public Key floor(Key key) {
        if (isEmpty()) return null;
        int i = rank(key);
        if (i == 0) return null;
        return keys[--i];
    }

    public Key deleteMin() {
        return delete(min());
    }

    public Key deleteMax() {
        return delete(max());
    }

    public Key delete(Key key) {
        Key result = key;
        if (isEmpty()) result = null;
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) {
            for (int j = i; j < N; j++) {
                keys[j] = keys[j + 1];
                vals[j] = vals[j + 1];
            }
            N--;
        }
        else result = null;
        resize();
        return result;
    }

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

    public Iterable<Key> keys() {
        Queue<Key> q = new Queue<Key>();
        for (int i = 0; i < N; i++) {
            q.enqueue(keys[i]);
        }
        return q;
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
        Value[] vals = (Value[]) new Object[length];

        for (int i = 0; i < N; i ++) {
            keys[i] = this.keys[i];
            vals[i] = this.vals[i];
        }

        this.keys = keys;
        this.vals = vals;
    }
}