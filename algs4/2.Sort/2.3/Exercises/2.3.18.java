import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

import edu.princeton.cs.algs4.*;

class Quick extends Example {
    public static int count;

    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        int max = 0;
        for (int i = 1; i < a.length; i++) {
            if (less(a[max], a[i])) max = i;
        }
        exch(a, max, a.length - 1);
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int low, int high) {
        if (high <= low) return;
        int j = partition(a, low, high);
        sort(a, low, j - 1);
        sort(a, j + 1, high);
    }

    private static int partition(Comparable[] a, int low, int high) {
        int i = low;
        int j = high + 1;
        Comparable v;

        if (high - low > 5) {
            Random rn = new Random();
            HashMap<Comparable, Integer> map = new HashMap<Comparable, Integer>();
            Comparable[] b = new Comparable[3];
            if (j - i <= a.length) for (int k = 0; k < 3; k++) {
                int index = rn.nextInt(j - i - 1) + i;
                b[k] = a[index];
                map.put(b[k], index);
            }
            Arrays.sort(b);
            v = b[1];
            exch(a, low, map.get(v));
        }
        else {
            v = a[low];
        }

        while (true) {
            while (less(a[++i], v)) count++;
            while (less(v, a[--j])) count++;
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, low, j);
        return j;
    }
    
    public static void main(String[] args) {
        String[] array = {"E", "A", "S", "Y", "Q", "U", "E", "S", "T", "I", "O", "N"};
        Quick.sort(array);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println(count);
    }
}