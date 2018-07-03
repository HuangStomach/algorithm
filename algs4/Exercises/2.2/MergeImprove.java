// 2.2.11
public class MergeImprove extends Example {
    public static void sort(Comparable[] a) {
        Comparable[] aux = a.clone();
        sort(a, aux, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, Comparable[] aux, int low, int high) {
        if (high <= low ) return;
        if (high - low <= 14) insertionSort(aux, low, high);

        int mid = low + (high - low) / 2;
        sort(aux, a, low, mid);
        sort(aux, a, mid + 1, high);
        if (less(a[mid], a[mid + 1])) return;
        merge(a, aux, low, mid, high);
    }

    private static void insertionSort(Comparable[] a, int low, int high) {
        for (int i = low + 1; i < high + 1; i++) {
            Comparable x = a[i];
            int j = i;
            for (; j < a.length && less(a[j], a[j - 1]); j--) {
                a[j] = a[j - 1];
            }
            a[j] = x;
        }
    }

    public static void merge(Comparable[] a, Comparable[] aux, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;

        for(int k = low; k <= high; k++) {
            if (i > mid) aux[k] = a[j++];
            else if (j > high) aux[k] = a[i++];
            else if (less(a[j], a[i])) aux[k] = a[j++];
            else  aux[k] = a[i++];
        }
    }
}