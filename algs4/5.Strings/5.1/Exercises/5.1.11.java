import java.util.Comparator;

import edu.princeton.cs.algs4.*;

class MSD {
    private static int R = 256;
    private static final int M = 3;
    private static Queue<String>[] count;

    private static int charAt(String s, int d) {
        if (d < s.length()) return s.charAt(d);
        else return -1;
    }

    public static void sort(String[] a) {
        int N = a.length;
        count = (Queue<String>[]) new Queue[R + 2];
        for (int i = 0; i < R + 2; i++) {
            count[i] = new Queue<String>();
        }
        sort(a, 0, N - 1, 0);
    }

    private static void sort(String[] a, int lo, int hi, int d) {
        if (hi <= lo + M) {
            insertion(a, lo, hi, d);
            return;
        }

        for (int i = lo; i <= hi; i++) {
            int index = charAt(a[i], d) + 2;
            count[index].enqueue(a[i]);
        }
        
        int i = lo;
        for (int j = 0; j < count.length; j++) {
            if (count[j].isEmpty()) continue;

            int start = i;
            while (!count[j].isEmpty()) {
                a[i++] = count[j].dequeue();
            }
            sort(a, start, i - 1, d + 1);
        }
    }
    
    private static void insertion(String[] a, int lo, int hi, int d) {
        for (int i = lo; i <= hi; i++) {
            for (int j = i; j > lo && less(a[j], a[j - 1], d); j--) {
                exch(a, j, j - 1);
            }
        }
    }

    private static void exch(String[] a, int i, int j) {
        String temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static boolean less(String v, String w, int d) {
        // assert v.substring(0, d).equals(w.substring(0, d));
        for (int i = d; i < Math.min(v.length(), w.length()); i++) {
            if (v.charAt(i) < w.charAt(i)) return true;
            if (v.charAt(i) > w.charAt(i)) return false;
        }
        return v.length() < w.length();
    }

    public static void main(String[] args) {
        String[] list = {"now", "is", "the", "time", "for", "all", "good", "people", "to", "come", "to", "the", "aid", "of"};
        sort(list);

        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }
        System.out.println();
    }
}