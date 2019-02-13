import edu.princeton.cs.algs4.*;

class BruteForceRL {
    private String pat;

    BruteForceRL(String pat) {
        this.pat = pat;
    }

    public int search(String txt) {
        int N = txt.length();
        int M = pat.length();
        
        for (int i = 0; i <= N - M; i++) {
            for (int j = M - 1; j >= 0; j--) {
                if (pat.charAt(j) != pat.charAt(i + j)) {
                    break;
                }
            }

            if (j == 0) return i;
        }
        return M;
    }

    public static void main(String[] args) {
        String pat = args[0];
        String txt = args[1];
        BruteForceRL bruteforcerl = new BruteForceRL(pat);
        System.out.println("text:    " + txt);
        int offset = bruteforcerl.search(txt);
        System.out.print("pattern: ");
        for (int i = 0; i < offset; i++) {
            System.out.print(" ");
        }
        System.out.println(pat);
    }
}