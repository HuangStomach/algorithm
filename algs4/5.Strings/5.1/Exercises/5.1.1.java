import java.util.HashMap;

import edu.princeton.cs.algs4.*;

class LSD {
    public static void sort(String[] a, int W) {
        int N = a.length;
        int R = 256;
        String[] aux = new String[N];
        for (int d = W - 1; d >= 0; d--) {
            //HashMap map = new HashMap<Character, Integer>();
            BST<Integer, Integer> bst = new BST<Character, Integer>();
            for (int i = 0; i < N; i++) {
                int index = a[i].charAt(d) + 1;
                if (bst.get(index) == null) bst.put(index, val);
                else bst.put(index, bst.get(index));
            }

            for (int r = 0; r < R; r++) {
                bst.put(r + 1, bst.get(r) == null ? 0 : bst.get(r));
            }

            for (int i = 0; i < N; i++) {
                int index = bst.get(a[i].charAt(d) + 0) + 1;
                bst.put(a[i].charAt(d) + 0, index);
                aux[index] = a[i];
            }

            for (int i = 0; i < N; i++) {
                a[i] = aux[i];
            }
        }
    }
}