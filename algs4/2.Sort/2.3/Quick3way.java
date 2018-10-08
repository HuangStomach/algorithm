import edu.princeton.cs.algs4.*;

public class Quick extends Example {
    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int low, int high) {
        if (high <= low) return;
        int less = low;
        int i = low + 1;
        int great = high;
        Comparable v = a[low];
        while(i < great) {
            int cmp = a[i].compareTo(v);
            if (cmp < 0) exch(a, less++, i++);
            else if (cmp > 0) exch(a, i, great--);
            else i++;
        }
        sort(a, low, less - 1);
        sort(a, great + 1, high);
    }
}