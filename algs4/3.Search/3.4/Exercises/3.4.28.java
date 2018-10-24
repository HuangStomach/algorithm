import edu.princeton.cs.algs4.*;

class LinearProbingHashST<Key, Value> {
    private int N;
    private int M;
    private Key[] keys;
    private Value[] vals;

    public LinearProbingHashST() {
        this(16);
    }

    public LinearProbingHashST(int M) {
        this.M = M;
        keys = (Key[]) new Object[this.M];
        vals = (Value[]) new Object[this.M];
    }

    private int hashA(Key key) {
        int index = key.toString().toUpperCase().charAt(0);
        return (11 * index) % M;
    }

    private int hashB(Key key) {
        int index = key.toString().toUpperCase().charAt(0);
        return (17 * index) % M;
    }

    public void put(Key key, Value val) {
        // if (N >= M / 2) resize(2 * M);

        int i, j;
        for (i = hashA(key), j = hashB(key); keys[i] != null && keys[j] != null; i = (i + 3) % M, j = (j + 3) % M) {
            if (keys[i].equals(key)) {
                vals[i] = val;
                return;
            }
            if (keys[j].equals(key)) {
                vals[j] = val;
                return;
            }
        }
        int k;
        if (keys[i] == null) k = i;
        else k = j;

        keys[k] = key;
        vals[k] = val;
        N++;
    }

    public void print() {
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] == null) System.out.print(". ");
            else System.out.print(keys[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String test = "E A S Y Q U T I O N";
        String[] keys = test.split("\\s+");
        int n = keys.length;
        
        LinearProbingHashST<String, Boolean> st = new LinearProbingHashST(11);
        for (int i = 0; i < n; i++) {
            st.put(keys[i], true);
            st.print();
            System.out.println("----");
        }
    }
}