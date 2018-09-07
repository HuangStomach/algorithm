public class BST<Key extends Comparable<Key>, Value> {
    private Node root;
    private class Node {
        private Key key;
        private Value value;
        private Node left, right;
        private int N;
        public Node (Key key, Value val, int N) {
            this.key = key;
            this.value = val;
            this.N = N;
        }

        public int size() {
            return size(root);
        }

        public int size(Node node) {
            if (x == null) return 0;
            else return x.N;
        }
    }
}