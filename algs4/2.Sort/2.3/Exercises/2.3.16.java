class BestCase extends Example {
    public static void exch(int[] array, int low, int high) {
        if (low >= high) return;

        int mid = (high + low) / 2;
        int val = array[mid];
        for (int i = mid; i > low; i--) {
            array[i] = array[i - 1];
        }
        array[low] = val;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        exch(array, low + 1, mid);
        exch(array, mid + 1, high);
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = i;
        }

        exch(array, 0, N - 1);
        for (int i = 0; i < N; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
