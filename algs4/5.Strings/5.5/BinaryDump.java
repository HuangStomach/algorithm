import edu.princeton.cs.algs4.*;

class BinaryDump {
    public static void main(String[] args) {
        int width = Integer.parseInt(args[0]);
        int cnt;
        for (cnt = 0; !BinaryStdIn.isEmpty(); cnt++) {
            if (width == 0) continue;
            if (cnt != 0 && cnt % width == 0) StdOut.println();
            if (BinaryStdIn.readBoolean()) StdOut.println("1");
            else StdOut.println("0");
        }
        StdOut.println();
        StdOut.println(cnt + " bits");
    }
}
