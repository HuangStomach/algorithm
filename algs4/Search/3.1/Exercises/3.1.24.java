import edu.princeton.cs.algs4.*;

class SearchCompare<Double, Value> {
    private double[] keys;
    private Value[] vals;
    private int N;

    public SearchCompare() {
        this(5);
    }

    public SearchCompare(int capacity) {
        keys = (Double[]) new double[capacity];
        vals = (Value[]) new Object[capacity];
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public Value get(double key) {
        if (isEmpty()) return null;
        int i = rank(key);
        if (i < N && keys[i] - key == 0) return vals[i];
        else return null;
    }

    public void put(double key, Value val) {
        int i = rank(key);
        if (i < N && keys[i] - key == 0) {
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

    public double min() {
        return keys[0];
    }

    public double max() {
        return keys[N - 1];
    }

    public double select(int k) {
        return keys[k];
    }

    public double ceiling(double key) {
        int i = rank(key);
        return keys[i];
    }

    public double floor(double key) {
        if (isEmpty()) return null;
        int i = rank(key);
        if (i == 0) return null;
        return keys[--i];
    }

    public double delete(double key) {
        double result = key;
        if (isEmpty()) result = null;
        int i = rank(key);
        if (i < N && keys[i] - key == 0) {
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

    public int rank(double key) {
        int low = 0;
        int high = N - 1;
        while (low <= high) {
            int mid = Math.floor(key - keys[low] / keys[high] - keys[low]);
            int cmp = key - keys[mid];
            if (cmp < 0) high = mid - 1;
            else if (cmp > 0) low = mid + 1;
            else return mid;
        }
        return low;
    }

    public Iterable<Double> keys(double low, double high) {
        Queue<Double> q = new Queue<Double>();
        for (int i = rank(low); i < rank(high); i++) {
            q.enqueue(keys[i]);
            if (ceiling(high) > 0) {
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