import edu.princeton.cs.algs4.*;

class Analysis {
    public static void main(String[] args) {
        BinarySearchST st = new BinarySearchST<Integer, Boolean>();
        for (int i = 0; i < 128; i++) {
            st.put(i, true);
        }
        st.count = 0;
        st.get(127);
        System.out.println(Integer.toBinaryString(128));
        System.out.println(st.count);
        // 每次二分查找相当于取一半也就是除以二 相当于右移一位 移动8位为最大次查找 等同于查询比较次数
    }
}

class BinarySearchST<Key extends Comparable<Key>, Value> {
    private Key[] keys;
    private Value[] vals;
    public int count = 0;
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

    public Key floor(Key key) {
        if (isEmpty()) return null;
        int i = rank(key);
        if (i == 0) return null;
        return keys[--i];
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
            count++;
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