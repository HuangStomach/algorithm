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
        for(int i = 0; i < whitelist.length; i++) {   
            whitelist[i] = i + 1; 
        }

        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            if (rank(key, whitelist) < 0) {
                StdOut.println(key);
            }
        }
    }

}