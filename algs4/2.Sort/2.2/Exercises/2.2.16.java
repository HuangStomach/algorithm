class NatureMerge {
    public static String[] array = {"E", "A", "S", "Y", "Q", "U", "E", "S", "T", "I", "O", "N"};

    public static void main(String[] args) {
        while(true) {
            int low = -1;
            int high = -1;
            int mid = -1;
            for (int i = 0; i < array.length; i++) {
                if (low == -1) low = i;
                else if (mid == -1 && array[i - 1].compareTo(array[i]) > 0 && i > 0) mid = i - 1;
                else if (mid > -1 && high == -1 && array[i - 1].compareTo(array[i]) > 0) {
                    high = i;
                    merge(array, low, mid, high);
                }

            }
            if (high == -1 && mid == -1) break;
            if (high == -1) {
                merge(array, low, mid, array.length - 1);
                break;
            }
        }

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
        System.out.println();
    }

    public static void merge(String[] a, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;

        String[] aux = new String[a.length];
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
}