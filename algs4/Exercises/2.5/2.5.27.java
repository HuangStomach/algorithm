class Insertion {
    public static void sort(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j -1);
            }
        }
    }

    public static int[] indirectSort(Comparable[] a) {
        int[] index = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            index[i] = i;
        }

        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0 && less(a[index[j]], a[index[j - 1]]); j--) {
                int t = index[j];
                index[j] = index[j - 1];
                index[j - 1] = t;
            }
        }

        return index;
    }

    protected static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    protected static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    protected static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "");
        }
        System.out.println();
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Integer[] ages = {0, 17, 2, 52, 25};
        String[] names = {"None", "Mike", "Billy", "Tom", "Stan"};
        int[] index = indirectSort(ages);
        for (int i = 0; i < index.length; i++) {
            System.out.println(names[index[i]]);
        }
    }
}