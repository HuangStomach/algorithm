import java.util.Stack;

import edu.princeton.cs.algs4.*;

class Quick extends Example {
    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);

        Stack<int[]> stack = new Stack<int[]>();
        int[] init = {0, a.length - 1};
        stack.push(init);
        while(!stack.isEmpty()) {
            int[] array = stack.pop();
            int low = array[0];
            int high = array[1];
            if (low >= high) continue;

            int j = partition(a, low, high);

            int[] left = {low, j - 1};
            int[] right = {j + 1, high};

            int mid = (low + high) / 2;
            if (j <= mid) {
                stack.push(right);
                stack.push(left);
            }
            else {
                stack.push(left);
                stack.push(right);
            }
        }
    }

    private static int partition(Comparable[] a, int low, int high) {
        int i = low;
        int j = high + 1;
        Comparable v = a[low];
        while (true) {
            while (less(a[++i], v)) if (i == high) break;
            while (less(v, a[--j])) if (j == low) break;
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
        System.out.println();
    }
}