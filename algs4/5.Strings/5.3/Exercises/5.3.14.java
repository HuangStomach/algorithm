import edu.princeton.cs.algs4.*;

class RabinKarp {
    private char[] pat;
    private long patHash;
    private int M;
    private long Q;
    private int R = 256;
    private long RM;

    public RabinKarp(String pat) {
        this.pat = pat.toCharArray();
        this.M = pat.length();
        Q = 997;
        RM = 1;
        for (int i = 1; i <= M - 1; i++) {
            RM = (R * RM) % Q;
        }
        patHash = hash(this.pat, M);
    }

    public boolean check(char[] txt, int i) {
        for (int j = 0; j < M; j++, i++) {
            if (txt[i] != pat[j]) return false;
        }
        return true;
    }

    private long hash(char[] key, int M) {
        long h = 0;
        for (int i = 0; i < M; i++) {
            h = (R * h + key[i]) % Q;
        }
        return h;
    }

    public int search(String txt) {
        char[] chars = txt.toCharArray();
        int N = chars.length;
        long txtHash = hash(chars, M);
        if (patHash == txtHash && check(chars, 0)) return 0;

        for (int i = M; i < N; i++) {
            txtHash = (txtHash + Q - RM * chars[i - M] % Q) % Q;
            txtHash = (txtHash * R + chars[i]) % Q;

            if (patHash == txtHash && check(chars, i - M + 1)) return i - M + 1;
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
