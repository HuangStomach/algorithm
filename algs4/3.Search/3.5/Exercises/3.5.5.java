public class RedBlackBST<Value> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private Node root;

    private class Node {
        int key;
        Value val;
        Node left;
        Node right;
        int N;
        boolean color;

        Node(int key, Value val, int N, boolean color) {
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
    
    public boolean isEmpty() {
        return root == null;
    }

    private boolean isRed(Node x) {
        if (x == null) return false;
        return x.color == RED;
    }

    private void flipColors(Node h) {
        h.color = !h.color;
        h.left.color = !h.left.color;
        h.right.color = !h.right.color;
    }

    private Node balance(Node h) {
        if (isRed(h.right)) h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right)) flipColors(h);

        h.size = size(h.left) + size(h.right) + 1;
        return h;
    }

    private Node movedRedLeft(Node h) {
        flipColors(h);
        if (isRed(h.right.left)) {
            h.right = rotateRight(h.right);
            h = rotateLeft(h);
        }
        return h;
    }

    private Node movedRedRight(Node h) {
        flipColors(h);
        if (!isRed(h.left.left)) h = rotateRight(h);
        return h;
    }

    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;

        x.color = h.color;
        h.color = RED;

        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
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

    public Value get(int key) {
        return get(root, key);
    }

    private Value get(Node node, int key) {
        if (node == null) return null;
        int cmp = key - node.key;
        if (cmp < 0) return get(node.left, key);
        else if (cmp > 0) return get(node.right, key);
        else return node.val;
    }

    public void put(int key, Value val) {
        root = put(root, key, val);
        root.color = BLACK;
    }

    private Node put(Node h, int key, Value val) {
        if (h == null) return new Node(key, val, 1, RED);

        int cmp = key - h.key;
        if (cmp < 0) h.left = put(h.left, key, val);
        else if (cmp > 0) h.right = put(h.right, key, val);
        else h.val = val;

        if (isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right)) flipColors(h);

        h.N = 1 + size(h.left) + size(h.right);
        return h;
    }

    public void delete(int key) {
        if (!isRed(root.left) && !isRed(root.right)) root.color = RED;
        root = delete(root, key);
        if (!isEmpty()) root.color = BLACK;
    }

    public Node delete(Node h, int key) {
        if (key - h.key < 0) {
            if (!isRed(h.left) && !isRed(h.left.left)) h = movedRedLeft(h);
            h.left = delete(h.left, key);
        }
        else {
            if (isRed(h.left)) h = rotateRight(h);
            if (key == h.key && (h.right == null)) return null;
            if (!isRed(h.right) && !isRed(h.right.left)) h = movedRedRight(h);
            if (key == h.key) {
                h.val = get(h.right, min(h.right).key);
                h.key = min(h.right).key;
                h.right = deleteMin(h.right);
            }
            else h.right = delete(h.right, key);
        }
        return balance(h);
    }

    public void deleteMin() {
        if (!isRed(root.left) && !isRed(root.right)) root.color = RED;
        root = deleteMin(root);
        if (!isEmpty()) root.color = BLACK;
    }

    private Node deleteMin(Node h) {
        if (h.left == null) return null;
        if (!isRed(h.left) && !isRed(h.left.left)) h = movedRedLeft(h);
        h.left = deleteMin(h.left);
        return balance(h);
    }

    public void deleteMax() {
        if (!isRed(root.left) && !isRed(root.right)) root.color = RED;
        root = deleteMax(root);
        if (!isEmpty()) root.color = BLACK;
    }

    private Node deleteMax(Node h) {
        if (isRed(h.left)) h = rotateRight(h);
        if (h.right == null) return null;
        if (!isRed(h.right) && !isRed(h.right.left)) h = movedRedRight(h);
        h.right = deleteMax(h.right);
        return balance(h);
    }

    public int min() {
        return min(root).key;
    }

    private Node min(Node node) {
        if (node.left == null) return node;
        return min(node.left);
    }

    public int max() {
        return max(root).key;
    }

    private Node max(Node node) {
        if (node.right == null) return node;
        return max(node.right);
    }

    public int floor(int key) {
        Node node = floor(root, key);
        if (node == null) return null;
        return node.key;
    }

    public Node floor(Node node, int key) {
        if (node == null) return null;
        int cmp = key - node.key;
        if (cmp == 0) return node;
        else if (cmp < 0) return floor(node.left, key);
        Node t = floor(node.right, key);
        if (t != null) return t;
        else return node;
    }

    public int ceiling(int key) {
        Node node = floor(root, key);
        if (node == null) return null;
        return node.key;
    }

    public Node ceiling(Node node, int key) {
        if (node == null) return null;
        int cmp = key - node.key;
        if (cmp == 0) return node;
        else if (cmp > 0) return ceiling(node.right, key);
        Node t = ceiling(node.left, key);
        if (t != null) return t;
        else return node;
    }

    public int select(int k) {
        return select(root, k).key;
    }

    private Node select(Node node, int k) {
        if (node == null) return null;
        int t = size(node.left);
        if (t > k) return select(node.left, k);
        else if (t < k) return select(node.right, k - t - 1);
        else return node;
    }

    public int rank(int key) {
        return rank(key, root);
    }

    private int rank(int key, Node node) {
        if (node == null) return 0;
        int cmp = key - node.key;
        if (cmp < 0) return rank(key, node.left);
        else if (cmp > 0) return 1 + size(node.left) + rank(key, node.right);
        else return size(node.left);
    }
}