class MaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;
    private int N = 0;

    public MaxPQ() {
        pq = (Key[]) new Comparable[3];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void insert(Key v) {
        if (N >= pq.length / 3) {
            Key[] temp = (Key[]) new Comparable[pq.length * 2];
            for (int i = 0; i <= N; i++) {
                temp[i] = pq[i];
            }
            pq = temp;
        }
        pq[++N] = v;
        swim(N);
    }

    public Key delMax() {
        if (N > 3 && N <= pq.length / 3) {
            Key[] temp = (Key[]) new Comparable[pq.length / 2];
            for (int i = 0; i <= N; i++) {
                temp[i] = pq[i];
            }
            pq = temp;
        }
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
        MaxPQ<String> pq = new MaxPQ<String>();
        pq.insert("P");
        pq.insert("R");
        pq.insert("I");
        pq.insert("O");
        System.out.print(pq.delMax()); // R
        pq.insert("R");
        System.out.print(pq.delMax()); // R
        System.out.print(pq.delMax()); // P
        pq.insert("I");
        System.out.print(pq.delMax()); // O
        pq.insert("T");
        System.out.print(pq.delMax()); // T
        pq.insert("Y");
        System.out.print(pq.delMax()); // Y
        System.out.print(pq.delMax()); // I
        System.out.print(pq.delMax()); // I
        pq.insert("Q");
        pq.insert("U");
        pq.insert("E");
        System.out.print(pq.delMax()); // U
        System.out.print(pq.delMax()); // Q
        System.out.print(pq.delMax()); // E
        pq.insert("U");
        System.out.print(pq.delMax()); // U
        pq.insert("E");
        System.out.println(); // U
    }
}