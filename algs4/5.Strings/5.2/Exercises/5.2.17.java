import edu.princeton.cs.algs4.*;

class SpellChecker {
    public static void main(String[] args) {
        In dict = new In(args[0]);

        TST<Integer> tst = new TST<String>();
        while (!dict.isEmpty()) {
            tst.put(dict.readString(), 1);
        }

        while (!StdIn.isEmpty()) {
            String key = StdIn.readString();
            if (!tst.contains(key)) System.out.println(key + "拼写错误");
        }
    }
}
