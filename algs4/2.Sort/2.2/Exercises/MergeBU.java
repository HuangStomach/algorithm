public class MergeBU extends Example {
    private static Comparable[] aux;
    public static int count = 0;

    public static void sort(Comparable[] a) {
        int N = a.length;
        aux = new Comparable[N];
        for (int sz = 1; sz < N; sz += sz) {
            for (int low = 0; low < N - sz; low += 2 * sz) {
                merge(a, low, low + sz - 1, Math.min(low + sz + sz - 1, N - 1));
            }
        }
    }

    public static void merge(Comparable[] a, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;

        for (int k = low; k <= high; k++) {
            aux[k] = a[k];
            count++;
        }

        for (int k = low; k <= high; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > high) a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
            count++;
        }
    }
}