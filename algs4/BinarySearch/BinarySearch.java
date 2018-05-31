import java.util.Arrays;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;

public class BinarySearch {

    public static int rank(int key, int[] a) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (key < a[mid]) high = mid - 1;
            else if (key > a[mid]) low = mid + 1;
            else return mid;
        }
        return -1;
    }

    public static void main (String[] args) {
        int[] whitelist = new int[1024];
        for(int i = 1; i <= whitelist.length; i++) {   
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