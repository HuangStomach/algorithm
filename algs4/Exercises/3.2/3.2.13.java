import edu.princeton.cs.algs4.*;

public class BST<Key extends Comparable<Key>, Value> {
    private Node root;
    private class Node {
        private Key key;
        private Value val;
        private Node left, right;
        private int N;
        public Node (Key key, Value val, int N) {
            this.key = key;
            this.val = val;
            this.N = N;
        }
    }

    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) return 0;
        else return node.N;
    }

    public int avgCompares() {
        return length(root, 0) / size() + 1;
    }

    private int length(Node node, int l) {
        if (node == null) return l;
        l++;
        int left = length(node.left, l);
        int right = length(node.right, l);
        return left + right;
    }

    public Value get(Key key) {
        Node node = root;
        while (node != null) {
            int cmp = key.compareTo(node.key);
            if (cmp == 0) return node.val;
            else if (cmp < 0) node = node.left; 
            else node = node.right;
        }
        return null;
    }

    public void put(Key key, Value val) {
        Node node = root;
        Node parent;
        while (node != null) {
            parent = node;
            int cmp = key.compareTo(node.key);
            if (cmp == 0) {
                node.val = val;
                return;
            }
            else if (cmp < 0) node = node.left; 
            else node = node.right;
        }

        // 证明是新节点
        int cmp = key.compareTo(parent.key);
        if (cmp < 0) parent.left = new Node(key, val, ++N); 
        else parent.right = new Node(key, val, ++N); 

        // 再更新一遍计数
        node = root;
        while (node != null) {
            node.N = size(node.left) + size(node.right) + 1;
            cmp = key.compareTo(node.key);
            if (cmp == 0) break;
            else if (cmp < 0) node = node.left; 
            else node = node.right;
        }
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

    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node node) {
        if (node.left == null) return node.right;
        node.left = deleteMin(node.left);
        node.N = size(node.left) + size(node.right) + 1;
        return node;
    }

    public void delete(Key key) {
        root = delete(root, key);
    }

    private Node delete(Node node, Key key) {
        if (node == null) return null;
        int cmp = key.compareTo(node.key);
        if (cmp < 0) node.left = delete(node.left, key);
        else if (cmp > 0) node.right = delete(node.right, key);
        else {
            if (node.right == null) return node.left;
            if (node.left == null) return node.right;
            Node t = node;
            node = min(t.right);
            node.right = deleteMin(t.right);
            node.left = t.left;
        }
        node.N = size(node.left) + size(node.right) + 1;
        return node;
    }

    public Iterable<Key> keys() {
        return keys(min(), max());
    }

    public Iterable<Key> keys(Key low, Key high) {
        Queue<Key> q = new Queue<Key>();
        keys(root, q, low, high);
        return q;
    }

    private void keys(Node node, Queue<Key> q, Key low, Key high) {
        if (node == null) return;
        int cmpLow = low.compareTo(node.key);
        int cmpHigh = high.compareTo(node.key);
        if (cmpLow < 0) keys(node.left, q, low, high);
        if (cmpLow <= 0 && cmpHigh >= 0) q.enqueue(node.key);
        if (cmpHigh > 0) keys(node.right, q, low, high);
    }
}
