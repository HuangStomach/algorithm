import edu.princeton.cs.algs4.*;

class Brute {
    private String pat;
    
    public Brute(String pat) {
        this.pat = pat;
    }

    public int search(String txt) {
        int j, M = pat.length();
        int i, N = txt.length();
        for (i = 0, j = 0; i < N && j < M; i++) {
            if (txt.charAt(i) == txt.charAt(j)) j++;
            else {
                i -= j;
                j = 0;
            }
        }

        if (j == M) return i - M;
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