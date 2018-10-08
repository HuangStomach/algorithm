import edu.princeton.cs.algs4.*;

class MaxCount {
    public static void main(String[] args) {
        String[] array = {"E", "A", "S", "Y", "Q", "U", "E", "S", "T", "I", "O", "N"};
        Quick.sort(array);
        System.out.println(12 + " " + Quick.count);
    }
}

class Quick extends Example {
    public static int count = 0;

    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int low, int high) {
        if (high <= low) return;
        int j = partition(a, low, high);
        sort(a, low, j - 1);
        sort(a, j + 1, high);
    }

    private static int partition(Comparable[] a, int low, int high) {
        int i = low;
        int j = high + 1;
        Comparable v = a[low];
        while (true) {
            while (less(a[++i], v)) if (i == high) break;
            while (less(v, a[--j])) if (j == low) break;
            if (i >= j) break;
            if (a[i] == "Y" || a[j] == "Y") count++;
            exch(a, i, j);
        }
        if (a[low] == "Y" || a[j] == "Y") count++;
        exch(a, low, j);
        return j;
    }
}