import edu.princeton.cs.algs4.*;

class Sublinear {
    public static void sort(int[] a) {
        String[] strs = new String[a.length];
        for (int i = 0; i < a.length; i++) {
            String s = Integer.toBinaryString(a[i]);
            while (s.length() < 32) s = "0" + s;
            strs[i] = s;
        }

        LSD.sort(strs, 16);
        Integer[] b = new Integer[strs.length];
        for (int i = 0; i < strs.length; i++) {
            b[i] = Integer.valueOf(strs[i], 2);
        }
        Insertion.sort(b);
        for (int i = 0; i < b.length; i++) {
            a[i] = b[i].intValue();
        }
    }

    public static void main(String[] args) {
        int[] a = {234,111,123};
        sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
