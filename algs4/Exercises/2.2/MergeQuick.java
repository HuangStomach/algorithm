// 2.2.10
public class MergeQuick extends Example {
    private static Comparable[] aux;

    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int low, int high) {
        if (high <= low ) return;
        int mid = low + (high - low) / 2;
        sort(a, low, mid);
        sort(a, mid + 1, high);
        if (less(a[mid], a[mid + 1])) return; // 2.2.8
        merge(a, low, mid, high);
    }

    public static void merge(Comparable[] a, int low, int mid, int high) {
        for (int i = low; i <= mid; i++) {
            aux[i] = input[i];
        }
        
        for (int i = mid + 1; i <= high; i++) {
            aux[i] = input[high -i + mid + 1];
        }
        
        int i = low;
        int j = high;
        for(int k = low; k <= high; k++) {
            if (less(aux[j], aux[i])) input[k] = aux[j--];
            else input[k] = aux[i++];
        }
    }
}