import edu.princeton.cs.algs4.*;

class Brute {
    private String pat;
    
    public Brute(String pat) {
        this.pat = pat;
    }

    public int search(String txt) {
        int j, M = pat.length();
        int i, N = txt.length();
        for (i = 0, j = M; i < N && j > 0; i++) {
            if (txt.charAt(i) == txt.charAt(j)) j--;
            else {
                i -= M - j;
                j = M;
            }
        }

        if (j == 0) return i - M;
        return N;
    }

    public static void main(String[] args) {
        String pat = args[0];
        String txt = args[1];
        Brute brute = new Brute(pat);
        System.out.println("text:    " + txt);
        int offset = brute.search(txt);
        System.out.print("pattern: ");
        for (int i = 0; i < offset; i++) {
            System.out.print(" ");
        }
        System.out.println(pat);
    }
}