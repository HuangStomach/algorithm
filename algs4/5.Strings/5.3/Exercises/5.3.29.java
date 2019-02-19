import edu.princeton.cs.algs4.*;

class BoyerMoore {
    private int[] right;
    private String pat;
    private int M;

    BoyerMoore(String pat) {
        this.pat = pat;
        M = pat.length();
        int R = 256;
        right = new int[R];
        for (int c = 0; c < R; c++) {
            right[c] = -1;
        }

        for (int j = 0; j < M; j++) {
            right[pat.charAt(j)] = j;
        }
    }

    public int search(String txt) {
        int N = txt.length();
        int skip;
        for (int i = 0; i <= N - M; i += skip) {
            skip = 0;
            for (int j = M - 1; j >= 0; j--) {
                if (pat.charAt(j) != txt.charAt(i + j)) {
                    skip = Math.max(1, j - right[txt.charAt(i+j)]);
                    break;
                }
            }

            if (skip == 0) return i;
        }
        return N;
    }

    public int search(In in) {
        StringBuffer sb = new StringBuffer();
        int length = 0;
        while (!in.isEmpty()) {
            String str = in.readString();
            sb.append(str);
            if (sb.length() >= M) {
                String sbr = sb.toString();
                int offset = search(sbr);
                if (offset < sbr.length()) return length + offset;
                sb.delete(0, sbr.length() - M);
                length += sbr.length() - M;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String pat = args[0];
        BoyerMoore bm = new BoyerMoore(pat);
        System.out.println(bm.search(new In()));
    }
}