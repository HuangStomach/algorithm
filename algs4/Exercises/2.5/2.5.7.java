import edu.princeton.cs.algs4.*;

class Select {
    public static int compare = 0;
    public static Comparable select(Comparable[] a, int k, int low, int high) {
        int j = partition(a, low, high);
        if (j > k) return select(a, k, low, j - 1);
        else if (j < k) return select(a, k, j + 1, high);
        return a[k];
    }

    private static int partition(Comparable[] a, int low, int high) {
        int i = low;
        int j = high + 1;
        Comparable v = a[low];
        while (true) {
            while (less(a[++i], v)) if (i == high) break;
            while (less(v, a[--j])) if (j == low) break;
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, low, j);
        return j;
    }

    protected static boolean less(Comparable v, Comparable w) {
        compare++;
        return v.compareTo(w) < 0;
    }

    protected static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        String[] array = {"E", "A", "S", "Y", "Q", "U", "E", "S", "T", "I", "O", "N"};
        for (int i = 0; i < 100; i++) {
            StdRandom.shuffle(array);
            select(array, k, 0, array.length - 1);
        }
        System.out.println("平均需要" + compare / 100 + "也就是2N次比较");
    }
}