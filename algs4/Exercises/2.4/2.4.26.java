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

    private boolean less(Key i, Key j) {
        return i.compareTo(j) < 0;
    }

    private void exch(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    private void swim(int k) {
        Key val = pq[k];
        while (k > 1 && less(pq[k / 2], val)) {
            pq[k] = pq[k / 2];
            k = k / 2;
        }
        pq[k] = val;
    }

    private void sink(int k) {
        Key val = pq[k];
        while (k * 2 <= N) {
            int j = k * 2;
            if (j < N && less(pq[j], pq[j + 1])) j++;
            if (!less(val, pq[j])) break;
            pq[k] = pq[j];
            k = j;
        }
        pq[k] = val;
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