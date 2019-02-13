import edu.princeton.cs.algs4.*;

class Blank {
    public static void main(String[] args) {
        int M = 7;
        String pat = "";
        for (int i = 0; i < M; i++) {
            pat += " ";
        }

        KMP kmp = new KMP(pat);
        System.out.println(kmp.search("yajukwejnajeyuawkenmawenkjq"));
        System.out.println(kmp.search("abcdefg       hijkl"));
        System.out.println(kmp.search("abc    de  f   g       hijk   l"));
    }
}