import java.util.Random;

class RedBlackBST<Key extends Comparable<Key>, Value> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private Node root;

    private class Node {
        Key key;
        Value val;
        Node left;
        Node right;
        int N;
        boolean color;

        Node(Key key, Value val, int N, boolean color) {
            this.key = key;
            this.val = val;
            this.N = N;
            this.color = color;
        }
    }

    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) return 0;
        else return node.N;
    }

    public int length() {
        return length(root, 0);
    }

    private int length(Node node, int l) {
        if (node == null) return l;
        l++;
        int left = length(node.left, l);
        int right = length(node.right, l);
        return left + right;
    }

    private boolean isRed(Node x) {
        if (x == null) return false;
        return x.color == RED;
    }

    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;

        x.color = h.color;
        h.color = RED;

        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }

    private void flipColors(Node h) {
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node node, Key key) {
        if (node == null) return null;
        int cmp = key.compareTo(node.key);
        if (cmp < 0) return get(node.left, key);
        else if (cmp > 0) return get(node.right, key);
        else return node.val;
    }

    public void put(Key key, Value val) {
        root = put(root, key, val, BLACK);
        root.color = BLACK;
    }

    private Node put(Node h, Key key, Value val, boolean color) {
        if (h == null) return new Node(key, val, 1, color ? BLACK : RED);

        int cmp = key.compareTo(h.key);
        if (cmp < 0) h.left = put(h.left, key, val, h.color);
        else if (cmp > 0) h.right = put(h.right, key, val, h.color);
        else h.val = val;

        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right)) flipColors(h);

        h.N = 1 + size(h.left) + size(h.right);
        return h;
    }

    public Key min() {
        return min(root).key;
    }

    private Node min(Node node) {
        if (node.left == null) return node;
        return min(node.left);
    }

    public Key max() {
        return max(root).key;
    }

    private Node max(Node node) {
        if (node.right == null) return node;
        return max(node.right);
    }

    public Key floor(Key key) {
        Node node = floor(root, key);
        if (node == null) return null;
        return node.key;
    }

    public Node floor(Node node, Key key) {
        if (node == null) return null;
        int cmp = key.compareTo(node.key);
        if (cmp == 0) return node;
        else if (cmp < 0) return floor(node.left, key);
        Node t = floor(node.right, key);
        if (t != null) return t;
        else return node;
    }

    public Key ceiling(Key key) {
        Node node = floor(root, key);
        if (node == null) return null;
        return node.key;
    }

    public Node ceiling(Node node, Key key) {
        if (node == null) return null;
        int cmp = key.compareTo(node.key);
        if (cmp == 0) return node;
        else if (cmp > 0) return ceiling(node.right, key);
        Node t = ceiling(node.left, key);
        if (t != null) return t;
        else return node;
    }

    public Key select(int k) {
        return select(root, k).key;
    }

    private Node select(Node node, int k) {
        if (node == null) return null;
        int t = size(node.left);
        if (t > k) return select(node.left, k);
        else if (t < k) return select(node.right, k - t - 1);
        else return node;
    }

    public int rank(Key key) {
        return rank(key, root);
    }

    private int rank(Key key, Node node) {
        if (node == null) return 0;
        int cmp = key.compareTo(node.key);
        if (cmp < 0) return rank(key, node.left);
        else if (cmp > 0) return 1 + size(node.left) + rank(key, node.right);
        else return size(node.left);
    }

    public static void main(String[] args) {
        int length = 0;
        for (int i = 0; i < 100; i++) {
            RedBlackBST<Integer, Boolean> bst = new RedBlackBST<Integer, Boolean>();
            for (int j = 0; j < 127; j++) {
                Random rn = new Random();
                bst.put(Integer.valueOf(rn.nextInt()), true);
            }
            length += bst.length();
        }

        System.out.println("大小为128的树平均路径长度为: " + length / 100);
    }
}