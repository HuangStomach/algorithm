import edu.princeton.cs.algs4.*;

public class BinarySearchST<Key extends Comparable<Key>, Value> {
    private Item[] items;
    private int N;

    private class Item implements Comparable<Item> {
        public Key key;
        public Value val;
        Item(Key key, Value val) {
            this.key = key;
            this.val = val;
        }

        public void val(Value val) {
            this.val = val;
        }

        public int compareTo(Item that) {
            return this.key.compareTo(that.key);
        }
    }

    public BinarySearchST() {
        this(5);
    }

    public BinarySearchST(int capacity) {
        items = new Item[capacity];
    }

    public BinarySearchST(Item[] items) {
        this.items = items;
        N = item.length;
        sort(this.items, 0, N - 1);
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
        if (i < N && items[i].key.compareTo(key) == 0) return items[i].val;
        else return null;
    }

    public void put(Key key, Value val) {
        int i = rank(key);
        if (i < N && items[i].key.compareTo(key) == 0) {
            items[i].val(val);
            return;
        }

        for (int j = N; j > i; j--) {
            items[j] = items[j - 1];
        }
        items[i] = new Item(key, val);
        N++;
        resize();
    }

    public Key min() {
        return items[0].key;
    }

    public Key max() {
        return items[N - 1].key;
    }

    public Key select(int k) {
        return items[k].key;
    }

    public Key ceiling(Key key) {
        int i = rank(key);
        return items[i].key;
    }

    // public Key floor(Key key)

    // public Key delete(Key key)

    public int rank(Key key) {
        int low = 0;
        int high = N - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cmp = key.compareTo(items[mid].key);
            if (cmp < 0) high = mid - 1;
            else if (cmp > 0) low = mid + 1;
            else return mid;
        }
        return low;
    }

    public Iterable<Key> keys(Key low, Key high) {
        Queue<Key> q = new Queue<Key>();
        for (int i = rank(low); i < rank(high); i++) {
            q.enqueue(items[i].key);
            if (ceiling(high) != null) {
                q.enqueue(items[rank(high)].key);
            }
        }
        return q;
    }

    private void resize() {
        if (N <= items.length / 2) return;
        int length = items.length * 2;
        Item[] items = new Item[length];

        for (int i = 0; i < N; i ++) {
            items[i] = this.items[i];
        }

        this.items = items;
    }

    private static void sort(Comparable[] a, int low, int high) {
        if (high <= low ) return;
        int mid = low + (high - low) / 2;
        sort(a, low, mid);
        sort(a, mid + 1, high);
        merge(a, low, mid, high);
    }

    public static void merge(Comparable[] a, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;

        for (int k = low; k <= high; k++) {
            aux[k] = a[k];
        }

        for (int k = low; k <= high; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > high) a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }
}