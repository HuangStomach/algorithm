import java.util.LinkedList;

import edu.princeton.cs.algs4.*;

class Quick3LinkedList {
    private static int charAt(String s, int d) {
        return d < s.length() ? s.charAt(d) : -1;
    }

    public static void sort(LinkedList<String> a) {
        sort(a, 0, a.size() - 1, 0);
    }

    private static void sort(LinkedList<String> a, int lo, int hi, int d) {
        if (hi <= lo) return;
        int lt = lo;
        int gt = hi;
        int v = charAt(a.get(lo), d);
        int i = lo + 1;
        while (i <= gt) {
            int t = charAt(a.get(i), d);
            if (t < v) exch(a, lt++, i++);
            else if (t > v) exch(a, i, gt--);
            else i++;
        }

        sort(a, lo, lt - 1, d);
        if (v >= 0) sort(a, lt, gt, d + 1);
        sort(a, gt + 1, hi, d);
    }

    private static void exch(LinkedList<String> a, int i, int j) {
        String t = a.get(i);
        a.set(i, a.get(j));
        a.set(j, t);
    }
}
