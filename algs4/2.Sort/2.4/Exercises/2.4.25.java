import java.util.HashSet;

class MaxPQ {
    private int[][] pq;
    private int N = 0;

    public MaxPQ(int N) {
        pq = new int[N * 2 + 1][3];
        for (int i = 0; i <= N; i++) {
            int[] array = {(int)Math.pow(i, 3), i, 0};
            pq[i + 1] = array;
            this.N++;
        }
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void insert(int a, int b) {
        int[] array = {(int)Math.pow(a, 3) + (int)Math.pow(b, 3), a, b};
        pq[++N] = array;
        swim(N);
    }

    public int[] delMin() {
        int[] max = pq[1];
        for (int i = 2; i < N; i++) {
            if (pq[i][0] != max[0]) break;
            int a = pq[i][1], b = pq[i][2], c = max[1], d = max[2];
            HashSet<Integer> s = new HashSet<Integer>();
            s.add(a);
            s.add(b);
            s.add(c);
            s.add(d);
            if (s.size() == 4) {
                System.out.println("a: " + a + " b: " + b + " c: " + c + " d: " + d);
            }
        }
        exch(1, N--);
        pq[N + 1] = null;
        sink(1);
        return max;
    }

    private boolean more(int i, int j) {
        if (pq[i] == null) return true;
        return pq[i][0] > pq[j][0];
    }

    private void exch(int i, int j) {
        int[] t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    private void swim(int k) {
        while (k > 1 && more(k / 2, k)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (k * 2 <= N) {
            int j = k * 2;
            if (j < N && more(j, j + 1)) j++;
            if (!more(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    public static void main(String[] args) {
        int N = 100;
        MaxPQ pq = new MaxPQ(N);
        while (!pq.isEmpty()) {
            int[] array = pq.delMin();
            int i = array[1];
            int j = array[2];
            if (j < N) {
                pq.insert(i, j + 1);
            }
        }
    }
}
