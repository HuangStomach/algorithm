import edu.princeton.cs.algs4.*;

class SubMatch {
    public static void main(String[] args) {
        In in = new In(args[0]);
        TST<String> tst = new TST<String>();

        while (!in.isEmpty()) {
            String str = in.readString();
            int length = str.length();
            for (int i = 0; i < length - 1; i++) {
                tst.put(str.substring(i, length - 1), str);
            }
        }

        
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            for (String key: tst.keysWithPrefix(s)) {
                System.out.println(tst.get(key));
            }
        }
    }
}
