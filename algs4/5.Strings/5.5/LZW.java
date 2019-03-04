import edu.princeton.cs.algs4.*;

class LZW {
    private static int R = 256;
    private static int L = 4096;
    private static int W = 12;

    public static void compress() {
        String input = BinaryStdIn.readString();
        TST<Integer> st = new TST<Integer>();

        for (int i = 0; i < R; i++) {
            st.put("" + (char)i, i);
        }
        int code = R + 1;

        while (input.length() > 0) {
            String s = st.longestPrefixOf(input);
            BinaryStdOut.write(st.get(s), W);

            int t = s.length();
            if (t < input.length() && code < L) {
                st.put(input.substring(0, t + 1), code++);
            }
            input = input.substring(t);
        }
        BinaryStdOut.write(R, W);
        BinaryStdOut.close();
    }
}