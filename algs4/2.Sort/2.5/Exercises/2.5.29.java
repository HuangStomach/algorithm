import java.io.File;

import edu.princeton.cs.algs4.*;

class FileSorter {
    public static void main(String[] args) {
        StableMinPQ pq = new StableMinPQ(args[0]);
        while (!StdIn.isEmpty()) {
            String name = StdIn.readString();
            File file = new File(name);
            pq.insert(file);
        }

        while (!pq.isEmpty()) {
            System.out.println(pq.delMin().getName());
        }
    }
}

class StableMinPQ {
    private String type;
    private File[]  pq;                   // store element at indices 1 to N
    private long[] time;                 // timestamp
    private int n;                       // number of elements on priority queue
    private long timestamp = 1;          // timestamp for when item was inserted

    // create an empty priority queue with given initial capacity
    public StableMinPQ(String arg, int initCapacity) {
        type = arg;
        pq = new File[initCapacity + 1];
        time = new long[initCapacity + 1];
        n = 0;
    }

    // create an empty priority queue
    public StableMinPQ(String arg) {
        this(arg, 1);
    }

    public StableMinPQ() {
        this("-n", 1);
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
    public File min() {
        if (isEmpty()) throw new RuntimeException("Priority queue underflow");
        return pq[1];
    }

    // helper function to double the size of the heap array
    private void resize(int capacity) {
        assert capacity > n;
        File[]  tempPQ   = new File[capacity];
        long[] tempTime = new long[capacity];
        for (int i = 1; i <= n; i++)
            tempPQ[i] = pq[i];
        for (int i = 1; i <= n; i++)
            tempTime[i] = time[i];
        pq   = tempPQ;
        time = tempTime;
    }

    // add a new key to the priority queue
    public void insert(File x) {
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
    public File delMin() {
        if (n == 0) throw new RuntimeException("Priority queue underflow");
        exch(1, n);
        File min = pq[n--];
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
        int cmp = 0;
        switch (type) {
            case "-n":
                cmp = pq[i].getName().compareTo(pq[j].getName());
            break;
            case "-t":
                long result = pq[i].lastModified() - pq[j].lastModified();
                if (result > 0) cmp = 1;
                else if (result < 0) cmp = -1;
            break;
        }
        
        if (cmp > 0) return true;
        if (cmp < 0) return false;
        return time[i] > time[j];
    }

    private void exch(int i, int j) {
        File temp = pq[i];
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
}
