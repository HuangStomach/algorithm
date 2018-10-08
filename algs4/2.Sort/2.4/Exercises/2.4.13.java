class MaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;
    private int N = 0;

    public MaxPQ(int max) {
        pq = (Key[]) new Comparable[max + 1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void insert(Key v) {
        pq[++N] = v;
        swim(N);
    }

    public Key delMax() {
        Key max = pq[1];
        exch(1, N--);
        pq[N + 1] = null;
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

    // TODO: 搞不明白
    private void sink(int k) {
        while (k * 2 + 1 <= N) {
            int j = k * 2 + 1;
            if (less(j - 1, j)) j--;
            if (!less(k, j)) break;
            exch(k, j);
            k = j;
        }
        
        if (k == N && k > 1 && less(k, k - 1)) {
            exch(k, k - 1);
        }
    }

    public static void main(String[] args) {
        MaxPQ pq = new MaxPQ(12);
        String[] array = {"E", "A", "S", "Y"};
        for (int i = 0; i < array.length; i++) {
            pq.insert(array[i]);
        }

        for (int i = 0; i < array.length; i++) {
            System.out.print(pq.delMax());
        }
        System.out.println();
    }
}