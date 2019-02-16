import edu.princeton.cs.algs4.*;

class Brute {
    private String pat;
    
    public Brute(String pat) {
        this.pat = pat;
    }

    public int search(String txt) {
        System.out.println(txt);
        int j, M = pat.length();
        int i, N = txt.length();
        for (i = 0, j = 0; i < N && j < M; i++) {
            if (txt.charAt(i) == pat.charAt(j)) j++;
            else {
                i -= j;
                j = 0;
                for (int k = 0; k < i; k++) {
                    System.out.print(" ");
                }
                System.out.println(this.pat);
            }
        }

        if (j == M) return i - M;
        return N;
    }

    public static void main(String[] args) {
        Brute brute = new Brute("AAAAAAAB");
        brute.search("AAAAAAAAAAAAAAAAAAAAAAAAB");
        brute = new Brute("ABABABAB");
        brute.search("ABABABABAABABABABAAAAAAAA");
    }
}