class MidPQ<Key extends Comparable<Key>> {
    private Key[] big;
    private Key[] small;
    Key mid = null;
    private int bigCount = 0;
    private int smallCount = 0;

    public MaxPQ(int max) {
        big = (Key[]) new Comparable[max / 2 + 1];
        small = (Key[]) new Comparable[max / 2 + 1];
    }

    public boolean isEmpty() {
        return bigCount + smallCount + (mid == null ? 0 : 1) == 0;
    }

    public int size() {
        return smallCount + bigCount + (mid == null ? 0 : 1);
    }

    public void insert(Key v) {
        if (mid == null) mid = v;
        else if (less(v, mid)) {
            small[++smallCount] = v;
            swimMax(smallCount);
        }
        else {
            big[++bigCount] = v;
            swimMin(bigCount);
        }

        if (bigCount - smallCount == 2) {
            small[++smallCount] = mid;
            swimMax(smallCount);
            mid = big[1];
            big[1] = big[bigCount--];
            big[bigCount + 1] = null;
            sinkMin(1);
        }
        else if (smallCount > bigCount) {
            big[++bigCount] = mid;
            swimMin(bigCount);
            mid = small[1];
            small[1] = small[smallCount--];
            small[smallCount + 1] = null;
            sinkMax(1);
        }
    }

    public Key mid() {
        return mid;
    }

    public Key delMid() {
        Key mid = this.mid;
        if (bigCount > smallCount) {
            this.mid = big[1];
            big[1] = big[bigCount--];
            big[bigCount + 1] = null;
            sinkMin(1);
        }
        else {
            this.mid = small[1];
            small[1] = small[smallCount--];
            small[smallCount + 1] = null;
            sinkMax(1);
        }
        return mid;
    }

    private boolean less(Key i, Key j) {
        return i.compareTo(j) < 0;
    }

    private void swimMin(int k) {
        Key val = big[k];
        while (k > 1 && less(val, big[k / 2])) {
            big[k] = big[k / 2];
            k = k / 2;
        }
        big[k] = val;
    }

    private void swimMax(int k) {
        Key val = small[k];
        while (k > 1 && less(small[k / 2], val)) {
            small[k] = small[k / 2];
            k = k / 2;
        }
        small[k] = val;
    }

    private void sinkMin(int k) {
        Key val = big[k];
        while (k * 2 <= bigCount) {
            int j = k * 2;
            if (j < bigCount && less(big[j + 1], big[j])) j++;
            if (!less(big[j], val)) break;
            big[k] = big[j];
            k = j;
        }
        big[k] = val;
    }

    private void sinkMax(int k) {
        Key val = small[k];
        while (k * 2 <= smallCount) {
            int j = k * 2;
            if (j < smallCount && less(small[j], small[j + 1])) j++;
            if (!less(val, small[j])) break;
            small[k] = small[j];
            k = j;
        }
        small[k] = val;
    }

    public void show() {
        System.out.println(mid);
        for (int i = 0; i < bigCount; i++) {
            System.out.print(big[i + 1]);
        }
        System.out.println();

        for (int i = 0; i < smallCount; i++) {
            System.out.print(small[i + 1]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MaxPQ pq = new MidPQ(12);
        String[] array = {"E", "A", "S", "Y", "Q", "U", "E", "S", "T", "I", "O", "N"};
        for (int i = 0; i < array.length; i++) {
            pq.insert(array[i]);
            System.out.print(pq.mid());
        }
        System.out.println();

        for (int i = 0; i < array.length; i++) {
            System.out.print(pq.delMid());
        }
        System.out.println();
    }
}