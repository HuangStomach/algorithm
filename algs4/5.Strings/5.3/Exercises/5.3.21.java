import edu.princeton.cs.algs4.*;

class RabinKarp {
    private String pat;
    private int M;
    private boolean[] patMatch;
    private long Q;
    private int R = 256;
    private long RM;

    public RabinKarp(String pat) {
        this.pat = pat;
        this.M = pat.length();
        this.patMatch = new boolean[this.M];
        Q = 997;
        RM = 1;
        for (int i = 1; i <= M - 1; i++) {
            RM = (R * RM) % Q;
        }
    }

    public boolean check(String txt, int i) {
        for (int j = 0; j < M; j++, i++) {
            if (charAt(txt, i, j) != pat.charAt(j)) return false;
        }
        return true;
    }

    private char charAt(String key, int i, int j) {
        return patMatch[j] ? '*' : key.charAt(i);
    }

    private long patHash(String key, int j) {
        long h = 0;
        for (int i = 0; i < M; i++) {
            if (pat.charAt(i) == '*') h = (R * h + key.charAt(j + i)) % Q;
            else h = (R * h + pat.charAt(i)) % Q;
        }
        return h;
    }

    private long txtHash(String key) {
        long h = 0;
        for (int i = 0; i < M; i++) {
            h = (R * h + charAt(key, i, i)) % Q;
        }
        return h;
    }

    public int search(String txt) {
        int N = txt.length();
        long txtHash = txtHash(txt);
        if (patHash(txt, 0) == txtHash && check(txt, 0)) return 0;

        for (int i = M; i < N; i++) {
            txtHash = (txtHash + Q - RM * charAt(txt, i - M, 0) % Q) % Q;
            txtHash = (txtHash * R + charAt(txt, i, M - 1)) % Q;
            if (patHash(txt, i - M + 1) == txtHash && check(txt, i - M + 1)) return i - M + 1;
        }
        
        return N;
    }

    public static void main(String[] args) {
        String pat = args[0];
        String txt = args[1];
        RabinKarp rabinkarp = new RabinKarp(pat);
        System.out.println("text:    " + txt);
        int offset = rabinkarp.search(txt);
        System.out.print("pattern: ");
        for (int i = 0; i < offset; i++) {
            System.out.print(" ");
        }
        System.out.println(pat);
    }
}
