import edu.princeton.cs.algs4.*;

class LSD {
    public static void sort(String[] a, int W) {
        int N = a.length;
        int R = 256;
        String[] aux = new String[N];
        for (int d = W - 1; d >= 0; d--) {
            Queue<Integer>[] count = new Queue<Integer>[R + 1];
            for (int i = 0; i < N; i++) {
                count[a[i].charAt(d) + 1].enqueue(1);
            }

            for (int r = 0; r < R; r++) {
                for (int i: count[r].iterator()) {
                    count[r + 1].enqueue(i);
                }
            }

            for (int i = 0; i < N; i++) {
                Queue<Integer> queue = count[a[i].charAt(d)];
                queue.enqueue(1);
                aux[queue.size()] = a[i];
            }

            for (int i = 0; i < N; i++) {
                a[i] = aux[i];
            }
        }
    }
}
