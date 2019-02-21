import edu.princeton.cs.algs4.*;

class childString {
    static int Q = 997;
    static int R = 256;
    static int RM = 1;
    
    public static void main(String[] args) {
        String str = "cgcgggcgcg";
        int L = 3;

        for (int i = 1; i <= L - 1; i++) {
            RM = (R * RM) % Q;
        }

        int M = str.length();
        long hash = hash(str, L);
        
        ST<Long, String> set = new ST<Long, String>();

        for (int i = 0; i < M - L; i++) {
            hash = (hash + Q - RM * str.charAt(i) % Q) % Q;
            hash = (hash * R + str.charAt(i + L)) % Q;

            if (!set.contains(hash)) {
                set.put(hash, str.substring(i, i + L));
            }
        }

        for (long key: set.keys()) {
            System.out.println(set.get(key));
        }
    }

    private static long hash(String key, int M) {
        long h = 0;
        for (int i = 0; i < M; i++) {
            h = (R * h + key.charAt(i)) % Q;
        }
        return h;
    }
}
