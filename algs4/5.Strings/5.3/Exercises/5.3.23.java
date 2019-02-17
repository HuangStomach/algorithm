import edu.princeton.cs.algs4.*;

class Plalindrome {
    static int Q = 997;
    static int R = 256;
    static int RM = 1;
    public static void main(String[] args) {
        String str = args[0];
        int M = str.length();

        for (int i = 1; i <= M - 1; i++) {
            RM = (R * RM) % Q;
        }
        
        long strHash = hash(str, M);
        long patHash = M % 2 == 1 ? (R * 0 + str.charAt(M / 2)) % Q : 0;

        for (int i = 0; i < M / 2; i++) {
            strHash = (strHash + Q - RM * str.charAt(i) % Q) % Q;
            strHash = (strHash * R + str.charAt(i)) % Q;
            
            patHash = (patHash * R + str.charAt(i)) % Q;
            patHash = (patHash * R + str.charAt(i)) % Q;
        }

        System.out.println(patHash == strHash ? "是" : "不是");
    }

    private static long hash(String key, int M) {
        long h = 0;
        for (int i = 0; i < M; i++) {
            h = (R * h + key.charAt(i)) % Q;
        }
        return h;
    }
}
