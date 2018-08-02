// 之所以要使用索引就是为了供使用者 获得 或者查找该处索引有没有值
// 其中pq用来存放索引
// qp用来找索引在pq中的位置
// Keys存放具体的值，不过他们都有索引
class IndexMinPQ<Key extends Comparable<Key>> {
    private int N = 0;
    private int[] pq;
    private int[] qp;
    private Key[] keys;

    public IndexMinPQ(int max) {
        keys = (Key[]) new Comparable[max + 1];
        pq = new int[max + 1];
        qp = new int[max + 1];
        for (int i = 0; i <= max; i++) qp[i] = -1;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public boolean contains(int k) {
        return qp[k] != -1;
    }

    public int size() {
        return N;
    }

    public void insert(int k, Key v) {
        N++;
        qp[k] = N;
        pq[N] = k;
        keys[k] = v;
        swim(N);
    }

    public Key min() {
        return keys[pq[1]];
    }

    public int delMin() {
        int index = pq[1];
        exch(1, N--);
        sink(1);
        keys[pq[N + 1]] = null;
        qp[pq[N + 1]] = -1;
        return index;
    }

    private boolean less(int i, int j) {
        return keys[pq[i]].compareTo(keys[pq[j]]) < 0;
    }

    private void exch(int i, int j) {
        Key t = keys[pq[i]];
        keys[pq[i]] = keys[pq[j]];
        keys[pq[j]] = t;
    }

    private void swim(int k) {
        while (k > 1 && less(k, k / 2)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (k * 2 <= N) {
            int j = k * 2;
            if (j < N && less(j + 1, j)) j++;
            if (!less(j, k)) break;
            exch(k, j);
            k = j;
        }
    }

    public static void main(String[] args) {
        IndexMinPQ pq = new IndexMinPQ(12);
        String[] array = {"E", "A", "S", "Y", "Q", "U", "E", "S", "T", "I", "O", "N"};
        for (int i = 0; i < array.length; i++) {
            pq.insert(i, array[i]);
        }

        for (int i = 0; i < array.length; i++) {
            System.out.print(pq.min());
            pq.delMin();
        }
        System.out.println();
    }
}
