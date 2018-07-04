import java.util.Arrays;

import edu.princeton.cs.algs4.*;

class MergeChart {
    public static void main(String[] args) {
        StdDraw.setXscale(0, 512);
        StdDraw.setYscale(0, 6 * 512 * Math.log10(512));
        for (int i = 1; i <= 512; i++) {
            StdDraw.setPenRadius(.01);
            StdDraw.setPenColor(StdDraw.RED);
            StdDraw.point(i, 6 * i * Math.log10(i));

            Integer[] array = new Integer[i];
            Arrays.fill(array, 1);

            Merge.count = 0;
            Merge.sort(array);
            StdDraw.setPenColor(StdDraw.BLUE);
            StdDraw.point(i, Merge.count);
            MergeBU.count = 0;
            MergeBU.sort(array);
            StdDraw.setPenColor(StdDraw.GREEN);
            StdDraw.point(i, MergeBU.count);
        }
    }
}