import java.util.Random;

import edu.princeton.cs.algs4.*;

class Quick extends Example {
    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int low, int high) {
        if (high <= low) return;
        int j = partition(a, low, high);
        sort(a, low, j - 1);
        sort(a, j + 1, high);
    }

    private static int partition(Comparable[] a, int low, int high) {
        int n = high - low + 1;
        int min = median3(a, low, low + n / 2, high);
        exch(a, min, low);

        int i = low;
        int j = high + 1;
        Comparable v = a[low];

        // a[lo] is unique largest element
        while (less(a[++i], v)) {
            if (i == high) { 
                exch(a, low, high); 
                return high; 
            }
        }

        // a[lo] is unique smallest element
        while (less(v, a[--j])) {
            if (j == low + 1) return low;
        }

        // the main loop
        while (i < j) { 
            exch(a, i, j);
            while (less(a[++i], v));
            while (less(v, a[--j]));
        }

        exch(a, low, j);
        return j;
    }
    
    private static int median3(Comparable[] a, int i, int j, int k) {
        return (less(a[i], a[j]) ?
               (less(a[j], a[k]) ? j : less(a[i], a[k]) ? k : i) :
               (less(a[k], a[j]) ? j : less(a[k], a[i]) ? k : i));
    }

    public static void main(String[] args) {
        String[] array = {"E", "A", "S", "Y", "Q", "U", "E", "S", "T", "I", "O", "N"};
        Quick.sort(array);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}