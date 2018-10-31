import edu.princeton.cs.algs4.*;

class Test {
    public static void main(String[] args) {
        ST<String, Bag<String>> st = new ST();
        invert(st);
    }

    public ST<Bag<String>, String> invert (ST<String, Bag<String>> st) {
        ST<Bag<String>, String> bagST = new ST();
        for (String key: st.keys()) {
            bagST.put(key, st.get(key));
        }
        return bagST;
    }
}