import edu.princeton.cs.algs4.*;

class Brute {
    private String pat;
    private int M;
    
    public Brute(String pat) {
        this.pat = pat;
        this.M = pat.length();
    }

    public int search(String txt) {
        int j = pat.length();
        int i, N = txt.length();
        for (i = 0, j = 0; i < N && j < M; i++) {
            if (txt.charAt(i) == pat.charAt(j)) j++;
            else {
                i -= j;
                j = 0;
            }
        }

        if (j == M) return i - M;
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
        Brute brute = new Brute(pat);
        System.out.println(brute.search(new In()));
    }
}