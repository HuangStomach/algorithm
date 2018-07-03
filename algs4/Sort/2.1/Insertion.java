public class Insertion extends Example {
    public static void sort(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j < a.length && less(a[j], a[j - 1]); j--) {
                exch(a, j, j -1);
            }
        }
    }
}