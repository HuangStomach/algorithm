import java.util.Arrays;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;

public class BinarySearch {

    public static int rank(int key, int[] a) {
        return rank(key, a, 0, a.length - 1, 1);
    }

    public static int rank(int key, int[] a, int low, int high, int deep) {
        if (low > high) return -1;
        StdOut.println("深度为" + deep);

        int mid = (low + high) / 2;
        if (key < a[mid]) return rank(key, a, low, mid - 1, ++deep);
        else if (key > a[mid]) return rank(key, a, mid + 1, high, ++deep);
        else return mid;
    }

    public static void main(String[] args) {
        int[] whitelist = new int[1024];
        for(int i = 0; i <= whitelist.length - 1; i++) {   
            whitelist[i] = i; 
        }

        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            int index = rank(key, whitelist);
            if (index < 0) StdOut.println("值[" + key + "]没有找到");
            else StdOut.println("值[" + key + "]在索引[" + index + "]处");
        }
    }

}