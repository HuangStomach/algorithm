// 2.1.25

class NoExchangeInsertion extends Example {
    public static void sort(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            Comparable x = a[i];
            int j = i;
            for (; j < a.length && less(a[j], a[j - 1]); j--) {
                a[j] = a[j - 1];
            }
            a[j] = x;
        }
    }
}