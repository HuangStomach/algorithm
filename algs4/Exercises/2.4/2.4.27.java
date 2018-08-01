class MaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;
    private Key[] min;
    private int N = 0;

    public MaxPQ(int max) {
        pq = (Key[]) new Comparable[max + 1];
        min = (Key[]) new Comparable[max + 1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void insert(Key v) {
        Key m;
        if (N == 0) m = v;
        else if (v.compareTo(min[N]) < 0) m = v;
        else m = min[N];

        pq[++N] = v;
        swim(N);
        min[N] = m;
    }

    public Key delMax() {
        Key max = pq[1];
        exch(1, N--);
        pq[N + 1] = null;
        min[N + 1] = null;
        sink(1);
        return max;
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (k * 2 <= N) {
            int j = k * 2;
            if (j < N && less(j, j + 1)) j++;
            if (!less(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    public static void main(String[] args) {
        MaxPQ pq = new MaxPQ(12);
        String[] array = {"E", "A", "S", "Y", "Q", "U", "E", "S", "T", "I", "O", "N"};
        for (int i = 0; i < array.length; i++) {
            pq.insert(array[i]);
        }

        for (int i = 0; i < array.length; i++) {
            System.out.print(pq.delMax());
        }
        System.out.println();
    }
}