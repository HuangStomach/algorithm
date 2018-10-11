public class TwoThreeST<Key extends Comparable<Key>, Value> {
    private TwoNode root;

    private class TwoNode {
        Key key;
        Value val;
        Node left;
        Node right;
        int N;

        Node(Key key, Value val, int N) {
            this.key = key;
            this.val = val;
            this.N = N;
        }
    }

    private class ThreeNode {
        Key[] key;
        Value[] val;
        Node left;
        Node middle;
        Node right;
        int N;

        Node(Key[] key, Value[] val, int N) {
            this.key = key;
            this.val = val;
            this.N = N;
        }
    }
    
}