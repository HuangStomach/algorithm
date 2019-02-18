import edu.princeton.cs.algs4.*;

class Plalindrome {
    static int Q = 997;
    static int R = 256;
    static int RM = 1;
    public static void main(String[] args) {
        String a = args[0];
        String b = args[1];

        int M = a.length();
        for (int i = 1; i <= M - 1; i++) {
            RM = (R * RM) % Q;
        }
        
        long aHash = hash(a, M);
        long bHash = hash(b, M);
        

        for (int i = 0; i < M; i++) {
            if (aHash == bHash) {
                System.out.println("Yes!");
                return;
            }

            aHash = (aHash + Q - RM * a.charAt(i) % Q) % Q;
            aHash = (aHash * R + a.charAt(i)) % Q;
        }

        System.out.println("No!");
    }

    private static long hash(String key, int M) {
        long h = 0;
        for (int i = 0; i < M; i++) {
            h = (R * h + key.charAt(i)) % Q;
        }
        return h;
    }
}
