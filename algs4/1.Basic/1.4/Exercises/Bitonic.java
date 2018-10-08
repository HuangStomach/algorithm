// 1.4.20
public class Bitonic {

    public static int rank(int key, int[] a, int low, int high) {
        if (low > high) return -1;

        int mid = (low + high) / 2;
        if (key < a[mid]) return rank(key, a, low, mid - 1);
        else if (key > a[mid]) return rank(key, a, mid + 1, high);
        else return mid;
    }

    public static void main(String[] args) {
        int key = Integer.parseInt(args[0]);
        int N = 100;
        int[] array = new int[100];
        int i = N / 2;

        // 近似二分法寻找局部最大值 O(2lgN)
        while (true) {
            if (array[i] > array[i - 1] 
            && array[i] > array[i + 1]) {
                break;
            }

            if (array[i] < array[i - 1]) i = i / 2;
            if (array[i] < array[i + 1]) i = (N - i) / 2;
        }

        // 两次二分法寻找 O(lgN)
        int index = Math.max(
            rank(key, array, 0, i),
            rank(key, array, i, N - 1)
        );

        // 符合预期 O(3lgN)
        System.out.println(index);
    }
}
