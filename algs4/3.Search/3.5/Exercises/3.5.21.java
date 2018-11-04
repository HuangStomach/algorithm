import edu.princeton.cs.algs4.*;

class InvertedConcordance {

    public static void main(String[] args) {
        In in = new In(args[0]);
        String[] words = in.readAllStrings();
        ST<String, SET<Integer>> st = new ST<String, SET<Integer>>();

        // build up concordance
        for (int i = 0; i < words.length; i++) {
            String s = words[i];
            if (!st.contains(s)) {
                st.put(s, new SET<Integer>());
            }
            SET<Integer> set = st.get(s);
            set.add(i);
        }
        System.out.println("Finished building concordance");
        invertedConcordance(st);
    }

    public static void invertedConcordance(ST<String, SET<Integer>> st) {
        RedBlackBST<Integer, String> bst = new RedBlackBST();

        for (String key: st.keys()) {
            for (int index: st.get(key)) {
                bst.put(index, key);
            }
        }

        while (bst.size() > 0) {
            System.out.print(bst.get(bst.min()) + " ");
            bst.deleteMin();
        }
        System.out.println();
    }
}