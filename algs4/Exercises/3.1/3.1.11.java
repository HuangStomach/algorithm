import edu.princeton.cs.algs4.*;

class Chart {
    public static void main(String[] args) {

        String[] array = {"E", "A", "S", "Y", "Q", "U", "E", "S", "T", "I", "O", "N"};
        StdDraw.setXscale(0, array.length);
        StdDraw.setYscale(0, array.length);
        StdDraw.setPenRadius(.01);
        StdDraw.setPenColor(StdDraw.RED);
        BinarySearchST st = new BinarySearchST<String, Integer>();

        for (int i = 0; i < array.length; i++) {
            st.put(array[i], 1);
            System.out.println(st.compare);
            StdDraw.point(i, st.compare);
            st.compare = 0;
        }
    }
}

class BinarySearchST<Key extends Comparable<Key>, Value> {
    public int compare = 0;
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

    // public Key floor(Key key)

    // public Key delete(Key key)

    public int rank(Key key) {
        int low = 0;
        int high = N - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cmp = key.compareTo(keys[mid]);
            compare++;
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
        Value[] vals = (Value[]) new Object[length];

        for (int i = 0; i < N; i ++) {
            keys[i] = this.keys[i];
            vals[i] = this.vals[i];
        }

        this.keys = keys;
        this.vals = vals;
    }
}