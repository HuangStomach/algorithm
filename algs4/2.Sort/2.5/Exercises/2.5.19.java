class KendallTau {
    int count = 0;
    int[] standard;
    int[] aux;
    
    KendallTau(int[] a) {
        this.standard = new int[a.length];
        this.aux = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            this.standard[a[i]] = i;
        }
    }

    public void distance(int[] array) {
        int[] index = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            index[i] = this.standard[array[i]];
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(this.standard[i]);
        }
        System.out.println();
        for (int i = 0; i < array.length; i++) {
            System.out.print(index[i]);
        }
        System.out.println();

        sort(index, 0, array.length - 1);
    }

    public void sort(int[] array, int low, int high) {
        if (high <= low) return;
        int mid = low + (high - low) / 2;
        sort(array, low, mid);
        sort(array, mid + 1, high);
        merge(array, low, mid, high);
    }

    public void merge(int[] array, int low, int mid, int high) {
        int i = low, j = mid + 1;
        for (int k = low; k <= high; k++) aux[k] = array[k];

        for (int k = low; k <= high; k++) {
            if (i > mid) array[k] = aux[j++];
            else if (j > high) array[k] = aux[i++];
            else if (aux[j] < aux[i]) {
                array[k] = aux[j++];
                count += mid - i + 1; // 每个比前子数组小的后子数组元素，逆序数为前子数组现有的长度
            }
            else array[k] = aux[i++];
        }
    }

    public int count() {
        return this.count;
    }

    public static void main(String[] args) {
        int[] a = { 0, 3, 1, 6, 2, 5, 4 };
        int[] b = { 1, 0, 3, 6, 4, 2, 5 };
        KendallTau k = new KendallTau(a);
        k.distance(b);
        int distance = k.count();
        System.out.println(distance);
    }
}