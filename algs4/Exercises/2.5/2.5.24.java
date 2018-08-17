public class StableMinPQ<Key extends Comparable<Key>> {
    private Key[]  pq;                   // store element at indices 1 to N
    private long[] time;                 // timestamp
    private int n;                       // number of elements on priority queue
    private long timestamp = 1;          // timestamp for when item was inserted

    // create an empty priority queue with given initial capacity
    public StableMinPQ(int initCapacity) {
        pq = (Key[]) new Comparable[initCapacity + 1];
        time = new long[initCapacity + 1];
        n = 0;
    }

    // create an empty priority queue
    public StableMinPQ() {
        this(1);
    }


    // Is the priority queue empty?
    public boolean isEmpty() {
        return n == 0;
    }

    // Return the number of elements on the priority queue.
    public int size() {
        return n;
    }

     //  Return the smallest key on the priority queue.
    public Key min() {
        if (isEmpty()) throw new RuntimeException("Priority queue underflow");
        return pq[1];
    }

    // helper function to double the size of the heap array
    private void resize(int capacity) {
        assert capacity > n;
        Key[]  tempPQ   = (Key[]) new Comparable[capacity];
        long[] tempTime = new long[capacity];
        for (int i = 1; i <= n; i++)
            tempPQ[i] = pq[i];
        for (int i = 1; i <= n; i++)
            tempTime[i] = time[i];
        pq   = tempPQ;
        time = tempTime;
    }

    // add a new key to the priority queue
    public void insert(Key x) {
        // double size of array if necessary
        if (n == pq.length - 1) resize(2 * pq.length);

        // add x, and percolate it up to maintain heap invariant
        n++;
        pq[n] = x;
        time[n] = ++timestamp;
        swim(n);
        assert isMinHeap();
    }

    // Delete and return the smallest key on the priority queue.
    public Key delMin() {
        if (n == 0) throw new RuntimeException("Priority queue underflow");
        exch(1, n);
        Key min = pq[n--];
        sink(1);
        pq[n+1] = null;         // avoid loitering and help with garbage collection
        time[n+1] = 0;  
        if ((n > 0) && (n == (pq.length - 1) / 4)) resize(pq.length  / 2);
        assert isMinHeap();
        return min;
    }


   /***************************************************************************
    * Helper functions to restore the heap invariant.
    ***************************************************************************/

    private void swim(int k) {
        while (k > 1 && greater(k/2, k)) {
            exch(k, k/2);
            k = k/2;
        }
    }

    private void sink(int k) {
        while (2*k <= n) {
            int j = 2*k;
            if (j < n && greater(j, j+1)) j++;
            if (!greater(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

   /***************************************************************************
    * Helper functions for compares and swaps.
    ***************************************************************************/
    private boolean greater(int i, int j) {
        int cmp = pq[i].compareTo(pq[j]);
        if (cmp > 0) return true;
        if (cmp < 0) return false;
        return time[i] > time[j];
    }

    private void exch(int i, int j) {
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
        long tempTime = time[i];
        time[i] = time[j];
        time[j] = tempTime;
    }

    // is pq[1..N] a min heap?
    private boolean isMinHeap() {
        return isMinHeap(1);
    }

    // is subtree of pq[1..n] rooted at k a min heap?
    private boolean isMinHeap(int k) {
        if (k > n) return true;
        int left = 2*k, right = 2*k + 1;
        if (left  <= n && greater(k, left))  return false;
        if (right <= n && greater(k, right)) return false;
        return isMinHeap(left) && isMinHeap(right);
    }


    private static final class Tuple implements Comparable<Tuple> {
        private String name;
        private int id;

        private Tuple(String name, int id) {
            this.name = name;
            this.id = id;
        }

        public int compareTo(Tuple that) {
            return this.name.compareTo(that.name);
        }

        public String toString() {
            return name + " " + id;
        }
    }

    // test client
    public static void main(String[] args) {
        StableMinPQ<Tuple> pq = new StableMinPQ<Tuple>();
        
        // insert a bunch of strings
        String text = "it was the best of times it was the worst of times it was the "
                    + "age of wisdom it was the age of foolishness it was the epoch "
                    + "belief it was the epoch of incredulity it was the season of light "
                    + "it was the season of darkness it was the spring of hope it was the "
                    + "winter of despair";
        String[] strings = text.split(" ");
        for (int i = 0; i < strings.length; i++) {
            pq.insert(new Tuple(strings[i], i));
        }


        // delete and print each key
        while (!pq.isEmpty()) {
            StdOut.println(pq.delMin());
        }
        StdOut.println();

    }

}
