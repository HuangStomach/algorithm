import java.util.ArrayList;

// 2.1.11
class ArrayShellSort extends Example {
    public static void ArrayShelloSort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 1; h < N / 3; i++) {
            list.add(i, h);
            h = 3 * h + 1;
        }

        
        for (int k = list.size(); list.size() > 0; k--) {
            int inner = list.remove(k);
            for (int i = h; i < N; i++) {
                for (int j = i; j >= inner && less(a[j], a[j - inner]); j -= inner) {
                    exch(a, j, j - inner);
                }
            }
        }
    }
}