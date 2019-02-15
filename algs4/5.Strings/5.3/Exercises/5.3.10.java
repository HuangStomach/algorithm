import edu.princeton.cs.algs4.*;

class RabinKarp {
    private String pat;
    private long patHash;
    private int M;
    private long Q;
    private int R = 256;
    private long RM;

    public RabinKarp(String pat) {
        this.pat = pat;
        this.M = pat.length();
        Q = 997;
        RM = 1;
        for (int i = 1; i <= M - 1; i++) {
            RM = (R * RM) % Q;
        }
        patHash = hash(pat, M);
    }

    public boolean check(int i) {
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
        if (patHash == txtHash && check(0)) return 0;

        for (int i = M; i < N; i++) {
            txtHash = (txtHash + Q - RM * txt.charAt(i - M) % Q) % Q;
            txtHash = (txtHash * R + txt.charAt(i)) % Q;

            if (patHash == txtHash && check(i - M + 1)) return i - M + 1;
        }
        
        return N;
    }

    public int count(String txt) {
        return all(txt).size();
    }

    public Iterable<Integer> searchAll(String txt) {
        return all(txt);
    }

    private Queue<Integer> all(String txt) {
        Queue<Integer> queue = new Queue<Integer>();
        int N = txt.length();
        long txtHash = hash(txt, M);
        if (patHash == txtHash && check(0)) return 0;

        for (int i = M; i < N; i++) {
            txtHash = (txtHash + Q - RM * txt.charAt(i - M) % Q) % Q;
            txtHash = (txtHash * R + txt.charAt(i)) % Q;

            if (patHash == txtHash && check(i - M + 1)) {
                queue.enqueue(i - M + 1);
            }
        }
        return queue;
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
