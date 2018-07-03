// 2.1.26

public class IntegerInsertion {
    public static void sort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j < a.length && less(a[j], a[j - 1]); j--) {
                exch(a, j, j -1);
            }
        }
    }

    protected static boolean less(int v, int w) {
        return v < w;
    }

    protected static void exch(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    protected static void show(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "");
        }
        System.out.println();
    }

    public static boolean isSorted(int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] a = new int[100];
        sort(a);
        assert isSorted(a);
        show(a);
    }
}