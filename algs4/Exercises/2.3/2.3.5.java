import edu.princeton.cs.algs4.*;

class QuickOnlyTwo extends Example {
    public static void main(String[] args) {
        Integer[] a = { 2, 2, 1, 1, 2, 2, 2, 1, 1, 1, 2, 1, 2, 1, 2, 1 };
        sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }
        System.out.println();
    }

    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int low, int high) {
        if (high <= low) return;
        int i = low;
        int j = high + 1;
        Comparable v = a[low];
        while (true) {
            while (a[++i] == v) continue;
            while (a[--j] != v) continue;
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, low, j);
    }
}