import edu.princeton.cs.algs4.*;

class RabinKarp {
    private String[] pat;
    private StringSET patHash;
    private int M;
    private long Q;
    private int R = 256;
    private long RM;

    public RabinKarp(String[] pat) {
        this.pat = pat;
        this.patHash = new StringSET();
        this.M = pat[0].length();
        Q = 997;
        RM = 1;
        for (int i = 1; i <= M - 1; i++) {
            RM = (R * RM) % Q;
        }

        for (int i = 0; i < pat.length; i++) {
            patHash.add(Long.toString(hash(pat[i], M)));
        }
    }

    public boolean check(String txt, int i) {
        for (int j = 0; j < M; j++, i++) {
            boolean match = false;
            for (int k = 0; k < pat.length; k++) {
                if (txt.charAt(i) != pat[k].charAt(j)) match |= true;
            }
            if (!match) return false;
        }
        return true;
    }

    private long hash(String key, int M) {
        long h = 0;
        for (int i = 0; i < M; i++) {
            h = (R * h + key.charAt(i)) % Q;
        }
        return h;
    }

    public int search(String txt) {
        int N = txt.length();
        long txtHash = hash(txt, M);
        if (patHash.contains(Long.toString(txtHash)) && check(txt, 0)) return 0;

        for (int i = M; i < N; i++) {
            txtHash = (txtHash + Q - RM * txt.charAt(i - M) % Q) % Q;
            txtHash = (txtHash * R + txt.charAt(i)) % Q;

            if (patHash.contains(Long.toString(txtHash)) && check(txt, i - M + 1)) return i - M + 1;
        }
        
        return N;
    }
}
