class Sublinear {
    public static String[] array = {"E", "A", "S", "Y", "Q", "U", "E", "S", "T", "I", "O", "N"};

    public static void sort(String[] a, int low, int high) {
        // 选择排序
        for (int i = low; i < high; i++) {
            int min = i;
            String temp = a[i];
            for (int j = i; j < high; j++) {
                if (a[j].compareTo(a[min]) < 0) min = j;
            }
            a[i] = a[min];
            a[min] = temp;
        }
    }

    public static void max(int M, int N) {
        for (int i = 0; i < array.length; i++) {
            if (i % N == 0) {
                sort(array, i, i + N);
            }
        }

        for (int i = 1; i < N - 1; i++) {
            merge(array, 0, N * i - 1, N * (i + 1) - 1);
        }

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
        System.out.println();
    }


    public static void merge(String[] a, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;

        String[] aux = new String[high - low + 1];
        for (int k = low; k <= high; k++) {
            aux[k] = a[k];
        }

        for (int k = low; k <= high; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > high) a[k] = aux[i++];
            else if (aux[j].compareTo(aux[i]) < 0) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }

    public static void main(String[] args) {
        max(12, 4);
    }
}